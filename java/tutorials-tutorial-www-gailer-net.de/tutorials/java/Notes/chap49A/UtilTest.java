// Array Example
//
class ArrayUtil
{
  void print ( int[] x )
  {
    for (int j=0; j < x.length; j++)
      System.out.print( x[j] + " " );
    System.out.println( );
  }

  void print ( char[] x )
  {
    for (int j=0; j < x.length; j++)
      System.out.print( x[j] + " " );
    System.out.println( );
  }

  boolean equals ( int[] x, int[]y )
  {
    if ( x.length != y.length ) return false;

    for ( int j=0; j<x.length; j++ )
      if ( x[j] != y[j] ) return false;

    return true;
  }

  void reverse ( int[] x )
  {
    for ( int j=0; j <= x.length/2; j++ )
    {
      int temp = x[j];
      x[j] = x[ x.length-j-1 ];
      x[ x.length-j-1 ] = temp;
    }
  }

  void spread ( char[] z, String st )
  {
    if ( z.length != st.length() ) return;

    for ( int j=0; j < z.length; j++ )
      z[j] = st.charAt( j );
    
  }

}
 
class UtilTest
{
  public static void main(String[] args)
  {
    ArrayUtil util = new ArrayUtil();
    int[] s = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19} ;
    int[] t = {27, 19, 34, 5, 12} ;
    
    util.print(s );
    util.reverse( s );
    util.print(s );
    if ( util.equals( s, t ) )
      System.out.println( "Arrays are equal" );
    else
      System.out.println( "Arrays are NOT equal" );

    String st = "In a hole in the ground there lived a Hobbit." ;
    char[] charry = new char[st.length()];

    util.spread( charry, st );
    util.print( charry );
  }
}
