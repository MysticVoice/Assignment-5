
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
    public AdvertisingJingle(String product, String company, String title, long minutes, long seconds)
    {
        super(title, minutes, seconds);
        this.product = product;
        this.company = company;
    }
    
    
    // accessors
    
    /**
     * returns the product
     * @return the product string
     */
    public String product()
    {
        return product;
    }
    
    /**
     * returns the company
     * @return the company string
     */
    public String company()
    {
        return company;
    }
    
    //mutators
    
    /**
     * change times played
     */
    public void setProduct(String product)
    {
        this.product = product;
    }
    /**
     * change artist
     */
    public void setCompany(String company)
    {
        this.company = company;
    }
}
