/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busmansystem;

import java.sql.Date;

/**
 *
 * @author Elcid Chawa
 */


public class Passenger {
    String names;
    int seat;
    String city;
    String bus;
    Date ddate;
    // Condtructor for
    public Passenger( String n, String b, int s, String c, Date d){
        names = n;
        seat =s;
        city = c;
       this.bus = b;
        ddate = d;
    }
    
    
    public String getNames(){
        return names;
    }
    
    public int getSeat(){
        return seat;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getBus(){
        return bus;
    }
    
    public Date getDate(){
        return ddate;
    }
    
     public void setNames(String n){
        names=n;
    }
    
    public void setSeat(int s){
        seat= s;
    }
    
    public void setCity(String c){
        city=c;
    }
    
    public void setBus(String b){
        bus=b;
    }
    
    public void setDate(Date d){
         ddate = d;
    }
}
