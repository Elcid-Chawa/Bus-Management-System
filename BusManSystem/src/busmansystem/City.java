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
public class City {
    private  String cityName;
    private  String cityID;
    
    public City(){
        
    }
    
    public  City(String cityNames, String cityIDs){
                setCityName(cityNames);
                setCityID(cityIDs);
                
    }
    
    
    public void setCityName(String City){
        this.cityName = City;
    }
    
    public void setCityID(String cid){
        cityID = cid;
    }
    
    public String getCity(){
        return cityName;
    }
    
    public String getCityId(){
        return cityID;
    }
}
    
    
    

