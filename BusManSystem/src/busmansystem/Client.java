/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busmansystem;

/**
 *
 * @author Elcid
 */
public class Client {
    private String clientID;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    
    //constructor
    public Client()
    {
        
    }
    
    // constructor
    public Client(String clientID, String firstName, String lastName, 
            int phoneNumber){
        setClientID(clientID);
        setFirstName(firstName);
        setPhoneNumber(phoneNumber);
    }
    
    public void setClientID(String clientID){
        this.clientID = clientID;
    }
    
    public String getClientId(){
        return clientID;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setlastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public int getPhoneNumber(){
        return phoneNumber;
    }
}
