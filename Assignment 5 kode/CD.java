
/**
 * Class for CD objects
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
    
    /**
     * returns artist
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * creates a descriptive string for printing
     */
    public String printString()
    {
        String returnString = "Album: " + album + " \nArtist: " + artist + " \nYear released: " + yearReleased + " \nLabel: " + label;
        return returnString;
    }
}
