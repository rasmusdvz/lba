class Rodent
{
  public void speak()
  {
    System.out.println("Rodent");
  }
}

class Rat extends Rodent
{
}

class Mouse extends Rodent
{
}

class NorwayRat extends Rat
{
}

class LabRat extends Rat
{
}

class FieldMouse extends Mouse
{
}

public class RodentTester
{

  public static void main ( String[] art )
  {

    Rodent rod = new Rat();
    rod        = new FieldMouse();

    Mouse mou  = (Mouse)(new Rodent());

  }
}