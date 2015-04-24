import java.util.ArrayList;
/**
 * Class for HDD objects
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HDD extends Medium
{
    private String name;
    /**
     * Constructor for objects of class HDD
     */
    public HDD(String name)
    {
        this.name = name;
    }
    
    /**
     * adds a file to tracks
     */
    public void addTrack (FileOnHDD track)
    {
        tracks.addTrack(track);
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns gui text
     */
    public String getText()
    {
        String resultString = "";
        resultString = getName();
        return resultString;
    }
}
