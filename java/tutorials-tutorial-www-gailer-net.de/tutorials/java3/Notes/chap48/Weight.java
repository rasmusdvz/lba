import java.io.* ;

class Weight
{
  int[] data;
  
  // Constructor
  Weight(int[] init)
  {
    data = new int[ init.length ];
    
    for (int j=0; j<data.length; j++)
    {
      data[j] = init[j];
    }
  }
  
  //Print
  void print()
  {
    for (int j=0;  j<data.length; j++)
    {
      System.out.print  ( data[j] + " ");
      System.out.println();
    }
  }
  
  //Print
  int average()
  {
    int sum = 0;
    for (int j=0; j<data.length; j++)
    {
      sum += data[j];
    }
    
    return sum/data.length;
  }
  
  int subAverage( int start, int end )
  {
    int sum = 0;
    for (int j=start; j<data.length && j<=end; j++)
    {
      sum += data[j];
    }
    
    return sum/(end-start+1);
    
  }
  
  public static void main ( String[] args )
  {
    int[] values = { 98, 99, 98, 99, 100, 101, 102, 100, 104 };
    Weight june = new Weight( values );
    june.print();
    int avg = june.subAverage(0,8);
    System.out.println("average = " + avg );
  }
}  