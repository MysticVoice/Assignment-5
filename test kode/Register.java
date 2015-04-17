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

    }
    public Media makecd()
    {
        CD cd = new CD("title", "artist", "label", 1992);
        return cd;
    }


    public AudioTrack SoundEffect(String description, String title, long minutes, long seconds)
    {
        AudioTrack soundEffect = new SoundEffect(description, title, minutes, seconds);
        return soundEffect;
    }

    public AudioTrack createMusic(String artist, String dateLastPlayed, int timesPlayed, String title, long minutes, long seconds)
    {
        AudioTrack music = new Music(artist, dateLastPlayed, timesPlayed, title, minutes, seconds);
        return music;
    }

    public AudioTrack createAdvertisingJingle(String product, String company, String title, long minutes, long seconds)
    {
        AudioTrack advertisingJingle = new AdvertisingJingle(product, company, title, minutes, seconds); 
        return advertisingJingle;
    }

    public AudioTrack createNews(String newsStory, String dateMade, String dateBroadcasted, String journalist, String title, long minutes, long seconds)
    {
        AudioTrack news = new News(newsStory, dateMade, dateBroadcasted, journalist, title, minutes, seconds); 
        return news;
    }

    public void fillregister()
    {
       // AllMedia allMedia1 = new AllMedia();
        CD cD1 = new CD("", "", "", 1992);
        Tape tape1 = new Tape("", "");
        Music music1 = new Music("", "", 1, "", 1, 1);
        AdvertisingJingle advertis1 = new AdvertisingJingle("", "", "", 1, 1);
        News news1 = new News("", "", "", "", "", 1, 1);
        SoundEffect soundEff1 = new SoundEffect("", "", 1, 1);
        star.addMedia(cD1);
        star.addMedia(tape1);
        cD1.addTrack(music1);
        cD1.addTrack(advertis1);
        tape1.addTrack(soundEff1);
        tape1.addTrack(news1);
        cD1.setLabel("8");
    }

}