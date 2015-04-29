import java.time.Duration;
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
    
    /**
     * returns a track
     */
    public Track getTrack(int index)
    {
        return tracks.get(index);
    }
    
    /**
     * adds a track
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }
    
    public int getSize()
    {
        return tracks.size();
    }
    
    /**
     * returns total duration
     */
    public Duration getTime()
    {
        Duration test = Duration.ofSeconds(0);
        for(int i = 0; i<tracks.size(); i++)           
        {
            test = test.plus(tracks.get(i).getDuration());
        }
        return test;
    }
}
