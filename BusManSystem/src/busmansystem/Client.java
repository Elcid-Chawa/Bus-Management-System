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

    //constructor
    public Client()
    {
        
    }
    
    // constructor
    public Client(String clientID, String firstName, String lastName){
        setClientID(clientID);
        setFirstName(firstName);
        setLastName(lastName);
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
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return lastName;
    } 

}
