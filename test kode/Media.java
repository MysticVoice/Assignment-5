import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class Media here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Media
{
    //protected ArrayList<AudioTracks> tracks;
    protected AudioTracks list;
    private String title;
    /**
     * Constructor for objects of class Media
     */
    public Media(String title)
    {
        //this.tracks = new ArrayList<AudioTracks>();
        list = new AudioTracks();
        //tracks.add(list);
        this.title = title;
    }

    public void addTrack(AudioTrack track)
    {
        this.list.addTrack(track);
        
    }

    public String getTitle()
    {
        return title;
    }
    public Duration getTime()
    {
       return list.getTime();
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

}
