
/**
 * Class for sound effects
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundEffect extends SubTrack
{
    private String description;
    /**
     * Constructor for objects of class SoundEffect
     */
    public SoundEffect(String title, long min, long sec, String description)
    {
        super(title, min, sec);
        this.description = description;
    }
}
