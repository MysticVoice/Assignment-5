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
        Medium result = null;
        if(index < mediums.size())
            {result = mediums.get(index);}
        return result;
    }
    
    public Medium getMediumWMedium(Medium medium)
    {
        Medium resultMedium = null;
        for(int i=0;i<mediums.size();i++)
        {
            Medium tempMedium = mediums.get(i);
            if(tempMedium == medium)
            {
                resultMedium = tempMedium;
            }
        }
        return resultMedium;
    }
    
    /**
     * returns mediums
     */
    public String[] getMediumsString()
    {
        String[] returnArray;
        int size;
        size = getSize();
        returnArray = new String[size];
        for(int i = 0; i<size; i++)
        {
            returnArray[i] = mediums.get(i).getText();
        }
        return returnArray;
    }
    
    public String getMediumPrintString()
    {
        String returnString = "";
        int size = getSize();
        for(int i = 0; i<size; i++)
        {
            Medium medium = mediums.get(i);
            returnString += "\n"+ i + ". " +medium.getText() + "  medium: " + getType(medium)+
            medium.getTracksDescription();
        }
        return returnString;
    }
    
    public String getType(Medium medium)
    {
        String returnString = "";
        if(medium instanceof CD)
        {
            returnString = "CD";
        }
        else if(medium instanceof Tape)
        {
            returnString = "Tape";
        }
        else if(medium instanceof HDD)
        {
            returnString = "HDD";
        }
        return returnString;
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
