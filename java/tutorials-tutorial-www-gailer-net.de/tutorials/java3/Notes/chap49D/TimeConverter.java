import java.util.* ;
import java.io.* ;

public class TimeConverter
{

  public static void main ( String[] args ) throws IOException
  {

    if ( args.length == 0 ) return;

    StringTokenizer time = new StringTokenizer( args[0], ":AaPp", true );
    int tokenCount =  time.countTokens() ;

    if ( tokenCount < 3 )
    {
      System.out.println("Bad input format");
      return;
    }

    int hours = Integer.parseInt( time.nextToken().trim() );
    String colon = time.nextToken().trim();
    int minutes = Integer.parseInt( time.nextToken().trim() );

    if ( (hours>12) || (minutes>59) )
    {
      System.out.println("Bad input format.");
      return;
    }

    String amORpm;


    if ( tokenCount == 3 )  // no AM or PM, assume AM
    {
      if ( hours == 12 ) hours = 0;  // 12AM = 00:00
      System.out.println( hours + ":" + minutes);
      return;
    }
    else
    {
      amORpm = time.nextToken().trim().toLowerCase();
      if ( amORpm.equals( "a" ) )
      {
        if ( hours == 12 ) hours = 0;  // 12AM = 00:00
        System.out.println( hours + ":" + minutes);
        return;
      }
      else
      {
        System.out.println( (hours+12) + ":" + minutes);
        return;
      }

    }
    
  }
}