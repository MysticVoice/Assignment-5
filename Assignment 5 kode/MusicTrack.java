import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
/**
 * Class for music tracks
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicTrack extends SubTrack
{
       private String artist;
    private Calendar dateLastPlayed;
    private int timesPlayed;

    /**
     * Constructor for objects of class MusicTrack
     */
    public MusicTrack(String title, String artist, long min, long sec)
    {
        super(title, min, sec);
        this.artist = artist;        
        this.dateLastPlayed = setDate();
        this.timesPlayed = timesPlayed;
    }
    
    /**
     * returns artist
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * returns timesPlayed
     */
    public int getTimesPlayed()
    {
        return timesPlayed;
    }
    
    //mutators
        public Calendar setDate()
    {
        Calendar dateLastPlayed = new GregorianCalendar();
        Date trialTime = new Date();
        dateLastPlayed.setTime(trialTime);
        
        return dateLastPlayed;
    }

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

    public String getDateLastPlayed()
    {
        String returnString = "YEAR: " + dateLastPlayed.get(dateLastPlayed.YEAR)+" ";
        returnString += "MONTH: " + (dateLastPlayed.get(dateLastPlayed.MONTH)+1)+" ";
        returnString += "DATE: " + dateLastPlayed.get(dateLastPlayed.DATE)+" ";
        return returnString;
    }

    public String getLongDescription()
    {
        String returnString = 
        "Title: "+super.getTitle()
        +" Artist: "+getArtist()
        +" Duration: "+super.getDuration()
        +" Last Played: "+getDateLastPlayed()
        +" Times Played: "+getTimesPlayed();
        return returnString;
    }
}