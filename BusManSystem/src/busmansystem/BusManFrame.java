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

import java.awt.FlowLayout;
import javax.swing.JFrame;


public class BusManFrame extends JFrame{
    private Login login;
    
    BusManPanel systemPanel;
    
    // constructor for BusManFrame
    public BusManFrame(){
        
        super( "Bus Management System" );
        
        login = new Login(this, true);
               
       setLayout ( new FlowLayout() );
       systemPanel = new BusManPanel();
       add( systemPanel );
    }
    
    
    public static void main( String[] args){
        BusManFrame busSystem = new BusManFrame();
        busSystem.login.setVisible(true);
        busSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        busSystem.setSize(1024,768);
        busSystem.setVisible(true);
    }
    
}
