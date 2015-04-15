import java.util.ArrayList;
/**
 * Write a description of class FileOnHDD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileOnHDD
{
    private Track track;
    private String fileName;
    private String path;
    private int filesize;

    /**
     * Constructor for objects of class FileOnHDD
     */
    public FileOnHDD(Track track,String fileName, String path)
    {
        this.track = track; 
        this.fileName = fileName;
        this.path = path;
    }
}
