
/**
 * Write a description of class Arcive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arcive
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class Arcive
     */
    public Arcive()
    {
        // initialise instance variables
       
    }

   public void createMusic(String artist, String dateLastPlayed, int timesPlayed, String title, double minutes, double seconds)
    {
        AudioTrack music = new Music(artist, dateLastPlayed, timesPlayed, title, minutes, seconds);
    }
    
    public void createAdvertisingJingle(String product, String company, String title, double minutes, double seconds)
    {
        AudioTrack advertisingJingle = new AdvertisingJingle(product, company, title, minutes, seconds); 
    }
    
     public void createNews(String newsStory, String dateMade, String dateBroadcasted, String journalist, String title, double minutes, double seconds)
    {
        AudioTrack news = new News(newsStory, dateMade, dateBroadcasted, journalist, title, minutes, seconds); 
    }
    
    public void SoundEffect(String description, String title, double minutes, double seconds)
    {
        AudioTrack soundEffect = new SoundEffect(description, title, minutes, seconds);
    }
}
