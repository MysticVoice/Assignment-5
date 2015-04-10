import java.util.ArrayList;
/**
 * Write a description of class Media here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Media
{
   //protected ArrayList<AudioTracks> tracks;
   private AudioTracks list;
   private String title;
    /**
     * Constructor for objects of class Media
     */
    public Media(String title)
    {
        //this.tracks = new ArrayList<AudioTracks>();
        list = new AudioTracks();
        //tracks.add(list);
        this.title = title;
    }
      public void addTrack(AudioTrack track)
    {
        this.list.addTrack(track);
    }
    
}
