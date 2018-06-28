public class unevenExample0
{
  public static void main( String[] arg )
  {

		    // ein 2D Array deklarieren und konstruieren
		    int[][] uneven =
		        { { 1, 9, 4 },
		          { 0, 2},
		          { 0, 1, 2, 3, 4 } };

				uneven[1] = null;
		    // das Array ausgeben
		    for ( int row=0; row < uneven.length; row++ )
		    {
		      System.out.print("Row " + row + ": ");
		      for ( int col=0; col < uneven[row].length; col++ )
		        System.out.print( uneven[row][col] + " ");
		      System.out.println();
    }

  }
}