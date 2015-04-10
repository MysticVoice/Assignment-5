
/**
 * Write a description of class AnalogMedium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExternalMedium extends Medium
{
    private int archiveNr;
    protected Tracks tracks;
    /**
     * Constructor for objects of class AnalogMedium
     */
    public ExternalMedium()
    {
        tracks = new Tracks();
    }
}
