 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu;

import com.google.gson.Gson;
import dk.dtu.imm.fastmoney.BankService;
import dk.dtu.imm.fastmoney.CreditCardFaultMessage;
import dk.dtu.imm.fastmoney.types.AccountType;
import flightObjects.FlightDataCreator;
import flightObjects.FlightListData;
import java.util.ArrayList;

/**
 *
 * 
 */

@javax.jws.WebService
public class AirlineResource {
    
    private AccountType airlineAccount = new AccountType();
    BankService bank = new BankService();
    static ArrayList<FlightListData> mockFlightData = FlightDataCreator.getFlightListData();
    final int group = 1;

    public String getFlight(String startAirport, String destAirport, String liftoffDate) {
        ArrayList<FlightListData> result = new ArrayList<FlightListData>();
        for (FlightListData fld : mockFlightData) {
            if (fld.flight.startAirport.equals(startAirport)) {
                if (fld.flight.destAirport.equals(destAirport)) {
                    if (fld.flight.liftoffDate.equals(liftoffDate)) {
                        result.add(fld);
                    }
                }
            }
        }

        String json = new Gson().toJson(result);
        // Husk at ændre return værdi
        return json;
    }

    
    
    /* The bookFlight operation takes a booking number and creditcard information
     * and perma- nently books the flight after first having charged the 
     * creditcard for the flight using the chargeCreditCard of the bank. 
     * The bookFlight operation returns true, if the booking was successful and 
     * returns a fault (i.e., throws an exception) if the creditcard information 
     * was not valid, there was not enough money on the client account
     * , or if for other reasons the booking fails.
     */
    
    public boolean bookFlight
            (String bookingNumber, 
             dk.dtu.imm.fastmoney.types.CreditCardInfoType creditCard) 
             throws Exception {
        
        ArrayList<FlightListData> result = new ArrayList<FlightListData>();
        for (FlightListData fldl : mockFlightData) {
            if (fldl.bookingNumber.equals(bookingNumber)) {
             try{
                 chargeCreditCard(group, creditCard, fldl.price, airlineAccount);
                 return true;
             } catch(CreditCardFaultMessage e){
                 throw new Exception("Credit card could not be charged for book flight", e);
             }
            }
        }
        throw new Exception("That bookingnumber doesn't exist.");
    }

    public boolean cancelFlight(String bookingNumber, int price,
                                dk.dtu.imm.fastmoney.types.CreditCardInfoType creditCard)
                                throws Exception{
        ArrayList<FlightListData> result = new ArrayList<FlightListData>();
        for (FlightListData fldl : mockFlightData) {
            if (fldl.bookingNumber.equals(bookingNumber)) {
             try{
                 refundCreditCard(group, creditCard, fldl.price, airlineAccount);
                 return true;
             } catch(CreditCardFaultMessage e){
                 throw new Exception("Credit card could not be refunded for book flight", e);
             }
            }
        }
        return false;
    }

    private boolean validateCreditCard(int group, dk.dtu.imm.fastmoney.types.CreditCardInfoType creditCardInfo, int amount) throws CreditCardFaultMessage {
        dk.dtu.imm.fastmoney.BankPortType port = bank.getBankPort();
        return port.validateCreditCard(group, creditCardInfo, amount);
    }

    private boolean refundCreditCard(int group, dk.dtu.imm.fastmoney.types.CreditCardInfoType creditCardInfo, int amount, dk.dtu.imm.fastmoney.types.AccountType account) throws CreditCardFaultMessage {
        dk.dtu.imm.fastmoney.BankPortType port = bank.getBankPort();
        return port.refundCreditCard(group, creditCardInfo, amount, account);
    }

    private boolean chargeCreditCard(int group, dk.dtu.imm.fastmoney.types.CreditCardInfoType creditCardInfo, int amount, dk.dtu.imm.fastmoney.types.AccountType account) throws CreditCardFaultMessage {
        dk.dtu.imm.fastmoney.BankPortType port = bank.getBankPort();
        return port.chargeCreditCard(group, creditCardInfo, amount, account);
    }
}
