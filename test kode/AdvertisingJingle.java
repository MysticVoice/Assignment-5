
/**
 * Write a description of class AdvertisingJingle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdvertisingJingle extends AudioTrack
{
    // instance variables - replace the example below with your own
    private String product;
    private String company;

    /**
     * Constructor for objects of class AdvertisingJingle
     */
    public AdvertisingJingle(String product, String company, String title, double minutes, double seconds)
    {
        super(title, minutes, seconds);
        this.product = product;
        this.company = company;
    }

    
}
