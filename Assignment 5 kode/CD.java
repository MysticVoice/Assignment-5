
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
    
    public void setAlbum(String input)
    {
        this.album = input;
    }
    
    public void setArtist(String input)
    {
        this.artist = input;
    }
    
    public void setLabel(String input)
    {
        this.label = input;
    }
    
    public void setYearReleased(int input)
    {
        this.yearReleased = input;
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
    
    /**
     * Returns gui text
     */
    public String getText()
    {
        String resultString = "";
        resultString = getArtist();
        return resultString;
    }
    
    public String getLongDescription()
    {
        String returnString = "Album: " + album + " Artist: " + artist + " Year released: " + yearReleased + " Label: " + label;
        return returnString;
    }
}
