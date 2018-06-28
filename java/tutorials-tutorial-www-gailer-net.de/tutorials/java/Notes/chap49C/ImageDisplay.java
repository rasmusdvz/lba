import java.io.* ;

class ImageDisplay
{

  public static void main ( String[] args ) throws IOException
  {
    final int size=64;
    BufferedReader stdin = 
      new BufferedReader(new  InputStreamReader(System.in));
    
    for ( int row=0; row<size; row++ )
    {
      for ( int col=0; col<size; col++ )
      {
        int pixel = Integer.parseInt( stdin.readLine() );
        char ch;
        
        switch ( pixel/8 )
        {
          case 0: ch = ' '; break;
          case 1: ch = '.'; break;
          case 2: ch = '\''; break;
          case 3: ch = '-'; break;
          case 4: ch = '+'; break;
          case 5: ch = 'o'; break;
          case 6: ch = 'O'; break;
          default: ch = 'X'; break;
        }
        System.out.print( ch );
      }
      
      System.out.println();
    }
    
  }
}      
