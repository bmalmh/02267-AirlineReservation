/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightObjects;
import java.math.BigDecimal;

/**
 *
 * @author Bruger
 */
public class FlightListData {
    
    public String bookingNumber;
    public String airlineService;
    public FlightData flight;
    public int price;
    
    public FlightListData( String bookingNumber, String airlineService, FlightData flight, int price){
        
        this.bookingNumber = bookingNumber;
        this.airlineService = airlineService;
        this.flight = flight;
        this.price = price;
    
    }
    
}
