import java.io.*;

/* Hacked upon--possible different from text */

abstract class Card
{
  String recipient;
  int cheer;
  
  public abstract void greeting();
  
  Card()
  {
    super();
    cheer = 12;
  }
}

class Holiday extends Card
{
  public Holiday( String r )
  {
    super();
    recipient = r;
  }

  public void greeting()
  {
    System.out.println("Dear " + recipient + ",\n");
    System.out.println("Your cheer level is: " + cheer );
    System.out.println("Season's Greetings!\n\n");
  }
}

class Birthday extends Card
{
  int age;

  public Birthday ( String r, int years )
  {
    super();
    recipient = r;
    age = years;
  }

  public void greeting()
  {
    System.out.println("Dear " + recipient + ",\n");
    System.out.println("Happy " + age + "th Birthday\n\n");
  }
}

class Valentine extends Card
{
  int kisses;

  public Valentine ( String r, int k )
  {
    super();
    recipient = r;
    kisses    = k;
  }

  public void ending()
  {
    System.out.println("Love, Joe\n");
  }

  public void greeting()
  {
    System.out.println("Dear " + recipient + ",\n");
    System.out.println("Love and Kisses,\n");
    for ( int j=0; j<kisses; j++ )
      System.out.print("X");
    System.out.println("\n\n");
  }
}

public class CardTester
{
  public static void main ( String[] args ) throws IOException
  {
    String me;

    
    BufferedReader input = new BufferedReader( new InputStreamReader(System.in) );
    System.out.println("Your name:");
    me = input.readLine();

    Card hol = new Card(  );
    hol.greeting();

    Card bd = new Birthday( me, 21 );
    bd.greeting();

    Card val = new Valentine( me, 7 );
    val.greeting(); 


  }
}