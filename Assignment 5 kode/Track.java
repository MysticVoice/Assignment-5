import java.time.Duration;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;
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

    /**
     * Constructor for objects of class Track
     */
    public Track(String title)
    {
        this.title = title;
    }

    public Track()
    {}
    
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
