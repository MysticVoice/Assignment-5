import java.time.Duration;
/**
 * Write a description of class SubTrack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SubTrack extends Track
{
    private String title;
    protected Duration duration;
    
    /**
     * Constructor for objects of class SubTrack
     */
    public SubTrack(String title,long min,long sec)
    {
        this.duration = duration(min,sec);
        this.title = title;
    }
    
    protected Duration duration(long min, long sec)
    { 
        Duration dur = Duration.ofSeconds(sec).plusMinutes(min);
        return dur;
    }
    
    /**
     * Gets the title of the track
     */
    public String getTitle()
    {
        return title;
    }
    
    public Duration getDuration()
    {
        return duration;
    }
}