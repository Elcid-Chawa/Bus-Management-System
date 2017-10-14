/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busmansystem;

/**
 *
 * @author tseliso
 */

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class QueryDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/bussystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //Prepare Datatbase connections and queries
    private Connection con = null;
    private PreparedStatement selectAllCities = null;
    private PreparedStatement selectAllClients = null;
    private PreparedStatement selectBusInfo = null;
    private PreparedStatement addClient = null;
    private PreparedStatement boarding = null;
    private PreparedStatement report = null;
    
    // QueryDatabase constructor
    public QueryDatabase(){
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // create query to select all Cities
            selectAllCities = con.prepareStatement("SELECT * FROM city");
            selectAllClients = con.prepareStatement("SELECT * FROM client");
            selectBusInfo = con.prepareStatement("SELECT * FROM bustable");
            
            addClient = con.prepareStatement("INSERT INTO client (clientID, fname, lname, phone) VALUES (?,?,?,?)");
            
            boarding = con.prepareStatement("INSERT INTO boards (clientID, busID, seatNumber, toCity, travelDate)"
                                            +"VALUES (?, ?, ?, ? , ?) ");
            
            report = con.prepareStatement("SELECT client.fname, client.lname as Names, boards.busID as Bus" 
                                           + "FROM client, boards" 
                                           + "WHERE client.clientID = boards.clientID and boards.busID = ? ");
            
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    // select all Cities from Database
    public List< City > getCities() {
        List < City > cities = null;
        ResultSet rs = null;
        try
        {
            rs = selectAllCities.executeQuery();
            cities = new ArrayList<City>();
            
            while(rs.next()){
                cities.add(new City(rs.getString("name"), rs.getString("cityID")));
            }
       } catch(SQLException e){
           e.printStackTrace();
           System.exit(1);
       }
        return cities;
    } // end getCities Method
    
    // select all buses to Database
    public List<Buses> getBuses() {
        List<Buses> buses = null;
        ResultSet rs = null;
        
        try{
            rs = selectBusInfo.executeQuery();
            buses = new ArrayList<Buses>();
            
            while(rs.next()){
                buses.add(new Buses(rs.getString("busID"), rs.getString("bustype"), rs.getInt("seatcap")));
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
        return buses;
    }
    
    // addClients to database
    public Client insertClient(String id, String fname, String lname, int phone){
        Client result = new Client(id, fname, lname, phone);
        
        // set parameters, then execute addClient
        try {
       
            addClient.setString(1, id);
            addClient.setString(2, fname);
            addClient.setString(3, lname);
            addClient.setInt(4, phone);
            
            addClient.execute();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.exit(1);
        }
        result.setClientID(id);
        result.setFirstName(fname);
        result.setlastName(lname);
        return result;
    } // end client insert
    
    // Book client travel
    public void bookClient(String cid, String bid, int sNumber, String city, java.sql.Date date){
        try {
            boarding.setString(1, cid);
            boarding.setString(2, bid);
            boarding.setInt(3, sNumber);
            boarding.setString(4, city);
            boarding.setDate(5, date);
            
            boarding.execute();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.exit(1);
        }
    } // end bookClient
    
    // get client reservation info
    public void getReservation(){
        
    }// end getReservation
   
    // display cities
    public static void main(String[] args){
        List<City> cities = new ArrayList<City>();
        List<Buses> buses = new ArrayList<Buses>();
        Client paul =  new Client("","","",0);
        
        QueryDatabase query = new QueryDatabase();
        cities = query.getCities();
        buses = query.getBuses();
        paul = query.insertClient("123", "Paul", "Sandria", 5678);
        query.bookClient("123", "sw123", 4, "SW125", new java.sql.Date(2017/10/9));
        
        
        for (City c : cities){
            System.out.println(c.getCity());}
        
        for (Buses b : buses){
            System.out.println(b.getBusID() + " " + b.getBusSeatCapacity());
        }
        
       System.out.println("Successfull");
       System.out.println("Firstname: " + paul.getFirstName() + "\n LastName: " + paul.getLastName());
       System.out.println("");
    }
    
}
