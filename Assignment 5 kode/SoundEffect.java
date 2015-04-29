
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
    
        /**
     * returns description.
     * @return description.
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getLongDescription()
    {
        String returnString = 
            "Title: "+super.getTitle()
            +" description "+getDescription()
            +" Duration: "+super.getDuration();

        return returnString;
    }    
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}