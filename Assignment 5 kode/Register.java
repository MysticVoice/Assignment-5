import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * A controller class that controlls the content of other classes
 * 
 * @author (Fredrik M. Valderhaug) 
 * @version (1.0)
 */
public class Register
{
    private ArrayList<Mediums> mediumsList;

    /**
     * Constructor for objects of class Radio
     */
    public Register()
    {
        mediumsList = new ArrayList<Mediums>();
        fillRegister();
    }

    private void fillRegister()
    {
        createMediumLists();
        createCD("Darkside", "Some artist", 1990, "notsomuch");
        createHarddisk("The D");
        createTape(false);
    }
    
    
    
    
    
    
    
    private MusicTrack createMusicTrack(String title, long min, long sec)
    {
        MusicTrack track = new MusicTrack(title, min, sec);
        return track;
    }
    
    private AdvertisingJingle createAdvJingle(String title, long min, long sec)
    {
        AdvertisingJingle track = new AdvertisingJingle(title, min, sec);
        return track;
    }
    
    private News createNews(String title, long min, long sec)
    {
        News track = new News(title, min, sec);
        return track;
    }
    
    private SoundEffect createSoundEffect(String title, long min, long sec)
    {
        SoundEffect track = new SoundEffect(title, min, sec);
        return track;
    }
    
    
    
    
    
    
    
//     private FileOnHDD musicTrackOnHDD()
//     {
//         Mediums harddisks = mediumsList.get(1);
//         //harddisks
//         //createMusicTrack();
//     }
    
    
    
    
    
    
    private void createMediumLists()
    {
        Mediums cds, harddisks, tapes;
        cds = new Mediums();
        harddisks = new Mediums();
        tapes = new Mediums();
        mediumsList.add(cds);
        mediumsList.add(harddisks);
        mediumsList.add(tapes);
    }

    private void createTape(boolean digital)
    {
        Mediums tapes = mediumsList.get(2);
        Tape tape = new Tape(digital);
        tapes.addMedium(tape);
    }

    private void createHarddisk(String name)
    {
        Mediums harddisks = mediumsList.get(1);
        HDD harddisk = new HDD(name);
        harddisks.addMedium(harddisk);
    }

    private void createCD(String album, String artist,int year, String label)
    {
        Mediums cds = mediumsList.get(0);
        CD cd = new CD(album,artist,year,label);
        cds.addMedium(cd);
    }
}
