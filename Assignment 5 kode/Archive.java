import java.util.ArrayList;
import java.util.Scanner;
/**
 * All UI functionality will be collected here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Archive
{
    private Register register;
    private Track activeTrack;
    private Scanner scan;

    /**
     * Constructor for objects of class Archive
     */
    public Archive()
    {
        register = new Register();
        //activeMedium = getCDList().get(0);
    }
    
    public Mediums selectMediums(int index)
    {
        return register.getMediums(index);
    }
    
    /**
     * Gets an arraylist of cds
     */
    public String[] getStringListMediums(Mediums mediums){
        return mediums.getMediumsString();
    }
    
    public Mediums searchArchive(String input)
    {
        ArchiveList cdArchive = register.getArchive(0);
        ArchiveList tapeArchive = register.getArchive(1);
        
        Mediums mediums1 = searchByArchiveNr(input, cdArchive);
        Mediums mediums2 = searchByArchiveNr(input, tapeArchive);
        Mediums mediums = combineMediums(mediums1,mediums2);
        return mediums;
    }
    
    public Mediums combineMediums(Mediums mediums1, Mediums mediums2)
    {
        Mediums mediums = mediums1;
        for(int index = 0; index < mediums2.getSize();index++)
        {
            Medium medium = mediums2.getMedium(index);
            mediums.addMedium(medium);
        }
        return mediums;
    }
    
    /**
     * Searches for cd with an artist string that contains the input string
     */
    public Mediums searchByArchiveNr(String input,ArchiveList list)
    {
        Mediums mediums = new Mediums();
        Mediums listMediums = list.getMediums();
        scan = new Scanner(input);
        if(scan.hasNextInt())
        {
            int arcNr = scan.nextInt() - list.getSpecific() - 1;
            if(arcNr < listMediums.getSize())
            {
                mediums.addMedium(listMediums.getMedium(arcNr));
            }
        }
        return mediums;
    }
    
    /**
     * Removes a medium
     */
    public void removeMedium(Medium medium)
    {
        register.removeMedium(medium);
    }
}
