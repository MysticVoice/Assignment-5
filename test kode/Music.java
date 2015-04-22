import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
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
    private Calendar dateLastPlayed;
    private int timesPlayed;
    /**
     * Constructor for objects of class Music
     */
    public Music(String artist, int timesPlayed, String title, long minutes, long seconds)
    {
        super(title, minutes, seconds);
        this.artist = artist;
        this.dateLastPlayed = setDate();
        this.timesPlayed = timesPlayed;

    }

    public Calendar setDate()
    {
        Calendar dateLastPlayed = new GregorianCalendar();
        Date trialTime = new Date();
        dateLastPlayed.setTime(trialTime);
        
        return dateLastPlayed;
    }

    // accessors


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

    public void getDateLastPlayed()
    {
        System.out.println("YEAR: " + dateLastPlayed.get(dateLastPlayed.YEAR));
        System.out.println("MONTH: " + ((dateLastPlayed.get(dateLastPlayed.MONTH)+1)));
        System.out.println("DATE: " + dateLastPlayed.get(dateLastPlayed.DATE));
    }

}
