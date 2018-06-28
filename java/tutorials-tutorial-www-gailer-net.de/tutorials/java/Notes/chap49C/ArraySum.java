import java.io.* ;

class ArraySum
{

  public static void main ( String[] args ) throws IOException
  {
    int[][] data = { {3, 2, 5, 7},
                     {1, 4, 4, 8},
                     {9, 1, 0, 2},
                     {0, 2, 6, 3}  };
    
    // declare the sum
    int sum = 0;
    
    // compute the sum
    for ( int row=0; row < data.length; row++)
    {
      for ( int col=0; col <  data[row].length; col++) 
      {
        sum += data[row][col]; 
      }
    }
      
    // write out the sum
    System.out.println( sum );

  }
}      
