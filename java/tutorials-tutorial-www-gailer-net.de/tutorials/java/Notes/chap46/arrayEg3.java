class arrayEg3
{
  public static void main ( String[] args )
  {
    double val[] = new double[4];  

    val[0] =  1.5;
    val[1] = 10.0;
    val[2] = 15.5;

    int j  = 3;
    val[j] = val[j-1] + val[j-2];   // same as val[3] = val[2] + val[1]

    System.out.println( "val[" + j + "] ==" + val[ j   ] );
 
   }
}
