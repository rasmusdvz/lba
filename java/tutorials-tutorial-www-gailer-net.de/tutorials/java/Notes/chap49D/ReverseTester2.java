public class ReverseTester2
{

  public static String reverse( String data )
  {
    char[] temp = new char[ data.length() ];
    int i = 0;

    for ( int j=data.length()-1; j >= 0; j-- )
      temp[i++] += data.charAt(j);

    return new String( temp );
  }

  public static void main ( String[] args )
  {
    if ( args.length > 0 )
      System.out.println( reverse( args[0] ) );
  }
}
