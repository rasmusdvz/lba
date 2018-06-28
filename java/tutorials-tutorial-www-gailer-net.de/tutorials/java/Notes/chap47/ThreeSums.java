import java.io.* ;

class ThreeSums
{

  public static void main ( String[] args ) throws IOException
  {
    int[] data = {1,1,1,1,1,2,2,2,2,2};
    
    // declare and initialize three sums
    int sumAll = 0;
    int sumOdd = 0;
    int sumEve = 0;
    
    // compute the sums
    for ( int index=0; index < data.length; index++)
    {
      sumAll += data[index];
      if ( data[index]%2 == 0 ) sumEve += data[index];
      else                      sumOdd += data[index];
    }
      
    // write out the three sums
    System.out.println( "Sums all, even, odd: " 
        + sumAll + ", " + sumEve + ", " + sumOdd );

  }
}      
