import java.time.Duration;
/**
 * Write a description of class Track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track
{

    public Track()
    {}
    public Duration getDuration()
    {
        return null;
    }
    public String getTitle()
    {
        return null;
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
