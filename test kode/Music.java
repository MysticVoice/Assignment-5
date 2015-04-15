
/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends AudioTrack
{
    // instance variables - replace the example below with your own
    private String artist;
    private String dateLastPlayed;
    private int timesPlayed;

    /**
     * Constructor for objects of class Music
     */
    public Music(String artist, String dateLastPlayed, int timesPlayed, String title, long minutes, long seconds)
    {
       super(title, minutes, seconds);
       this.artist = artist;
       this.dateLastPlayed = dateLastPlayed;
       this.timesPlayed = timesPlayed;
    }
    
    // accessors
    
    /**
     * returns the date this sog was last played
     * @return the dateLastPlayed
     */
    public String getDateLastPlayed()
    {
        return dateLastPlayed;
    }
    /**
     * returns artist
     * @return the artist
     */
    public int geTimesPlayed()
    {
        return timesPlayed;
    }
    /**
     * returns artist
     * @return the artist
     */
    public String getArtist()
    {
        return artist;
    }
    
    //mutators
    
    /**
     * change times played
     */
    public void setTimesPlayed(int timesPlayed)
    {
        this.timesPlayed = timesPlayed;
    }
    /**
     * change artist
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    /**
     * change dateLastPlayed
     */
    public void setDateLastPlayed(String dateLastPlayed)
    {
        this.dateLastPlayed = dateLastPlayed;
    }
}
