import java.applet.Applet;
import java.awt.*;

// assume that the drawing area is 350 by 250
public class houseRectangles extends Applet
{

  final int width  = 350, height = 250;
  final int houseX =  65, houseY = 100, houseW = 110, houseH = 110 ;
  final int doorX  = 115, doorY  = 165, doorW  =  25, doorH  =  40 ;
  final int lWindX =  90, lWindY = 115, lWindW =  30, lWindH =  30 ;
  final int rWindX = 130, rWindY = 115, rWindW =  30, rWindH =  30 ;
  final int trunkX = 255, trunkY = 100, trunkW =  10, trunkH = 100 ;
  
  public void paint ( Graphics gr )
  { 
     gr.setColor( Color.orange );
     gr.drawRect( houseX , houseY , houseW, houseH); // house
     gr.drawRect( doorX  , doorY  , doorW , doorH ); // door
     gr.drawRect( lWindX , lWindY , lWindW, lWindH); // lwind
     gr.drawRect( rWindX , rWindY , rWindW, rWindH); // rwind
     gr.fillRect( trunkX , trunkY , trunkW, trunkH); // trunk
  }
}