
/**
 * Class for Tape objects
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tape extends ExternalMedium
{
    boolean digital;
    String title;
    /**
     * Constructor for objects of class Tape
     */
    public Tape(boolean digital, String title)
    {
        this.digital=digital;
        this.title = title;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getText()
    {
        String resultString = "";
        resultString = resultString + title;
        return resultString;
    }
}