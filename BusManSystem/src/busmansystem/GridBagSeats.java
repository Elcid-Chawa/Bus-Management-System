/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busmansystem;

/**
 *
 * @author SUSY
 */

import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;


public class GridBagSeats extends JFrame {
    private final GridBagLayout layout; // layout of this frame
    private final GridBagConstraints constraints; // layout constraints
    
    private  ButtonGroup GridButtonGroup;
    
    List<Buses> buses = new ArrayList<Buses>();
    QueryDatabase query = new QueryDatabase();
    
    JComboBox comboBox;
    JComboBox seatsBox;
    JLabel statusLabel;
    
    int capacity;
    int index;
    Icon green; 
    Icon red; 
        
    
    
    // set up GUI
    public GridBagSeats()
    {
        super("GridBagLayout");
        layout = new GridBagLayout();
        setLayout(layout); //set frame layout
        constraints = new GridBagConstraints(); // instantiate constraints
        
        buses = query.getBuses();
        
        // create GUI components
        
        comboBox = new JComboBox();
        seatsBox = new JComboBox();
        
        statusLabel = new JLabel("", JLabel.CENTER);
        
        for(Buses b : buses){
            comboBox.addItem(b.getBusID());
            seatsBox.addItem(b.getBusSeatCapacity());
        }
        
        green = new ImageIcon( getClass().getResource("/components/images/green.jpg") );
        red = new ImageIcon( getClass().getResource("/components/images/red.jpg") );
        
        //define GUI Components constraints for textField
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        
          
        // combobox -- weightx is 1: fill is BOTH
        constraints.weighty = 0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        addComponent(comboBox); 
        
        //get index from selected bus andset capacity
        comboBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            index = comboBox.getSelectedIndex();
            capacity = buses.get(index).getBusSeatCapacity();
            if(capacity != 0 ){
                
            statusLabel.setText("" + comboBox.getItemAt(comboBox.getSelectedIndex()));
            addComponent(statusLabel);
            final JRadioButton[] buttons = new JRadioButton[capacity];
            GridButtonGroup = new ButtonGroup();
        
        // initialize buttons with label and icons and add to GridButtonGroup
        for (int count =0; count < buttons.length; count++){
            buttons[count] = new JRadioButton();
            buttons[count].setIcon(green);
            buttons[count].setText("" + count);
            buttons[count].setHorizontalTextPosition(JRadioButton.CENTER);
            GridButtonGroup.add(buttons[count]);
        } // end button initalization
        
        // register events for GridGroupButton
        for (int count =0; count < buttons.length; count++){
            buttons[count].addItemListener(
            new ButtonsHandler(buttons[count]));
        }       
        
        // loop buttons to get position
        for (int i=0; i < buttons.length; i++){
            if (4 == i%5){
                constraints.gridwidth = 0;
                addComponent(buttons[i]);
            } else {
               constraints.gridwidth = 1;
               addComponent(buttons[i]); 
            }
            
        }
                }
            else {statusLabel.setText("Selcet a Bus");}
            }
        });
        
        
    } // end GridBagFrame consructor
    
    // private inner class to handle button events
    private class ButtonsHandler implements ItemListener
    {
        private JRadioButton button;
      public ButtonsHandler(JRadioButton b){
          button = b;
      }  
      
      @Override
      public void itemStateChanged(ItemEvent event){
          button.setSelectedIcon(red);
      }
        
    } //  end class ButtonsHandler

    // add a component to the container
    private void addComponent(Component component)
    {
        layout.setConstraints(component, constraints);
        add(component); // add component
    }
    
    public static void main(String[] args)
    {
        GridBagSeats gridBagFrame = new GridBagSeats();
        gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridBagFrame.setSize(300, 200);
        gridBagFrame.setVisible(true);
    }
}
