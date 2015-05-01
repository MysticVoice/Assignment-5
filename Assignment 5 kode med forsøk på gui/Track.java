import java.time.Duration;
/**
 * Main class for Track objects
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Track
{

    /**
     * Constructor for Track
     */
    public Track()
    {}
    
    /**
     * placeholder function
     */
    abstract protected Duration getDuration();
    
    abstract protected String getTitle();
    
    abstract protected String getLongDescription();
}
