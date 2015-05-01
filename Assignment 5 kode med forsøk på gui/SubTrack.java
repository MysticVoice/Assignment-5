import java.time.Duration;
/**
 * Main class for standalone tracks
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SubTrack extends Track
{
    private String title;
    protected Duration duration;
    
    /**
     * Constructor for objects of class SubTrack
     */
    public SubTrack(String title,long min,long sec)
    {
        this.duration = setDuration(min,sec);
        this.title = title;
    }
    
    /**
     * sets duration
     */
    protected Duration setDuration(long min, long sec)
    { 
        Duration dur = Duration.ofSeconds(sec).plusMinutes(min);
        return dur;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Gets the title of the track
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * returns duration
     */
    public Duration getDuration()
    {
        return duration;
    }
    
}