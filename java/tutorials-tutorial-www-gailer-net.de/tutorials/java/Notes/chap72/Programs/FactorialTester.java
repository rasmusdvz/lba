class FactorialCalc
{
  int fact( int N )
  {
    if ( N == 0 )
      return 1;
    else
      return (N * fact( N-1 )) ;
  }
}

class FactorialTester
{
  public static void main ( String[] args)
  {
    int argument = 10;
    FactorialCalc f = new FactorialCalc();
    long result = f.fact( argument );
    System.out.println("Factorial(" + argument + ") is " + result );
  }
}
