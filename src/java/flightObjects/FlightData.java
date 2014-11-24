/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightObjects;

/**
 *
 * @author Bruger
 */
public class FlightData {
    
    public String startAirport;  // Start location
    public String destAirport;   // End Location
    public String liftoffDate;    //  Date of departure
    public String arrivalDate;       // Date of arrival
    public String carrier;      // Flight Company Name
    
    /**
     *
     * @param startAirport
     * @param destAirport
     * @param liftoffDate
     * @param arrivalDate
     * @param carrier
     */
    public FlightData(String startAirport, String destAirport, String liftoffDate, String arrivalDate, String carrier){
        
        this.startAirport = startAirport;
        this.destAirport = destAirport;
        this.liftoffDate = liftoffDate;
        this.arrivalDate = arrivalDate;
        this.carrier = carrier;
    }
    
    
    
}
