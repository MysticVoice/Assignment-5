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
            returnArray[i] = tracks.getTrack(i).getText();
        }
        return returnArray;
    }
    
    /**
     * Gets gui text
     */
    public String getText()
    {
        String resultString = "";
        return resultString;
    }
}
