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
    private String duration;
   
    /**
     * Constructor for objects of class AudioTracks
     */
    public AudioTrack(String title, double minutes, double seconds)
    {
        this.title = title;
        this.duration = minutes + ":" + seconds;
       
    }
    
    /**
     * prints info
     */
    private void printinfo()
    {
        System.out.println();
    }
}
