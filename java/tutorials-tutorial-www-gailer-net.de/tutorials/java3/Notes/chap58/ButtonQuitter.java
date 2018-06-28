import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ButtonQuitter extends JFrame implements ActionListener
{
  JButton bQuit = new JButton("Click here to Exit");   
  
  public ButtonQuitter() 
  {
    getContentPane().setLayout( new FlowLayout() );
    bQuit.addActionListener( this );
    getContentPane().add( bQuit );
  }
  
  public void actionPerformed( ActionEvent evt)
  {
    System.exit( 0 );
  }   
  
  public static void main ( String[] args )
  {
    ButtonQuitter frame = new ButtonQuitter();
   
    frame.setSize( 200, 150 );    
    frame.setVisible( true );        
  }
}