import java.io.*;

class arrayChanger
{

  void print( int[] x )
  {

    for ( int index=0; index < x.length; index++ )
      System.out.print( x[index] + " " );
    System.out.println();
  }

  void arrayDouble( int[] x )
  {
    for ( int index=0; index < x.length; index++ )
      x[ index ] = 2*x[ index ];     

  }

  // return the index of the slot that holds the target,
  // or -1 if no slot holds the target
  int search( int[] ar, int target )
  {
    int j;
    for ( j=0; j < ar.length && ar[j] != target; j++ ) ;

    if ( j < ar.length )
      return  j;
    else
      return -1;
  }
    
}

class arrayDemo2
{

  public static void main ( String[] args ) 
  {
    arrayChanger arch = new arrayChanger();

    int where;
    int[] ar1 =  { -20, 19, 1, 5, -1, 27, 19, 5 } ;
    System.out.print  ("\nThe array is:" );
    arch.print( ar1 );
    arch.arrayDouble( ar1 );
    System.out.print  ("\nThe array is:" );
    arch.print( ar1 );

    // search for a 54
    if ( (where = arch.search( ar1, 54 ) ) != -1 )
      System.out.print  ("\nThe array holds 54 in slot #" + where);
    else
      System.out.print  ("\nThe array does not holds 54");

  }

}      
