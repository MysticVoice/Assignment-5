
/**
 * Class for advertising jingles
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
         // accessors
    
    /**
     * returns the product
     * @return the product string
     */
    public String getProduct()
    {
        return product;
    }
    
    /**
     * returns the company
     * @return the company string
     */
    public String getCompany()
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
    
    public String getLongDescription()
    {
        String returnString = 
        "Title: "+super.getTitle()
        +" Duration: "+super.getDuration()
        +" Company: "+getCompany()
        +" Product: "+getProduct();
        return returnString;
    }
}
