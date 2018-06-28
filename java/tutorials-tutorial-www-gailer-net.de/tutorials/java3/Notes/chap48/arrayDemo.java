     import java.io.*;
     class ArrayOps
     {
       void print( int[] x )
       {
         for ( int index=0; index < x.length; index++ )
           System.out.print( x[index] + " " );
         System.out.println();
       }

       // print elements start through end
       void printRange ( int[] x, int start, int end )
       {
         for ( int index=start; index <= end ; index++ )
           System.out.print( x[index] + " " );
         System.out.println();
       }

     }

     class ArrayDemo
     {
       public static void main ( String[] args ) 
       {
         ArrayOps operate = new ArrayOps();
         int[] ar1 =  { -20, 19, 1, 5, -1, 27, 19, 5 } ;
         
         // print elements 1, 2, 3, 4, 5
         operate.printRange( ar1, 1, 10 );
       }

     }      