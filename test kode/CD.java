import java.time.Duration;
 /** Write a description of class CD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD extends Physical
{
    // instance variables - replace the example below with your own
    private String artist;
    private String label;
    private int year;
    private Duration CDDuration;

    /**
     * Constructor for objects of class CD
     */
    public CD(String title, String artist, String label, int year, int min, int sec)
    {
       super(title);
       this.artist = artist;
       this.label = label;
       this.year = year;
      
    }
    
    
     /**
     * returns the artist
     * @return the artist
     */
    public String getArtist()
    {
        return artist;
    }    
      /**
     * returns the label
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }
      /**
     * returns the year
     * @return the year
     */
    public int getYear()
    {
        return year;
    }
   
    
    /**
     * change artist
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
     /**
     * change label
     */
    public void setLabel(String label)
    {
        this.artist = label;
    }
     /**
     * change year
     */
    public void setYear(int year)
    {
        this.year = year;
    }
}