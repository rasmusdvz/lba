import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ButtonDemo2 extends JFrame implements ActionListener
{
  JButton bChange;   
  
  // constructor
  public ButtonDemo2()
  {
    getContentPane().
        setLayout( new FlowLayout() ); // choose the layout manager
    bChange = new JButton("Click Me");// construct a Button
    bChange.addActionListener( this ); // register the ButtonDemo2 object
                                       // as the listener for its Button.
    getContentPane().add( bChange );   // add the button to the container
  }
  
  public void actionPerformed( ActionEvent evt)
  {
    getContentPane().setBackground( Color.blue );
    repaint();   // ask the system to paint the screen.
  }   
  
  public static void main ( String[] args )
  {
    ButtonDemo2 frm = new ButtonDemo2();
   
    WindowQuitter wquit = new WindowQuitter();
    frm.addWindowListener( wquit );
   
    frm.setSize( 200, 150 );
    frm.setVisible( true );
  }
} 

class WindowQuitter extends WindowAdapter
{
  public void windowClosing( WindowEvent e )
  {
    System.exit( 0 );  // what to do for this event--exit the program
  }
}