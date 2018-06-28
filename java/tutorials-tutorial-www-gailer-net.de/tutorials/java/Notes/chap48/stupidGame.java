import java.io.*;

class arrayChanger
{

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
    
  void zeroSlot( int[] ar, int slot )
  {
    ar[slot] = 0;
  }

}


// The object of the game is to guess three numbers correct
// in five guesses.
class stupidGame
{

  public static void main ( String[] args ) throws IOException
  {
    BufferedReader stdin = new BufferedReader( 
      new InputStreamReader(System.in) );

    String lineInput;

    int[] wins = { 1, 3, 4, 6, 9, 10 };
    int   correct = 0;
    int   where;

    arrayChanger arch = new arrayChanger();

    System.out.println("Three right out of five guesses wins!");

    for ( int attempt=1; attempt<=5; attempt++ )
    {
      System.out.print("Your guess->");
      System.out.flush();
      lineInput = stdin.readLine();
      int guess = Integer.parseInt( lineInput );

      if ( (where = arch.search( wins, guess ) ) != -1 )
      {
        correct++ ;
        System.out.println("Correct! " + correct + " right so far.");
        arch.zeroSlot( wins, where );
      }
      else
        System.out.println("Wrong.");
    }

    if ( correct >= 3 )
      System.out.println("WINNER!!" );
    else
      System.out.println("not a winner" );

  }

}      
