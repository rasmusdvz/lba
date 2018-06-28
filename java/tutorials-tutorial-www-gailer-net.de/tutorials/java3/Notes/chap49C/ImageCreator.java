import java.io.* ;

class ImageCreator
{

  public static void main ( String[] args ) throws IOException
  {
    final int size=64;
    
    for ( int row=0; row<size; row++ )
      for ( int col=0; col<size; col++ )
        System.out.println( (row/8)*8 );
  }
}      
