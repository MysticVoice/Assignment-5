import java.util.ArrayList;
/**
 * Write a description of class HDD here.
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
    
    public void addTrack (FileOnHDD track)
    {
        tracks.addTrack(track);
    }
}
