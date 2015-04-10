
/**
 * Write a description of class HDD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HDD extends Medium
{
    private String name;
    private String path;
    private int filesize;
    
    /**
     * Constructor for objects of class HDD
     */
    public HDD(String name, String path, int filesize)
    {
        this.name = name;
        this.path = path;
        this.filesize = filesize;
    }
}
