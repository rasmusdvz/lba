class Goods
{
  String description;
  double price;

  Goods( String des, double pr )
  {
    description = des;
    price       = pr;
  }

  void display()
  {
    System.out.println( "item: " + description + " price: " + price );
  }
}

class Food extends Goods
{
  double calories;

  Food( String des, double pr, double cal)
  {
    super( des, pr );
    calories = cal ;
  }

  void display()
  {
    super.display( );
    System.out.println( "calories: " + calories );
  }
}


interface Taxible
{
  final double taxRate = 0.06 ;
  double calculateTax() ;
}

interface Taxible2
{
  double calculateTax() ;
}

class Toy extends Goods implements Taxible, Taxible2
{
  int minimumAge;

  Toy( String des, double pr, int min)
  {
    super( des, pr );
    minimumAge  = min ;
  }

  void display()
  {
    super.display() ;
    System.out.println( "minimum age: " + minimumAge );
  }

  public double calculateTax()
  {
    return price * taxRate ;
  }
}

class Book  extends Goods implements Taxible
{
  String author;

  Book( String des, double pr, String auth)
  {
    super( des, pr );
    author  = auth ;
  }

  void display()
  {
    super.display() ;
    System.out.println( "author: " + author );
  }

  public double calculateTax()
  {
    return price * taxRate ;
  }
}


public class Store
{

  public static void main ( String[] args )
  {
    Book    book ;
    Taxible tax = new Book ( "Emma", 24.95, "Austin" );

    book = (Book)tax;
    book.display();
    System.out.println( "Tax on item 1 "+ book.calculateTax() );
  }
}
