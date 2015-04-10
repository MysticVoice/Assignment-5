
/**
 * Write a description of class SoundEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundEffect extends AudioTrack
{
    // instance variables - replace the example below with your own
    private String description;

    /**
     * Constructor for objects of class SoundEffect
     */
    public SoundEffect(String description, String title, double minutes, double seconds)
    {
        super(title, minutes, seconds);
        this.description = description;
    }

    /**
     * returns description.
     * @return description.
     */
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}
