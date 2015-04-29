
/**
 * Holds mediums that require an archive number
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ExternalMedium extends Medium
{
    private int archiveNr;
    
    /**
     * Constructor for objects of class External medium
     */
    public ExternalMedium()
    {
        
    }
    
    /**
     * sets the archive number of the Medium
     */
    public void setArchiveNr(int archiveNr)
    {
        this.archiveNr=archiveNr;
    }
    
    /**
     * returns archive number
     */
    public int getArchiveNr()
    {
        return archiveNr;
    }
}
