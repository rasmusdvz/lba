import java.io.* ;

class CoffeeAverage
{
  public static void main ( String[] args ) throws IOException
  {
    int      size;
    double[] data;
    double   average;

    BufferedReader inData = 
        new BufferedReader 
          ( new InputStreamReader( System.in ) );

    // input the data
    size = Integer.parseInt( inData.readLine() );
    data = new double[size];
    
    for ( int index=0; index < data.length; index++ )
    {
      data[ index ] = Double.parseDouble( inData.readLine() );
    }
      
    // echo out the data
    for ( int index=0; index < data.length; index++ )
    {
      System.out.println( "data[ " + index + " ] = " + data[ index ] );
    }

    // compute the average
    average = 0.0;
    for ( int index=0; index < data.length; index++ )
    {
      average += data[ index ];
    }
    average /= data.length;
    System.out.println( "average: " + average );

    // determine the index of the element farthest from the average
    int maxIndex = 0;
    double max = 0.0;
    for ( int index=0; index < data.length; index++ )
    {
      if ( Math.abs( data[index]-average ) > max )
      {
        max = Math.abs( data[index]-average ) ;
        maxIndex = index;
      }
    }
    System.out.println( "most distant value: " + data[maxIndex] );
    data[maxIndex] = -1;

    // compute the new average
    average = 0.0;
    for ( int index=0; index < data.length; index++ )
    {
      if ( data[ index ] != -1 )
        average += data[ index ];
    }
    average /= data.length;
    System.out.println( "new average: " + average );
    
  }
}      

