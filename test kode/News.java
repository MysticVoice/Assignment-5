
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
    public News(String newsStory, String dateMade, String dateBroadcasted, String journalist, String title, double minutes, double seconds)
    {
        super(title, minutes, seconds);
        this.newsStory = newsStory;
        this.dateMade = dateMade;
        this.dateBroadcasted = dateBroadcasted;
        this.journalist = journalist;
       
    }
}
