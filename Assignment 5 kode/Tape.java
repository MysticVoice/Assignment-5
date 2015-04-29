
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
    
    public String getDigitalString()
    {
        String returnString = "Analog";
        if(digital == false)
        {}
        else if (digital == true)
        {
            returnString = "Digital";
        }
        return returnString;
    }
    
    public String getLongDescription()
    {
        String returnString = "Title: " + getTitle()+ " " + getDigitalString();
        return returnString;
    }
}