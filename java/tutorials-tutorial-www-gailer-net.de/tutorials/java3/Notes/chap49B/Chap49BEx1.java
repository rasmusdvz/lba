import java.io.*;

class PhoneEntry
{
  String name;    // name of a person
  String phone;   // their phone number

  PhoneEntry( String n, String p )
  {
    name = n; phone = p;
  }
}

class PhoneBook
{
  PhoneEntry[] phoneBook;

  PhoneBook()    // constructor
  {
    phoneBook = new PhoneEntry[ 5 ] ;

    phoneBook[0] = new PhoneEntry( "James Barclay", "(418) 665-1223" );
    phoneBook[1] = new PhoneEntry( "Grace Dunbar", "(860) 399-3044" );
    phoneBook[2] = new PhoneEntry( "Paul Kratides", "(815) 439-9271" );
    phoneBook[3] = new PhoneEntry( "Violet Smith", "(312) 223-1937" );
    phoneBook[4] = new PhoneEntry( "John Wood", "(913) 883-2874" );

  }

  PhoneEntry search( String targetName )
  {
    for ( int j=0; j < phoneBook.length; j++ )
    {
      if ( phoneBook[ j ].name.toUpperCase().equals( targetName.toUpperCase() ) )
        return phoneBook[ j ];
    }

    return null;
  }
}

public class Chap49BEx1
{
  public static void main ( String[] args ) throws IOException
  {
    PhoneBook pb = new PhoneBook();
	String search = "";

    do
    {
    	System.out.println("Namen?");
    	BufferedReader stdin =
    	  new BufferedReader(new InputStreamReader(System.in));
		search = stdin.readLine();
		if (search.equals("quit"))
		    	{
		    		System.out.println("goog-bye");
		    		System.exit(0);
		}
    	// search
    	PhoneEntry entry = pb.search( search );

    	if ( entry != null )
    	  System.out.println( entry.name + ": " + entry.phone );
    	else
    	  System.out.println("Name nicht gefunden" );
   	} while (true);

  }
}
