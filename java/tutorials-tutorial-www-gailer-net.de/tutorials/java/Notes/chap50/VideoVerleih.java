class VideoTape
{
  String   titel;        // Titel des Videos
  int      laenge;       // Anzahl der Minuten
  boolean  vorhanden;    // ist das Video vorhanden?
  // Konstruktor
  public VideoTape( String ttl )
  {
    titel = ttl; laenge = 90; vorhanden = true;
  }
  // Konstruktor
  public VideoTape( String ttl, int len )
  {
    titel = ttl; laenge = len; vorhanden = true;
  }
  public void anzeigen()
  {
    System.out.println( titel + ", " + laenge + " Min. verfuegbar: " + vorhanden );
  }
}
class VideoVerleih
{
  public static void main ( String args[] )
  {
    VideoTape artikel1 = new VideoTape("Jaws", 120 );
    VideoTape artikel2 = new VideoTape("Star Wars" );
    artikel1.anzeigen();
    artikel2.anzeigen();
  }
}