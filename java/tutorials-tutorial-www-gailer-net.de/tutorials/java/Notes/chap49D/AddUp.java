import java.util.* ;
import java.io.* ;

public class AddUp
{

  public static void main ( String[] args ) throws IOException
  {
    StringTokenizer tok;
    int sum = 0;

    BufferedReader inData = new BufferedReader 
        ( new InputStreamReader( System.in ) );

    System.out.println("Please enter the data:" );
    String inString = inData.readLine();
    tok = new StringTokenizer( inString );

    while ( tok.hasMoreTokens() )
    {
      String intSt = tok.nextToken() ;
      int data     = Integer.parseInt( intSt );
      sum         += data;
    }

    System.out.println("Sum is: " + sum );
  }
}
