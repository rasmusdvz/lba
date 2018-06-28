import java.io.* ;

class ImageSmooth
{

  public static void main ( String[] args ) throws IOException
  {
    int[][] image  = {{0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,5,5,5,5,5,5,5,5,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0}};

    int[][] smooth = new int[ image.length][ image[0].length ];
    
    // compute the smoothed value for each
    // location in the image

    for ( int row=0; row<image.length; row++ )
    {
      for ( int col=0; col<image[row].length; col++ )
      {
        int sum = 0;
        int count = 0;
        for ( int r=(row>0?row-1:0); r<=(row<image.length-1?row+1:row); r++ )
          for ( int c=(col>0?col-1:0); c<=(col<image[r].length-1?col+1:col); c++ )
          {
            sum += image[r][c];
            count++ ;
          }
          
        smooth[row][col] = sum/count;
      }
    }
      
    // write out the input
    System.out.println();
    System.out.println("Input:");
    for ( int row=0; row<image.length; row++ )
    {
      for ( int col=0; col<image[row].length; col++ )
      {
        System.out.print( image[row][col] + " " );
      }
      System.out.println();
    }
    
    // write out the result
    System.out.println();
    System.out.println("Output:");
    for ( int row=0; row<smooth.length; row++ )
    {
      for ( int col=0; col<smooth[row].length; col++ )
      {
        System.out.print( smooth[row][col] + " " );
      }
      System.out.println();
    }

  }
}      
