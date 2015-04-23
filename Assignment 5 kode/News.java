
/**
 * Class for news
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class News extends SubTrack
{
    String summary;
    /**
     * Constructor for objects of class News
     */
    public News(String title, long min, long sec, String summary)
    {
        super(title,min,sec);
        this.summary = summary;
    }
}
