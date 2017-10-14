/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    // setters and getters for Buses information
    public void setBusID(String bID){
        busID = bID;
    }
    
    public void setBusType(String bType){
        busType = bType;
    }
    
    public void setBusSeatCapacity(int seatCapacity){
        busSeatCapacity = seatCapacity;
    }
    
    public String getBusID(){
        return busID;
    }
    
    public String getBusType(){
        return busType;
    }
    
    public int getBusSeatCapacity(){
        return busSeatCapacity;
    }
}
