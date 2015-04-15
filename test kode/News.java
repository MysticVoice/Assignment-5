
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
    private String dateMade;
    private String dateBroadcasted;
    private String journalist;

    /**
     * Constructor for objects of class News
     */
    public News(String newsStory, String dateMade, String dateBroadcasted, String journalist, String title, long minutes, long seconds)
    {
        super(title, minutes, seconds);
        this.newsStory = newsStory;
        this.dateMade = dateMade;
        this.dateBroadcasted = dateBroadcasted;
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
     * returns artist
     * @return the artist
     */
    public String getDateMade()
    {
        return dateMade;
    }
    /**
     * returns dateBroadcasted
     * @return the dateBroadcasted
     */
    public String getDateBroadcasted()
    {
        return dateBroadcasted;
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
    public void dateMade(String dateMade)
    {
        this.dateMade = dateMade;
    }
    /**
     * change dateBroadcasted
     */
    public void setDateBroadcasted(String dateBroadcasted)
    {
        this.dateBroadcasted = dateBroadcasted;
    }
     /**
     * change dateBroadcasted
     */
    public void setJournalist(String journalist)
    {
        this.journalist = journalist;
    }
}
