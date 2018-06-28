class VideoTape
{
  String  title;    // name of the item
  int     length;   // number of minutes
  boolean avail;    // is the tape in the store?

  // constructor
  public VideoTape( String ttl )
  {
    title = ttl; length = 90; avail = true; 
  }

  // constructor
  public VideoTape()
  {
    title = "Ben Hur"; length = 90; avail = true; 
  }

  // constructor
  public VideoTape( String ttl, int lngth )
  {
    title = ttl; length = lngth; avail = true; 
  }

  public void show()
  {
    System.out.println( title + ", " + length + " min. available:" + avail );
  }
  
}

class Movie extends VideoTape
{
  String  director;     // name of the director
  String  rating;       // G, PG, R, or X

  // alternate constructor
  public Movie( String ttl, int lngth, String dir, String rtng )
  {
    super();
    title = ttl;       // do what the parent's constuctor does.
    length = lngth;  
    avail = true;
    
    director = dir; rating = rtng;
  }
  
  // added to class Movie
  public void show()
  {
    System.out.println( "dir: " + director + "  " + rating );  
    super.show();
  }
}

class MusicVideo extends VideoTape
{
  String artist;
  String category;
 
  // constructor
  public MusicVideo ( String ttl, int len, String art, String cat )
  {
    super( ttl, len );
    artist   = art;
    category = cat;
  }
  
  public void show()
  {
    super.show();
    System.out.println( "artist:" + artist + " style: " + category );
  }
}


class TapeStore
{
  public static void main ( String args[] )
  {
    VideoTape item1 = new VideoTape("Microcosmos", 90 );
    Movie     item2 = new Movie("Jaws", 120, "Spielberg", "PG" );
    MusicVideo item3 = new MusicVideo( "Grease", 6, "Olivia", "Pop" );
    item1.show();
    item2.show();
    item3.show();
  }
}

