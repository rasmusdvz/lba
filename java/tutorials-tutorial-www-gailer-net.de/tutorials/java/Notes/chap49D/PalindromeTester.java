class Tester
{
  public boolean test( String trial )
  {
    String lower = trial.toLowerCase();

    StringBuffer azBuffer  = new StringBuffer();

    for ( int j=0; j<lower.length(); j++ )
    {
       char c = lower.charAt(j);
       if ( c >= 'a' && c <= 'z' )
         azBuffer.append( c );
    }

    String forward  = azBuffer.toString();
    String backward = azBuffer.reverse().toString();

    if ( forward.equals( backward ) )
      return true;
    else
      return false;
  }
}

public class PalindromeTester
{

  public static void main ( String[] args )
  {
    if ( args.length == 0 )
    {
      System.out.println( "usage: java Palindrome \"Trial String\" " );
      return;
    }

    Tester pTester = new Tester();

    if ( pTester.test( args[0] ) )
      System.out.println( "Is a Palindrome" );
    else
      System.out.println( "Not a Palindrome" );

  }
}
