import java.util.ArrayList;
/**
 * Contains a list of mediums
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mediums
{
    private ArrayList<Medium> mediums;

    /**
     * Creates a list of mediums
     */
    public Mediums()
    {
        mediums = new ArrayList<Medium>();
    }
    
    /**
     * adds a medium to mediums
     */
    public void addMedium(Medium medium)
    {
        mediums.add(medium);
    }
    
    /**
     * removes a medium from mediums
     */
    public void removeMedium(Medium medium)
    {
        mediums.remove(medium);
    }
    
    /**
     * Gets a medium from mediums
     */
    public Medium getMedium(int index)
    {
        return mediums.get(index);
    }
    
    /**
     * returns mediums
     */
    public ArrayList<Medium> getMediums()
    {
        return mediums;
    }
    
    /**
     * replaces a medium with another
     */
    public void setMedium(int index, Medium medium)
    {
        mediums.set(index, medium);
    }
    
    /**
     * Creates a placeholder medium for ArchiveList
     */
    public void nullifyMedium(Medium medium)
    {
        int arcNr = ((ExternalMedium)medium).getArchiveNr();
        int index;
        Medium replace = new Medium();
        if(medium instanceof CD)
        {
            index = arcNr - 10001;
            mediums.set(index, replace);
        }
        else if(medium instanceof Tape)
        {
            index = arcNr - 20001;
            mediums.set(index, replace);
        }
    }
    
    /**
     * returns the size of mediums
     */
    public int getSize()
    {
        return mediums.size();
    }
}
