import java.lang.*;

class InputDemo
{
  public static void main ( String[] args )
  {
    int sum = 0;
    for (int j=0; j < args.length; j++ )
      sum += Integer.parseInt(  args[j]  );

    System.out.println( "Sum: " + sum );
  }
}
