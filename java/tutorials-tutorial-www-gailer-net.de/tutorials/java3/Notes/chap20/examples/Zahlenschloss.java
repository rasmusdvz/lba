import java.io.*;

class Zahlenschloss
{
  public static void main( String[] args ) throws IOException
  {
    int ersteZahl  =  6,
        zweiteZahl = 12,
        dritteZahl = 30;
    int zahl;

    BufferedReader stdin = new BufferedReader(
        new InputStreamReader( System.in ) );
    String input;

    int     versuch  = 0;
    boolean offen    = false;

    while ( versuch < 3 && !offen )
    {
      // Versuch einer Kombination, wenn richtig: setzen der Variable offen auf "true".

      boolean korrekt =  true;

      //Erste Zahl
      System.out.println("\nGeben Sie die erste Zahl ein: ");
      input = stdin.readLine();
      zahl  = Integer.parseInt( input );

      if ( zahl != ersteZahl )
        korrekt = false ;

      //Zweite Zahl
      System.out.println("Geben Sie die zweite Zahl ein: ");
      input = stdin.readLine();
      zahl  = Integer.parseInt( input );

      if ( zahl != zweiteZahl )
        korrekt = false  ;

      //Dritte Zahl
      System.out.println("Geben Sie die dritte Zahl ein: ");
      input = stdin.readLine();
      zahl  = Integer.parseInt( input );

      if ( zahl != dritteZahl )
        korrekt = false  ;

      //Ergebnis
      if ( korrekt )
      {
        System.out.println("Das Schloss öffnet sich.");
        offen = true;
      }
      else
        System.out.println("Das Schloss bleibt zu.");

      versuch = versuch + 1;
    }

  }
}