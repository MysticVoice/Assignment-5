import java.util.ArrayList;
/**
 * Write a description of class Register here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Register
{
    // instance variables - replace the example below with your own
    private AllMedia star;
    /**
     * Constructor for objects of class Register
     */
    public Register()
    {
        // initialise instance variables
        star = new AllMedia();
        AllMedia star = new AllMedia();

    }

    public Media makecd()
    {
        CD cd = new CD("title", "artist", "label", 1, 1, 11);
        return cd;
    }

    public void fillAllMedia()
    {
        star.addMedia(this.makecd());
        star.addMedia(new Tape("titel", "digital"));
        
    }

}
