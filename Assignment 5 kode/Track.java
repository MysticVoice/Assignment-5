import java.time.Duration;
import java.io.File;
/**
 * Write a description of class Track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track
{
    // instance variables - replace the example below with your own
    private String title;
    protected Duration time;

    /**
     * Constructor for objects of class Track
     */
    public Track(String title, long sec, long min)
    {
        time = duration(min,sec);
        this.title = title;
    }

    public Track()
    {}
    
    
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
    
    //     public double trackLength(String fileLocation)throws UnsupportedAudioFileException, IOException
    //     {
    //         File file = new File(fileLocation);
    //         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
    //         AudioFormat format = audioInputStream.getFormat();
    //         long frames = audioInputStream.getFrameLength();
    //         double durationInSeconds = (frames+0.0) / format.getFrameRate(); 
    //         return durationInSeconds;
    //      }
}
