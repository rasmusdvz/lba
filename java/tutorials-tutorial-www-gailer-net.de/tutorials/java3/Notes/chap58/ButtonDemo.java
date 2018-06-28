import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo extends JFrame
{
  JButton bChange ; // reference to the button object

  // constructor for ButtonDemo
  ButtonDemo() 
  {
    // construct a Button
    bChange = new JButton("Click Me!"); 

    // add the button to the JFrame
    getContentPane().add( bChange );     
  }

  public static void main ( String[] args )
  {
    ButtonDemo frm = new ButtonDemo();
    
    WindowQuitter wquit = new WindowQuitter();
    frm.addWindowListener( wquit );
    
    frm.setSize( 200, 150 );     
    frm.setVisible( true );      
  }
}

class WindowQuitter  extends WindowAdapter
{
  public void windowClosing( WindowEvent e )
  {
    System.exit( 0 );  
  }
}

