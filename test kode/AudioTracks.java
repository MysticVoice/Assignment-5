import java.util.ArrayList;
import java.util.Iterator;
import java.time.Duration;
/**
 * Write a description of class AudioTracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AudioTracks
{
    // instance variables - replace the example below with your own
    private ArrayList<AudioTrack> tracks;

    /**
     * Constructor for objects of class AudioTracks
     */
    public AudioTracks()
    {
        tracks = new ArrayList<AudioTrack>();

    }

    public void addTrack(AudioTrack track)
    {
        tracks.add(track);
    }

}