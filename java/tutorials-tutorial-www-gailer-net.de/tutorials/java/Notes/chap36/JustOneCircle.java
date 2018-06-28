import java.applet.Applet;
import java.awt.*;

// assume that the drawing area is 200 by 200
public class JustOneCircle extends Applet
{
  final int radius = 25;

  public void paint ( Graphics gr )
  { 
    setBackground( Color.lightGray );
    gr.drawOval( 150/2 - radius, 150/2 - radius, radius*2, radius*2 );
   }
}
