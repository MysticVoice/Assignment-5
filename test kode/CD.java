
/**
 * Write a description of class CD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD extends Physical
{
    // instance variables - replace the example below with your own
    private String artist;
    private String label;
    private int year;
    private String duration;
    

    /**
     * Constructor for objects of class CD
     */
    public CD(String title, String artist, String label, int year, int min, int sec)
    {
       super(title);
       this.artist = artist;
       this.label = label;
       this.year = year;
       duration = min + ":" + sec;
       
      
    }

   
}
