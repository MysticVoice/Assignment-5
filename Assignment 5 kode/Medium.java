import java.util.ArrayList;
/**
 * Main medium class
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medium
{
    protected Tracks tracks;
    /**
     * Creates a new medium
     */
    public Medium()
    {
        tracks = new Tracks();
    }
    
    /**
     * adds a track to tracks
     */
    public void addTrack(Track track)
    {
        tracks.addTrack(track);
    }
    
    public int getSize()
    {
        return tracks.getSize();
    }
    
    /**
     * Returns a track
     */
    public Track getTrack(int index)
    {
        return tracks.getTrack(index);
    }
    
    public String[] getTracksString()
    {
        String[] returnArray;
        int size;
        size = tracks.getSize();
        returnArray = new String[size];
        for(int i = 0; i<size; i++)
        {
            returnArray[i] = tracks.getTrack(i).getTitle();
        }
        return returnArray;
    }
    
    public String getTracksDescription()
    {
        String returnString;
        int size;
        size = tracks.getSize();
        returnString = "\n";
        for(int i = 0; i<size; i++)
        {
            returnString += tracks.getTrack(i).getLongDescription() + "\n";
        }
        return returnString;
    }
    
    public String getTracksDescriptionWIndex()
    {
        String returnString;
        int size;
        size = tracks.getSize();
        returnString = "\n";
        for(int i = 0; i<size; i++)
        {
            returnString +=i+". " + tracks.getTrack(i).getLongDescription() + "\n";
        }
        return returnString;
    }
    
    public String getLongDescription(){return "";}
    
    /**
     * Gets gui text
     */
    public String getText()
    {
        String resultString = "";
        return resultString;
    }
}
