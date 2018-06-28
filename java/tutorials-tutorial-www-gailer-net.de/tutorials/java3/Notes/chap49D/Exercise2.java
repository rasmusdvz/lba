import java.util.* ;

public class Exercise2
{

  public static String reverse( String data )
  {
    String rev = new String();

    for ( int j=data.length()-1; j >= 0; j-- )
      rev += data.charAt(j);

    return rev;
  }

  public static void main ( String[] args )
  {
    StringTokenizer tok;
    if ( args.length > 0 )
    {
      tok = new StringTokenizer( args[0], " .,?;!", true );
      while ( tok.hasMoreTokens() )
        System.out.print( reverse( tok.nextToken()) );
    }
  }
}
