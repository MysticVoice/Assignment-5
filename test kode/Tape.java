
/**
 * Write a description of class Tape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tape extends Physical
{
    // instance variables - replace the example below with your own
    private String type;
    /**
     * Constructor for objects of class Tape
     */
    public Tape(String title, String type)
    {
       super(title);
       this.type = type;
    }
    
    
      /**
     * returns the type
     * @return the type
     */
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
}

