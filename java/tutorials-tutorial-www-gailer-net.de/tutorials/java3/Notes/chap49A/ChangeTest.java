// Array Example
// Array Example
//
class ChangeArray
{
  void print ( int[] x )
  {
    for ( int j=0; j< x.length; j++ )
      System.out.print( x[j] + " " );
    System.out.println( );
  }

  // Copy source to target
  void copy ( int[] source, int[] target )
  {
    for ( int count=0; count < source.length; count++ )
      target[ count ] = source[ count ];
  }
}

class ChangeTest
{
  public static void main ( String[] args )
  {
    ChangeArray cng = new ChangeArray();
    int[] s = {27, 19, 34, 5, 12} ;
    int[] t = new int[ s.length ];
    
    cng.copy( s, t );
    System.out.println( "After copy:" );
    cng.print( t );
  }
}
