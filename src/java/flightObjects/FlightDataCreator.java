/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightObjects;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public class FlightDataCreator {

//   DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static ArrayList<FlightListData> getFlightListData() {

        ArrayList<FlightListData> flightListData = new ArrayList<FlightListData>();


        //   DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //   String formattedDate1 = df.format(new Date());


        FlightData flightOne = new FlightData("Heathrow", "Shanghai", "2014-02-23 12:47", "2014-02-24 19:52", "Travel Up");
        FlightData flightTwo = new FlightData("Helsinki", "Tokyo", "2014-04-25 03:44", "2014-02-24 14:30", "SAS");
        FlightData flightThree = new FlightData("Kuala Lumpur", "Accra", "2014-06-27 17:17", "2014-02-28 05:30", "Air Berlin");
        FlightData flightFour = new FlightData("Antartica", "Nassau", "2014-12-24 16:34", "2014-12-25 05:30", "Arctic Airlines");
        
        
        flightListData.add(new FlightListData("SKY-654", "Expedia", flightOne, 3000 ));
        flightListData.add(new FlightListData("SKY-655", "Momondo", flightOne, 3500 ));
        flightListData.add(new FlightListData("SKY-656", "Expedia", flightOne, 3750 ));
       
        flightListData.add(new FlightListData("IKR-102", "Momondo", flightTwo, 1500 ));
        flightListData.add(new FlightListData("IKR-103", "Momondo", flightTwo, 1000 ));
        flightListData.add(new FlightListData("IKR-104", "Momondo", flightTwo, 470 ));
        
        flightListData.add(new FlightListData("PLO-365", "Expedia", flightThree, 2600 ));
        flightListData.add(new FlightListData("PLO-366", "Expedia", flightThree, 1800 ));
        flightListData.add(new FlightListData("PLO-367", "Expedia", flightThree, 1490 ));
        
        flightListData.add(new FlightListData("AHD-854", "Momondo", flightFour, 50000 ));
        flightListData.add(new FlightListData("AHD-855", "Momondo", flightFour, 75000 ));
        flightListData.add(new FlightListData("AHD-856", "Momondo", flightFour, 125000 ));
        

        return flightListData;

    }
}
