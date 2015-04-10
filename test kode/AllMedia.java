import java.util.ArrayList;
/**
 * Write a description of class AllMedia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllMedia
{
    // instance variables - replace the example below with your own
    private ArrayList<Media> allMedia;
    

    /**
     * Constructor for objects of class AllMedia
     */
    public AllMedia()
    {
        allMedia = new ArrayList<Media>();
        
    }
    
   
    /**
     * add media
     */
    public void addMedia(Media collection)
    {
        allMedia.add(collection);
    }
    
    
}