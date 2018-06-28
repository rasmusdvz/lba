import java.util.* ;
import java.io.* ;

public class JunkGenerator
{

  public static void main ( String[] args ) throws IOException
  {
    BufferedReader stdin = new BufferedReader(
      new InputStreamReader( System.in ) );

    String line = stdin.readLine();

    while ( line != null )
    {
      StringTokenizer st = new StringTokenizer( line, "*", true );

      while ( st.hasMoreTokens() )
      {
        String token = st.nextToken();
        if ( token.equals("*") )
          System.out.print( args[0] );
        else
          System.out.print( token );
      }
      System.out.println();

      line = stdin.readLine();
    }
  }
}