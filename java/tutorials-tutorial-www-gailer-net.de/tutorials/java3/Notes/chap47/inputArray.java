import java.io.* ;

     class inputArray{
   public static void main ( String[] args ) 
       {
         double[] array =  { 1, 1, 1, 1, 1} ;

         // declare and initialize the total
         double   total ;

         // add each element of the array to the total
         for ( int index=0; index < array.length; index++ )
         { 
           total =  total + array[ index ]  ;

         }
           
         System.out.println("The total is: " + total );
       }
     }      