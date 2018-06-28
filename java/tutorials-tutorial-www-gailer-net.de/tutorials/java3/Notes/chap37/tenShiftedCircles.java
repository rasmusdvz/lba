import java.applet.Applet;
     import java.awt.*;

     // Assume that the drawing area is 300 by 150.
     // Draw ten red circles  across the drawing area.
     public class tenShiftedCircles extends Applet
     {
       final int width = 300, height = 150;

       public void paint ( Graphics gr )
       { 
         setForeground( Color.red );
         int radius = 10; 
         int Y      = height/2 - radius; // the top edge of the squares

         int count =  0 ;
         while (  count < 10  )
         {
           int X      = count*(width/10) + ((width/10)-2*radius)/2;  
           gr.drawOval( X, Y, 2*radius, 2*radius );
           count = count + 1; 
         }
       }
     }