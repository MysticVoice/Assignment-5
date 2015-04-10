import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * Write a description of class Radio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        createCD("Fiesty Cupcakes","The Slightly Moldy Cheeses", 2015, "Very obscure");
    }
    
    private void addMedium(Medium medium)
    {
        Mediums mediums=mediumsList.get(0);
        mediums.addMedium(medium);
    }
    
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
    
//     private void createTape()
//     {
//         Mediums tapes = mediumsList.get(2);
//         tapes.newTape();
//     }
//     
//     private void createHarddisk()
//     {
//         Mediums harddisks = mediumsList.get(1);
//         harddisks.newHarddisk();
//     }
    
    private void createCD(String album, String artist,int year, String label)
    {
        Mediums cds = mediumsList.get(0);
        cds.newCD(album,artist,year,label);
    }
}
