
/**
 * Write a description of class CD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD extends ExternalMedium
{
    private String album;
    private String artist;
    private int yearReleased;
    private String label;
    
    /**
     * Constructor for objects of class CD
     */
    public CD(String album, String artist, int year, String label)
    {
        this.album = album;
        this.artist = artist;
        yearReleased = year;
        this.label = label;
    }
}
