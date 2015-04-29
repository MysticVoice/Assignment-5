import java.util.ArrayList;
import java.time.Duration;
/**
 * Write a description of class FileOnHDD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileOnHDD extends Track
{
    private SubTrack track;
    private String filename;
    private String path;
    private int filesize;

    /**
     * Constructor for objects of class FileOnHDD
     */
    public FileOnHDD(SubTrack track, String path)
    {
        this.track = track; 
        this.filename = track.getTitle()+".mp3";
        this.path = path;
    }
    
    /**
     * gets the duration
     */
    public Duration getDuration()
    {
        return track.getDuration();
    }
    
    public String getTitle()
    {
        return track.getTitle();
    }
    
    public Track getTrack()
    {
        return track;
    }
    
    public String getFilename()
    {
        return filename;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public String getArtist()
    {
        if(track instanceof MusicTrack)
        {
            return ((MusicTrack)track).getArtist();
        }
        return null;
    }
    
    public String getLongDescription()
    {
        String returnString = 
        track.getLongDescription()
        +" Filename: "+getFilename()
        +" Path: "+getPath();
        return returnString;
    }
}
