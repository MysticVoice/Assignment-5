import java.time.Duration;
/**
 * Write a description of class AudioTracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AudioTrack
{
    private String title;
    private Duration duration;

    /**
     * Constructor for objects of class AudioTracks
     */
    public AudioTrack(String title, long minutes, long seconds)
    {
        this.title = title;
        this.duration = setDuration(minutes, seconds);

    }

     // accessors
     
        public String getTitle()
    {
        return title;
    } 
    public Duration getDuration()
    {
        return duration;
    }
     /**
     * prints info
     */
    private void printinfo()
    {
        System.out.println();
    }
    
    
     //mutators
      protected Duration setDuration( long minutes, long seconds)
    {
        Duration time = this.duration.ofSeconds(seconds).plusMinutes(minutes);
        return time;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    
   

}
