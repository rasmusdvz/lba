import java.io.*;
class Switcher
{
  public static void main ( String[] args ) throws IOException
  {
    String lineIn;
    char   color  ;    
    String message = "Color is";
    
    BufferedReader stdin = new BufferedReader
      ( new InputStreamReader(System.in) );

    System.out.println("Enter a color letter:");
    lineIn = stdin.readLine();
    color = lineIn.charAt( 0 );  // get the first character

    switch ( color )
    {
    
      case 'r':
      case 'R':
        message = message + " red" ;
        break;
               
      case 'o':                  
      case 'O':
        message = message + " orange" ;
        break;
               
      case 'y':                  
      case 'Y':
        message = message + " yellow" ;
        break;
               
      case 'g':                  
      case 'G':
        message = message + " green" ;
        break;
               
      case 'b':  
      case 'B':
        message = message + " blue" ;
        break;
               
      case 'v':  
      case 'V':
        message = message + " violet" ;
        break;
                        
      default:
        message = message + " unknown" ;
            
    }

  System.out.println ( message ) ;
  }
}
