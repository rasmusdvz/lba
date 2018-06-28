import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class ButtonFrame2 extends JFrame implements ActionListener
{
  JButton bChange ; // reference to the button object

  // constructor for ButtonFrame2
  ButtonFrame2(String title) 
  {
    super( title );                   // invoke the JFrame constructor
    setLayout( new FlowLayout() );    // set the layout manager

    // construct a Button
    bChange = new JButton("Click Me!"); 
    
    // register the ButtonFrame2 object as the listener for the JButton.
    bChange.addActionListener( this ); 

    add( bChange );                   // add the button to the JFrame
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
  }
  
  public void actionPerformed( ActionEvent evt)
  {
    getContentPane().setBackground( Color.blue );     // Change the Frame's background
    repaint();  // ask the system to paint the screen.
  }
}

public class ButtonDemo2
{
  public static void main ( String[] args )
  {
    ButtonFrame2 frm = new ButtonFrame2("Button Demo Two");

    frm.setSize( 200, 100 );     
    frm.setVisible( true );   
  }
}
