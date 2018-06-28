import java.util.*;
import java.io.*;
import java.util.regex.*;

/* Lesson.java
|
|  June 03, 2002 ---- creation (from CAIMaker.java)
|
|  June 03, 2002 Formatting tables replaced with <div>
|  July 11, 2002 CSS ID selectors replaced with contextual selectors (class="")
|  July 23, 2002 Revised to Swing
|  July 29, 2002 Modified file name handling
|  July 29, 2006 Changed navigation buttons
|  Aug  19, 2007 Many changes
|  July 01, 2009 put target="_blank" into audio link
|
|  A lesson is the region between the tags <CAI> and </CAI> of the input file
|  and corresponds to one web page. It uses the "chap" references to call
|  methods of the chapter of which it is a part.
|
*/

class Lesson
{
  // date of this program revision
  final private String revisionDate = "08/17/2007" ;
  final private String today = (new Date()).toString();
  
  // icons for navigation put at end of each page
  final private String nextIcon = "<img src=\"../nextIcon.gif\" alt=\"weiter\" title=\"weiter\" />" ;
  final private String backIcon = "<img src=\"../backIcon.gif\" alt=\"zur&uuml;ck\" title=\"zur&uuml;ck\" />" ;
  final private String homeIcon = "<img src=\"../homeIcon.gif\" alt=\"Home\" title=\"Inhalt\" />" ;
  final private String audioIcon = "<img src=\"../audioIcon.gif\" alt=\"Audio\" title=\"Audio\" />" ;
  private String audio = ""; 
  
  // parts of a Lesson
  private String         title     ;
  private Vector<String> prefix    ;  // each element of the vector is a line of the lesson
  private Vector<String> answer    ;
  private Vector<String> text      ; 
  private Vector<String> question  ;

  private int    lessonNo  ;   // number of this lesson.  Numbering starts at 1.
  private String pageFile  ;   // the name of the file this lesson will be written to.
  private String nextFile  ;   // the name of the file for the next lesson.
  private String backFile  ;   // the name of the file for the previous lesson.
  private String homeFile  ;   // the name of the home file.
  
  private Chapter chap     ;   // the Chapter that contains this lesson (and the others.)
 
  Lesson ( String pageName, String backName, String homeName, String nextName, int count, Chapter ch )
  {
    prefix   = new Vector<String>(30) ;
    answer   = new Vector<String>(30) ;
    text     = new Vector<String>(80) ;
    question = new Vector<String>(30) ;

    pageFile = pageName;
    backFile = backName;
    homeFile = homeName;
    nextFile = nextName;
    
    lessonNo = count;
    chap     = ch ;
  }

  // Remove HTML tags from a line of text. Tags look like <xyz> where
  // xyz can be anything.
  //
  String removeTags( String title )
  {
    String fixed = title.replaceAll( "<.*?>", " " );
    return fixed;
  }
    
  // Write out a line of text, usually without change.
  // However, if the line starts with <GOTO> then the
  // line is transformed by inserting an anchor.
  //
  void writeLine( PrintWriter out, String line ) throws IOException
  {
    if ( line.contains("<GOTO>") )
    {
      String anchor;  // phrase that refers to another page
      String rest;    // remainder of the line that follows </GOTO> 
      String refFile; // page that is referred to.

      String regx =  "<GOTO>(.*)</GOTO>(.*)" ;
      Pattern p = Pattern.compile(regx,Pattern.CASE_INSENSITIVE );
      Matcher m = p.matcher( line );
      if ( m.find() ) 
      {
        anchor = m.group(1);
        rest   = m.group(2);
  
        if ( (refFile = chap.getReference(anchor)) != null )
        {
          out.println( "<a href=\"" + refFile 
              + "#" + anchor + "\"" + " target=\"_blank\" " + ">" );
          out.println( rest + "</a>" );
        }
        else
        {
          out.println( "<!-- undefined anchor " + anchor + "-->" );
        }
      }
      else
      {
        out.println( "<!-- malformed GOTO  -->" );
      }
    }
    else
      out.println( line );
  }

  /* Write out this lesson to its assigned page file */
  boolean writePage( )
  {
    FileWriter fw = null;
    BufferedWriter bo = null;
    PrintWriter out = null;
    String refFile;

    try
    {
      fw  = new FileWriter( pageFile );
      bo  = new BufferedWriter( fw );
      out = new PrintWriter( bo );
    }
    catch ( IOException e )
    {
      chap.msgBox.append( ">>>error<<< " + pageFile + " was not created");
      return false;
    }

    try
    {
      // Write out beginning material.
      // Change EN language code and charset to appropriate values if needed.
      out.print  ( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" " );
      out.println( "\"http://www.w3.org/TR/html4/loose.dtd\" >" );
      
      out.println( "<html>" );
      out.println( "<head>" );
      out.println( "<meta  http-equiv=\"Content-Type\" content=\"text/html;charset=iso-8859-1\">");
      out.println( "<meta name=\"author\" content=\""  + chap.getAuthor() + "\">" );
      out.println( "<meta name=\"copyright\" content=\""  + chap.getCopyrightDate() + "\">" );
      out.println( "<meta name=\"robots\" content=\"index,follow\">" );

      // html tags do not work in the title of a web page, so they are removed
      out.println( "<title>" + removeTags( title ) +  "</title>" );
      out.println( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" +  chap.getStyleSheet() + "\">");

      out.println( "</head>" );
      out.println( );
      
      out.println( "<body>" );
      out.println( "<!-- generated by CSSmaker.java, version " + revisionDate +  " on " + today + " -->" );
      out.println();


      // ****** ANSWER DIVISION ******
      out.println( "<!-- ANSWER DIVISION -->" );

      // Begin the answer division
      out.println();
      out.println( "<div class=\"answer\">" );
      out.flush();

      // print out the audio player and navigation buttons
      out.println( "     <div class=\"topnavigation\">" );

      // first page has no previous page to go to
      if ( lessonNo > 1 )
      {
        out.print  ( "     <a href=\"" + backFile + "\">");
        out.print  ( backIcon );
        out.println( "</a> &nbsp; ");
      }
      
      out.print  ( "     <a href=\"" + homeFile + "\">");
      out.print  ( homeIcon );
      out.println( "</a> &nbsp;");
     
      if ( audio != "" )
      {
        // out.print  ( "     <a href=\"" + audio + "\"" + " onclick=\"window.open(this.href);return false;\">"); // July 01, 2009
        out.print  ( "     <a href=\"" + audio + "\"" + " target=\"audioPlayer\" type=\"audio/mpeg\">"); // July 01, 2009
        out.print  ( audioIcon );
        out.println( "</a> &nbsp;" );
      }

      if ( question.size() > 0 )
      {
        out.print  ( "     <a href=\"" + nextFile + "\">");
        out.print  ( nextIcon );
        out.println( "</a>" );
      }
      
      out.println( "     </div>" );  // end of navigation

      // Write out the material before the answer (if any)
      if ( !prefix.isEmpty() )
      {
        out.println( "<div class=\"questionEcho\">" );
        for ( Enumeration enumer = prefix.elements(); enumer.hasMoreElements();  )
          out.println( (String)enumer.nextElement() );
        out.println( "</div>");
      }

      // Write out the answer to the previous question (if any)
      if ( answer.size() > 0 )
        out.println( "<h3>Answer:</h3>");
      for ( Enumeration enumer = answer.elements(); enumer.hasMoreElements();  )
        writeLine( out, (String)enumer.nextElement() );

      out.println( "</div>");
      
      // ***** LESSON DIVISION *****
      out.println();
      out.println( "<!-- LESSON DIVISION -->" );
      out.println( "<div class=\"lesson\">" );

      // Write out the lesson title
      out.println( "<h1>" + title + "</h1>" );

      // Write out main text of the lesson page
      for ( Enumeration enumer = text.elements(); enumer.hasMoreElements(); )
      {
        writeLine( out, (String)enumer.nextElement() );
      }
      
      // Write out a div that is used to ensure that any floats are cleared before the question starts 
      out.println( "        <div class=\"clearfloats\">  <!-- divs need something inside of them --> </div>" );
      out.println( "</div> <!-- end lesson -->");

       //  ***** QUESTION DIVISION *****
      out.println();
      out.println( "<!-- QUESTION DIVISION -->" );
      out.println( "<div class=\"question\">" );
      out.flush();

      // Write out the question (if any)
      if ( question.size() > 0 )
      {
        out.println( "<h3> QUESTION " + lessonNo + ":</h3>");
     
        for ( Enumeration enumer = question.elements(); enumer.hasMoreElements(); )
           writeLine( out, (String)enumer.nextElement() );
 
        // print the navigation buttons
        out.println( "     <div class=\"navigation\">" );

        // first page has no previous page
        if ( lessonNo > 1 )
        {
          out.print  ( "     <a href=\"" + backFile + "\">");
          out.print  ( backIcon );
          out.println( "</a> &nbsp; ");
        }
        
        out.print  ( "     <a href=\"" + homeFile + "\">");
        out.print  ( homeIcon );
        out.println( "</a> &nbsp;");
        out.print  ( "     <a href=\"" + nextFile + "\">");
        out.print  ( nextIcon );
        out.println( "</a>" );      
        out.println( "     </div>" );  // end of navigation
        
        out.println( "</div>");        // end of question
       
        out.println( );
        out.println( "</body>" );      // end of lesson page
        out.println( "</html>" );
      }
      else
      {
        out.println( "<p>You have reached the end of the chapter.</p>");
        out.print  ( "<p><a href=\"" + backFile + "\">");
        out.print  ( backIcon );
        out.println( "</a> &nbsp; ");
        out.print  ( "<a href=\"" + homeFile + "\">");
        out.print  ( homeIcon );
        out.println( "</a></p>");
        out.println( "</div>" );
        out.println( "</body></html>" );
      }

      out.close();
    } 
       
    catch ( IOException e )
    {
      chap.msgBox.append( ">>>error<<< problem writing " + pageFile );
      return false;
    }
    return true;
  }

  /* Replace private tags with official html
  |
  |  <RED>  ==> <span class="red">         CSS style sheet should have a "red" class
  |  </RED> ==> </span>
  |  <BLU>  ==> <span class="blue">        CSS style sheet should have a "blue" class
  |  </BLU> ==> </span>
  |  <GRN>  ==> <span class="green">       CSS style sheet should have a "green" class
  |  </GRN> ==> </span>
  |
  */
  String replacePrivateTags( String line )
  {
    String fixed ;
    
    fixed = line .replaceAll( "<RED>", "<span class=\"red\">" );
    fixed = fixed.replaceAll( "</RED>", "</span>" );
    fixed = fixed.replaceAll( "<BLU>", "<span class=\"blue\">" );
    fixed = fixed.replaceAll( "</BLU>", "</span>" );
    fixed = fixed.replaceAll( "<GRN>", "<span class=\"green\">" );
    fixed = fixed.replaceAll( "</GRN>", "</span>" );
    
    // Expand audio links.
    // The tag should stand alone on a line.
    String regex = "(.*)<AUDIO>(.*)</AUDIO>(.*)" ;
    Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE );
    Matcher m = p.matcher( line );
    if ( m.find() ) 
    {
        audio = m.group(2) ; 
        fixed = "";   
    }    
    return fixed;
  }
  
  boolean scan( BufferedReader input )
  {
    final int startS    = 0,  /* start state, after </CAI>      */
              prefixS   = 1,  /* after <CAI> before <ASNWER>    */
              answerS   = 2,  /* after <ANSWER>                 */
              lessonS   = 3,  /* after <LESSON>                 */
              questionS = 4,  /* after <QUESTION> before </CAI> */
              doneS     = 5; 
 
    String line ;
    int state = startS;

    /* read through master file line at a time until done */
    while ( state != doneS )
    {

      /* get next line of input */
      try
      {
        line = input.readLine();
        chap.incLinecounter();
      }
      catch ( IOException e )
      {
        chap.msgBox.append(">>>error<<< input error at line " + chap.getLinecounter() ) ;
        return false;
      }

      if ( line == null )   // end of file
        return false;
      // System.out.println("scan: " + line );
      
      /* Replace private tags with official xhtml */
      line = replacePrivateTags( line );
     
      /* start state */
      if      ( (state == startS ) && line.startsWith( "<CAI>")  )
      {
        state = prefixS ;
        int start = line.indexOf( "<CAI>" ) + "<CAI>".length();
        title     = line.substring( start );
      }

      else if ( (state == startS ) && 
          ( line.startsWith( "<ANSWER>")   || line.startsWith( "<LESSON>") ||
            line.startsWith( "<QUESTION>") || line.startsWith( "</CAI>")) )    
      {
        chap.msgBox.append(">>>error<<< at line " + chap.getLinecounter() + " Unexpected tag. " );
        chap.msgBox.append("Expecting <CAI>" );
        chap.msgBox.append( line );
        return false;
      }

      /* prefix state */
      else if ( (state == prefixS ) && line.startsWith( "<ANSWER>")  )
      {
        state = answerS ;
      }

      else if ( (state == prefixS ) && line.startsWith( "<LESSON>")  )
      {
        state = lessonS ;
      }

      else if ( (state == prefixS ) && 
          ( line.startsWith( "<CAI>")      ||
            line.startsWith( "<QUESTION>") || line.startsWith( "</CAI>")) )
      {
        chap.msgBox.append(">>>error<<< at line " + chap.getLinecounter() + " Unexpected tag." );
        chap.msgBox.append("Expecting <ANSWER>" );
        chap.msgBox.append( line );
        return false;
      }

      else if ( (state == prefixS ) )
      {
        state = prefixS ;
        line = line.trim();
        if ( line.length() > 0 )
          prefix.addElement( line );
      }

      /* answer state */
      else if ( (state == answerS ) && line.startsWith( "<LESSON>") )
      {
        state = lessonS;
      }

      else if ( (state == answerS ) && 
          ( line.startsWith( "<CAI>")      ||
            line.startsWith( "<QUESTION>") || line.startsWith( "</CAI>")) )    
      {
        chap.msgBox.append(">>>error<<< at line " + chap.getLinecounter() + " Unexpected tag." );
        chap.msgBox.append("Expecting <LESSON>" );
        chap.msgBox.append( line );
        return false;
      }

      else if ( (state == answerS ) )
      {
         if ( !line.startsWith( "</ANSWER>") )
           answer.addElement( line );
      }

      /* lesson state */
      else if ( (state == lessonS ) && line.startsWith( "<QUESTION>") )
      {
        state = questionS;
      }

      else if ( (state == lessonS) && line.startsWith( "<INDEX>") )
      {
        String anchor;
        int start     = line.indexOf( "<INDEX>" ) + "<INDEX>".length();
        int end       = line.indexOf( "</INDEX>" );
        if ( end == -1 )
          anchor = line.substring( start ).trim();
        else
          anchor = line.substring( start, end ).trim();

        text.addElement( "<a name=\"" + anchor + "\"></a>" );
        chap.addAnchor( anchor, new File(pageFile).getName() );              
      }

      else if ( (state == lessonS) && line.startsWith( "<GOTO>") )
      {
        text.addElement( line );  // Will alter this line later, on output
      }

      else if ( (state == lessonS) && line.startsWith( "</CAI>") )
      {
        state = doneS ;
      }
    
      else if ( (state == lessonS ) && 
          ( line.startsWith( "<CAI>") || line.startsWith( "<ANSWER>")) )
      {
        chap.msgBox.append(">>>error<<< at line " + chap.getLinecounter() + " Unexpected tag." );
        chap.msgBox.append("Expecting </LESSON>" );
        chap.msgBox.append( line );
        return false;
      }

      else if ( (state == lessonS) )
      {
        if ( !line.startsWith( "</LESSON>") )
          text.addElement( line );
      }

      /* question state */
      else if ( (state == questionS) && line.startsWith( "</CAI>") )
      {
        state = doneS;
      }

      else if ( (state == questionS ) && 
          ( line.startsWith( "<CAI>")    || line.startsWith( "<ANSWER>") ||
            line.startsWith( "<LESSON>")  ) )
      {
        chap.msgBox.append(">>>error<<< at line " + chap.getLinecounter() + " Unexpected tag." );
        chap.msgBox.append("Expecting </QUESTION>" );
        chap.msgBox.append( line );
        return false;
      }

      else if ( (state == questionS) )
      {
        if ( !line.startsWith( "</QUESTION>") )
          question.addElement( line );
      }

    }

    return true;
  }

}
