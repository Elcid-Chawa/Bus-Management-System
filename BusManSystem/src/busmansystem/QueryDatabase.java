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

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    private PreparedStatement createPassenger = null;
    private PreparedStatement report = null;
    private PreparedStatement reservation = null;
    private PreparedStatement selectAllPassengers = null;
    private PreparedStatement emptyTable = null;
    
    
    // QueryDatabase constructor
    public QueryDatabase(){
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // create query to select all Cities
            selectAllCities = con.prepareStatement("SELECT * FROM city");
            selectAllClients = con.prepareStatement("SELECT * FROM client");
            selectBusInfo = con.prepareStatement("SELECT * FROM bustable");
            
            addClient = con.prepareStatement("INSERT INTO client (clientID, fname, lname) VALUES (?,?,?)");
            
            createPassenger = con.prepareStatement("INSERT INTO boards (clientID, busID, seatNumber, toCity, travelDate)"
                                            +"VALUES (?, ?, ?, ? , ?) ");

            String test = "SELECT * FROM test " 
                        + "WHERE bus = ? AND ddate= ? AND city = ?"; 
            report = con.prepareStatement(test);// testing the query for result
            
            reservation = con.prepareStatement("INSERT INTO test "
                                            + " SELECT CONCAT(client.fname, ' ', client.lname) AS names, boards.busID, boards.seatNumber, boards.toCity, "
                                            + " boards.travelDate"
                                            + " FROM client "
                                            + " INNER JOIN boards"
                                            + " ON client.clientID = boards.clientID"
                                            + " WHERE boards.busID = ?  AND boards.travelDate = ? AND boards.toCity = ?");
            
            selectAllPassengers = con.prepareStatement("SELECT * FROM test");
            emptyTable = con.prepareStatement("TRUNCATE TABLE test");

            
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    } // end QueryDatabase Constructor
    
 /*
  * This method is used to insert clients
  * to the test table
  */   
// insert values into result table with insert ... select 
    public void makeReservation(String busid, java.sql.Date date, String city){
        try { 
            

            reservation.setString(1, busid);
            reservation.setDate(2, date);
            reservation.setString(3, city);
            reservation.executeUpdate();
            
           // reservation.execute();
            
        } catch (SQLException err){
            err.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error ", 
                    "Invalid query", JOptionPane.PLAIN_MESSAGE);
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
                cities.add(new City(rs.getString("name"), 
                        rs.getString("cityID")));
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
                buses.add(new Buses(rs.getString("busID"), 
                        rs.getString("bustype"), 
                        rs.getInt("seatcap")));
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
        return buses;
    }
    
    // select all Passengers from Database
    public List< Passenger > getAllPassengers() {
        List < Passenger> pass = null;
        ResultSet rs = null;
        try
        {
            rs = selectAllPassengers.executeQuery();
            pass = new ArrayList<Passenger>();
            
            while(rs.next()){
                pass.add(new Passenger(rs.getString("names"), 
                        rs.getString("bus"), rs.getInt("seat"), 
                        rs.getString("city"), rs.getDate("ddate")));
            }
       } catch(SQLException e){
           e.printStackTrace();
           System.exit(1);
       }
        return pass;
    } // end getAllPassenger Method
    
    // select som passengers
     //
    public List<Passenger> getReservation(String busid, java.sql.Date ddate, String city){
         List < Passenger > pass = null;
        ResultSet res = null;
        try{
            report.setString(1, busid);
            report.setDate(2, ddate);
            report.setString(3, city);
            
            res = report.executeQuery();
            pass = new ArrayList<Passenger>();
            
            while(res.next()){
                pass.add(new Passenger(res.getString("names"), 
                        res.getString("bus"), res.getInt("seat"), 
                        res.getString("city"), res.getDate("ddate")));
            }
            //System.out.println("OK");            
            
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("KO");
        }
        return pass;
    } // end test method to select passengers
    
    // addClients to database
    public Client insertClient(String id, String fname, String lname){
        Client result = new Client(id, fname, lname);
        
        // set parameters, then execute addClient
        try {
       
            addClient.setString(1, id);
            addClient.setString(2, fname);
            addClient.setString(3, lname);
            
            addClient.execute();
        }
        catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, 
                    "Client exist in database. Fill other fields!!!", 
                    "Error Booking", JOptionPane.PLAIN_MESSAGE);
            sqlException.printStackTrace();
        }
        result.setClientID(id);
        result.setFirstName(fname);
        result.setLastName(lname);
        return result;
    } // end client insert
    
    // set client reservaation with bookClient method
    public void bookClient(String cid, String bid, int sNumber, String city, java.sql.Date date){
        try {
            createPassenger.setString(1, cid);
            createPassenger.setString(2, bid);
            createPassenger.setInt(3, sNumber);
            createPassenger.setString(4, city);
            createPassenger.setDate(5, date);
            
            createPassenger.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.exit(1);
        }
    } // end bookClient
    
    public void clearTableTest(){
        try {
            emptyTable.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
   
    public static void main(String[] args){
        List<City> cities = new ArrayList<City>();
        List<Buses> buses = new ArrayList<Buses>();
        List<Passenger> passengers = new ArrayList<Passenger>();
        List<Passenger> passengers2 = new ArrayList<Passenger>();
        //Client paul =  new Client("","","");
        
        QueryDatabase query = new QueryDatabase();
        
        cities = query.getCities();
        buses = query.getBuses();
        String bus = "sw123";
        String city = "Limbe";
        java.sql.Date date = new java.sql.Date(2017-10-27);
        //passengers = query.getPassengers("nw125", date);
        
        //query.test("NW125", date); // working
        
        //query.makeReservation("sw123", date);
        
        passengers = query.getAllPassengers();
        passengers2 = query.getReservation(bus, date, city);
        
       // paul = query.insertClient("123", "Paul", "Sandria"); // working
       // query.bookClient("123", "sw123", 4, "SW125", new java.sql.Date(2017-10-9)); // working
        
       // for (City c : cities){
       //    System.out.println(c.getCity());}
        
       // for (Buses b : buses){
       //     System.out.println(b.getBusID() + " " + b.getBusSeatCapacity());
       // }
       
       for (Passenger p : passengers){
           System.out.println(p.getNames() + " " + p.getSeat()
                   + " " + p.getCity());
       }
      
       // query.test("nw125", new java.sql.Date(2017-10-25));
       
       System.out.println("Successfull");
       //System.out.println("Firstname: " + paul.getFirstName() + "\n LastName: " + paul.getLastName());
       
       for (Passenger p2 : passengers2){
           System.out.println(p2.getNames() + " " + p2.getSeat()
                   + " " + p2.getCity());
       }
       
       System.out.println("");
    }
    
}
