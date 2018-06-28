class FibonacciCalc
{
  public int Fib( int N )
  {
    if       ( N==1 ) 
      return 1;
    else if  ( N==2 ) 
      return 1;
    else if  ( N==3 ) 
      return 2;
    else
      return Fib( N-1 ) + Fib( N-2 ) - Fib( N-3 );
  }
}

class FibonacciTester
{
  public static void main ( String[] args)
  {
    int argument = Integer.parseInt( args[0] );
    
    FibonacciCalc f = new FibonacciCalc();
    int result = f.Fib( argument );
    System.out.println("Fib(" + argument + ") is " + result );
  }
}
