class StringArray
{
  public static void main ( String[] args )
  {
    String[] strArray = new String[8] ;  

    strArray[0] = "Hello" ;
    strArray[1] = "World" ;
    strArray[2] = "Greetings" ;
    strArray[3] = "Jupiter" ;
    strArray[ strArray.length-1 ] = "the end" ;

    for (int j=0; j  < strArray.length; j++ )
   System.out.println( "The string " + strArray[j] + " is " +
       strArray[j].length  + " characters long." );
  }
}