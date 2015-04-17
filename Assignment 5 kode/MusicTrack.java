
/**
 * Write a description of class MusicTrack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicTrack extends SubTrack
{
    private String artist;
    private int timesPlayed;
    /**
     * Constructor for objects of class MusicTrack
     */
    public MusicTrack(String title, String artist, long min, long sec)
    {
        super(title, min, sec);
        this.artist = artist;
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public int getTimesPlayed()
    {
        return timesPlayed;
    }
}
