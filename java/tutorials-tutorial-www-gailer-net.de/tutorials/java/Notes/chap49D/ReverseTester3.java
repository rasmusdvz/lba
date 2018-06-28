public class ReverseTester3
{

  public static String reverse( String data )
  {
    StringBuffer temp = new StringBuffer( );

    for ( int j=data.length()-1; j >= 0; j-- )
      temp.append( data.charAt(j) );

    return temp.toString();
  }

  public static void main ( String[] args )
  {
    if ( args.length > 0 )
      System.out.println( reverse( args[0] ) );
  }
}
