/*
 * Class Buses
 * This class creats Bus objects with 
 * the bus tyoe and seat number.
 */
package busmansystem;

/**
 *
 * @author Elcid Chawa
 */
public class Buses {
    
    private String busID; // imples the chassie number of the bus
    private String busType;  // tells the kind of bus and capacity
    private int busSeatCapacity;
    
    
    //Busses constructor
    public Buses(){
            } 
    
    public Buses( String bID, String bType, int seatCapacity){
        setBusID(bID);
        setBusType(bType);
        setBusSeatCapacity(seatCapacity);
    } // end constructor for Buses
    
    // Setters and getters for Buses information
    // (i.e busID, busType and busSeatCapacity).
   
    public void setBusID(String bID){
        busID = bID;
    }
    
    public String getBusID(){
        return busID;
    }
    
      public void setBusType(String bType){
        busType = bType;
    }
    
    public String getBusType(){
        return busType;
    }
    
    public void setBusSeatCapacity(int seatCapacity){
        busSeatCapacity = seatCapacity;
    }
    
    public int getBusSeatCapacity(){
        return busSeatCapacity;
    } 
      
}
