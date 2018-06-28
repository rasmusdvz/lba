class StudentGrades
{
  final int arraySize = 25;

  // Instance Variables
  String name;          // the name of the student
  int[]  grades;        // the array of grades
  int    gradeCount;    // how many of the slots have data

  // Constructor
  StudentGrades( String studentName )
  {
    name = studentName  ;
    grades =  new int[ arraySize ] ;
    gradeCount =  0  ;
  }

  // Methods

  public void print ()
  {
    System.out.println ( "Name: " + name  );

    System.out.println( "Grades:");

    for ( int j=0; j < gradeCount ; j++ )
      System.out.println ( "  grade " + j + ": " + grades[ j ] );

  }

  public void addGrade ( int grade )
  {
    if ( gradeCount < arraySize ) 
      grades[gradeCount] = grade ;
    gradeCount ++ ;
  }

  public double average ( )
  {
    double sum =  0  ;

    for ( int j=0; j < gradeCount; j++ )  
      sum += grades[ j ] ;

    return   sum / gradeCount ;
  }

  public int minimum( )
  {
    int min = grades[ 0 ] ;

    for ( int j=0; j < gradeCount; j++ ) 

      if ( grades[j] < min )
        min = grades[j] ;
  
    return min ;
  }

  public int maximum( )
  {
    int max = grades[ 0 ] ;

    for ( int j=0; j < gradeCount; j++ ) 

      if ( grades[j] > max )
        max = grades[j] ;
  
    return max ;
  }

}

class StudentTester
{

  public static void main ( String[] args )
  {
     // create an object for a student
     StudentGrades stud = new StudentGrades( "Laura Lyons" ) ;

     // print out empty object
     stud.print() ;

     // add a few grades
     stud.addGrade( 90 ) ;
     stud.addGrade( 92 ) ;
     stud.addGrade( 83 ) ;
     stud.addGrade( 74 ) ;
     stud.addGrade( 90 ) ;
     stud.addGrade( 80 ) ;

     // print out the object with its new values
     System.out.println();
     stud.print() ;

     // compute and print the average, minimum and maximum
     System.out.println( "Average grade: " + stud.average() + "  Minimum: " + stud.minimum() +
         "  Maximum: " + stud.maximum() );

  }
}
