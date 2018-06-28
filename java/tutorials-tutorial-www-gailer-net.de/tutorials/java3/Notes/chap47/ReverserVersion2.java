import java.io.* ;

class ReverserVersion2
{

  public static void main ( String[] args ) throws IOException
  {
    int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    int[] result = new int[ data.length ];
    
    // copy the data in reversed order to result
    for ( int j=0; j < result.length; j++)
    {
      result[j] =  data[ result.length -1 -j ];
    }
      
    // write out the result
    for ( int j=0; j < result.length; j++)
    {
      System.out.print( result[j] + (j<result.length-1 ? ", " : "\n") );
    }

  }
}      
