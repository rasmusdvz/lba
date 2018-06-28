

     import java.applet.Applet;
     import java.awt.*;

     // assume that the drawing area is 300 by 150
     public class tenCircles extends Applet
     {
       final int width = 300, height = 150;

       public void paint ( Graphics gr )
       { 
         setForeground( Color.red );

         int count =  0 ;
         while (  count < 10  )
         {
           int radius = (width/10)/2;

           int X      = count*(width/10);
       
           int Y      = height/2 - radius;

           gr.drawOval( X, Y, 2*radius, 2*radius );
           count = count + 1; 
         }

       }
     }