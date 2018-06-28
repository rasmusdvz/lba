import java.io.*;

class CopyMaker
{
  String sourceName, destName;
  BufferedReader source;
  PrintWriter dest;
  String line;

  CopyMaker ( String source, String dest )
  {
    sourceName = source;
    destName   = dest;
  }

  private boolean openFiles()  // return true if files open, else false
  {
    // open the source
    try
    {      
      source = new BufferedReader(new FileReader( sourceName ));
    }
    catch ( IOException iox )
    {
      System.out.println("Problem opening " + sourceName );
      return false;
    }
    // open the destination
    try
    {      
      dest = new PrintWriter( new BufferedWriter(new FileWriter( destName )) );
    }
    catch ( IOException iox )
    {
      System.out.println("Problem opening " + destName );
      return false;
    }
    return true;
  }

  private void copyFiles()  // return true if copy worked, else false
  {
    try
    {      
      line = source.readLine();
      while ( line != null )
      {
        dest.println(line);
        line = source.readLine();
      }
    }
    catch ( IOException iox )
    {
      System.out.println("Problem reading or writing" );
    }
  }

  private void closeFiles()  //return true if files close, else false
  {
    // close the source
    try
    {      
      source.close();
    }
    catch ( IOException iox )
    {
      System.out.println("Problem closing " + sourceName );
    }
    // close the destination
    dest.close();
  }

  public static void main ( String[] args ) 
  {
    if ( args.length == 3 && args[1].toUpperCase().equals("TO") )
    {
      CopyMaker cp = new CopyMaker( args[0], args[2] );
      if ( cp.openFiles() )
      {
        cp.copyFiles() ; 
        cp.closeFiles() ;
       }
    }
    else
      System.out.println("java CopyTextFile source to destination");
  }

}
