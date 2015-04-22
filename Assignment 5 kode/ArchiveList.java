
/**
 * Write a description of class ArchiveList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArchiveList
{
    // instance variables - replace the example below with your own
    private int archiveSpecific;
    private String name;
    private Mediums mediums;
    private int mediumsIndex;

    /**
     * Constructor for objects of class ArchiveList
     */
    public ArchiveList(String name, int archiveNumber, Mediums mediums)
    {
        this.name = name;
        archiveSpecific = archiveNumber;
        this.mediums = mediums;
    }
    
    public void addMedium(Medium medium)
    {
        //Don't know why this sets the first objects archive number to 10001 
        //but it works to our advantage so who cares
        int index;
        if(detectNull())
        {
            Medium mediumReplaced;
            mediumReplaced = mediums.getMedium(mediumsIndex);
            mediumReplaced = medium;
            ((ExternalMedium)medium).setArchiveNr(mediumsIndex+archiveSpecific);
        }
        else
        {
            mediums.addMedium(medium);
            index = mediums.getSize();
            ((ExternalMedium)medium).setArchiveNr(index+archiveSpecific);
        }
    }
    
    
    
    private boolean detectNull()
    {
        boolean result;
        result = false;
        for (int i = 1; i< mediums.getSize(); i++)
        {
            Medium medium = mediums.getMedium(i);
            if(medium == null)
            {
                result = true;
                mediumsIndex = i;
            }
        }
        return result;
    }
    
    public void setNull(Medium medium)
    {
        mediums.nullifyMedium(medium);
    }
}
