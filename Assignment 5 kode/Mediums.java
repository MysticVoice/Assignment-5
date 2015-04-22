import java.util.ArrayList;
/**
 * Write a description of class Mediums here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mediums
{
    private ArrayList<Medium> mediums;

    /**
     * Constructor for objects of class Mediums
     */
    public Mediums()
    {
        mediums = new ArrayList<Medium>();
    }
    
    public void addMedium(Medium medium)
    {
        mediums.add(medium);
    }
    
    public void removeMedium(Medium medium)
    {
        mediums.remove(medium);
    }
    
    public Medium getMedium(int index)
    {
        return mediums.get(index);
    }
    
    public ArrayList<Medium> getMediums()
    {
        return mediums;
    }
    
    public void nullifyMedium(Medium medium)
    {
        medium = null;
    }
    
    public int getSize()
    {
        return mediums.size();
    }
}
