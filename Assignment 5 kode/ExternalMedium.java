
/**
 * Write a description of class AnalogMedium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExternalMedium extends Medium
{
    private int archiveNr;
    
    /**
     * Constructor for objects of class AnalogMedium
     */
    public ExternalMedium()
    {
        
    }
    
    public void setArchiveNr(int archiveNr)
    {
        this.archiveNr=archiveNr;
    }
    
    public int getArchiveNr()
    {
        return archiveNr;
    }
}
