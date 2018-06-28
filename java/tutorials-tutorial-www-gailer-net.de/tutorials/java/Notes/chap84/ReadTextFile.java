import java.io.*;
class ReadTextFile
{

 public static void main ( String[] args ) 
 {
   String fileName = args[0] ;
   String line;

   try
   {      
     BufferedReader in = new BufferedReader(
         new FileReader( fileName  ) );

     line = in.readLine();
     while ( line != null )
     {
       System.out.println( line );
       line = in.readLine();
     }

     line = in.readLine();

     in.close();
   }
   catch ( IOException iox )
   {
     System.out.println("Problem reading " + fileName );
   }
 }
}