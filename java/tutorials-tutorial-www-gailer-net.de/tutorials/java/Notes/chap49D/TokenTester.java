import java.io.*;
import java.util.*;

public class TokenTester
{

  public static void main ( String[] args ) throws IOException
  {
    BufferedReader stdin = 
      new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter a string:");
    String data = stdin.readLine();   
    
    StringTokenizer tok = 
      new StringTokenizer( data, "=+-", true ); // NO space before =

    while ( tok.hasMoreTokens() )
      System.out.println( tok.nextToken().trim() );
  }
}
