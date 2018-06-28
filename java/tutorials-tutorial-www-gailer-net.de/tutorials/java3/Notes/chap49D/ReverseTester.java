public class ReverseTester
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
    if ( args.length > 0 )
      System.out.print( reverse( args[0] ) );
  }
}
