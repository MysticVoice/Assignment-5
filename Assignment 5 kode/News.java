import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
/**
 * Class for news
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class News extends SubTrack
{
    private String summary;
    private Calendar dateMade = date();
    private Calendar dateBroadcasted;
    private String journalist;
    /**
     * Constructor for objects of class News
     */
    public News(String title, String journalist, long min, long sec, String summary)
    {
        super(title,min,sec);
        this.summary = summary;
        this.dateMade = date();
        this.dateBroadcasted = date();
        this.journalist = journalist;
    }
    // accessors

    public String getDateMade()
    {
        String returnString = "YEAR: " + dateMade.get(dateMade.YEAR);
        returnString += "MONTH: " + (dateMade.get(dateMade.MONTH)+1);
        returnString += "DATE: " + dateMade.get(dateMade.DATE);
        return returnString;
    }

    public String getDateBroadcasted()
    {
        String returnString = "YEAR: " + dateBroadcasted.get(dateBroadcasted.YEAR);
        returnString += "MONTH: " + (dateBroadcasted.get(dateBroadcasted.MONTH)+1);
        returnString += "DATE: " + dateBroadcasted.get(dateBroadcasted.DATE);
        return returnString;
    }
    
    public String getLongDescription()
    {
        String returnString = 
            "Title: "+super.getTitle()
            +" Summary "+getSummary()
            +" Journalist: "+getJournalist()
            +" Duration: "+super.getDuration()
            +" Date Made: "+getDateMade()
            +" Date Broadcasted "+getDateBroadcasted();

        return returnString;
    }    

    /**
     * returns the newsStory 
     * @return the newsStory
     */
    public String getSummary()
    {
        return summary;
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
    public void setSummary(String newSummary)
    {
        this.summary = newSummary;
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
