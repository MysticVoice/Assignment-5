import java.util.ArrayList;
/**
 * Write a description of class Tracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tracks
{
    // instance variables - replace the example below with your own
    private ArrayList<Track> tracks;

    /**
     * Constructor for objects of class Tracks
     */
    public Tracks()
    {
        tracks = new ArrayList<Track>();
        
    }
    
    public void addTrack(Track track)
    {
        tracks.add(track);
    }
}
