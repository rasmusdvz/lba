import java.applet.Applet;
import java.awt.*;

public class AnotherHello extends Applet
{
  public void paint ( Graphics gr )
  { 
    setBackground( Color.lightGray );
    gr.drawString("Hello", (300/2 - 40/2), (150/2 -10/2) );
   }
}
