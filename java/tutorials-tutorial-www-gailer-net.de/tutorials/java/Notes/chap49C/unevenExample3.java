class unevenExample3
{
  public static void main( String[] arg )
  {
    // declare and construct a 2D array
    int[][] uneven ;

    uneven = new int[3][];

    uneven[0] = new int[3];

    int[] x = {0, 2};
    uneven[1] = x;

    int[] y = {};
    uneven[2] = y;

    // print out the array
    for ( int row=0; row < uneven.length; row++ )
    {
      if ( uneven[ row ] == null )
      	System.out.println ("row" + row + " is null");

      if ( uneven[ row ] != null )
      	System.out.println ("row" + row + " not null");

      System.out.print("Row " + row + ": ");
      for ( int col=0; col < uneven[row].length; col++ )
        System.out.print( uneven[row][col] + " ");
      System.out.println();
    }

		if ( uneven[ 2 ] == null )
    	System.out.println ("\n uneven[2]: " + uneven[2] );

  }
}
