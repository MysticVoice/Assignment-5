
/**
 * Keeps track of the archive numbers of objects of ExternalMedium
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArchiveList
{
    private int archiveSpecific;
    private String name;
    private Mediums mediums;
    private int mediumsIndex;

    /**
     * Creates an archive which will distribute a selection of archive numbers
     */
    public ArchiveList(String name, int archiveNumber, Mediums mediums)
    {
        this.name = name;
        archiveSpecific = archiveNumber;
        this.mediums = mediums;
    }
    
    /**
     * Adds a medium to the first available index;
     */
    public void addMedium(Medium medium)
    {
        int index = mediumsIndex;
        if(detectNull())
        {
            Medium mediumReplaced;
            mediums.setMedium(index, medium);
            ((ExternalMedium)medium).setArchiveNr(mediumsIndex+archiveSpecific);
        }
        else
        {
            mediums.addMedium(medium);
            index = mediums.getSize();
            ((ExternalMedium)medium).setArchiveNr(index+archiveSpecific);
        }
    }
    
    
    /**
     * detects the first available index in mediums
     */
    private boolean detectNull()
    {
        boolean result;
        result = false;
        for (int i = 1; i< mediums.getSize(); i++)
        {
            Medium medium = mediums.getMedium(i);
            if(medium instanceof ExternalMedium)
            {}
            else if(medium instanceof HDD)
            {}
            else
            {
                result = true;
                mediumsIndex = i;
            }
        }
        return result;
    }
    
    /**
     * Gives a medium to mediums for nullification
     */
    public void setNull(Medium medium)
    {
        mediums.nullifyMedium(medium);
    }
    
    public int getSpecific()
    {
        return archiveSpecific;
    }
    
    public Mediums getMediums()
    {
        return mediums;
    }
}
