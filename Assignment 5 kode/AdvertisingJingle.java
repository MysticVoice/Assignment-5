
/**
 * Write a description of class AdvertisingJingle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdvertisingJingle extends SubTrack
{
    private String product;
    private String company;
    /**
     * Constructor for objects of class AdvertisingJingle
     */
    public AdvertisingJingle(String title, long min, long sec, String company, String product)
    {
        super(title, min, sec);
        this.product = product;
        this.company = company;
    }
}
