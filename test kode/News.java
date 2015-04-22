import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
/**
 * Write a description of class News here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class News extends AudioTrack
{
    // instance variables - replace the example below with your own
    private String newsStory;
    private Calendar dateMade = date();
    private Calendar dateBroadcasted;
    private String journalist;

    /**
     * Constructor for objects of class News
     */
    public News(String newsStory, String journalist, String title, long minutes, long seconds)
    {
        super(title, minutes, seconds);
        this.newsStory = newsStory;
        this.dateMade = date();
        this.dateBroadcasted = date();
        this.journalist = journalist;

    }

    // accessors

    /**
     * returns the newsStory 
     * @return the newsStory
     */
    public String getNewsStory()
    {
        return newsStory;
    }

   

   

    /**
     * returns the journalist 
     * @return the journalist
     */
    public String getJournalist()
    {
        return journalist;
    }

    //mutators

    /**
     * change times played
     */
    public void setNewsStory(String newsStory)
    {
        this.newsStory = newsStory;
    }

    /**
     * change dateMade
     */
    private Calendar date()
    {
        Calendar dateMade = new GregorianCalendar();
        Date trialTime = new Date();
        dateMade.setTime(trialTime);

        return dateMade;
    }

    /**
     * change dateBroadcasted
     */
    public void setJournalist(String journalist)
    {
        this.journalist = journalist;
    }
}
