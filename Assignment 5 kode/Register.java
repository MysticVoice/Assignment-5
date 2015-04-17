import java.util.ArrayList;
/**
 * A controller class that controlls the content of other classes
 * 
 * @author (Fredrik M. Valderhaug) 
 * @version (1.0)
 */
public class Register
{
    private ArrayList<Mediums> mediumsList;

    /**
     * makes a register to initialize objects
     */
    public Register()
    {
        mediumsList = new ArrayList<Mediums>();
        fillRegister();
    }

    /**
     * creates all medium objects and track objects
     */
    private void fillRegister()
    {
        createMediumLists();
        
        Mediums harddisks = mediumsList.get(1);
        Mediums cds = mediumsList.get(0);
        Mediums tapes = mediumsList.get(2);
        
        CD cd;
        HDD disk;
        Tape tape;
        
        SubTrack preTrack;
        FileOnHDD track;
        // new medium
        cd = createCD("Darkside", "Some artist", 1990, "notsomuch");
        // tracks
        cd.addTrack(createMusicTrack("abc", 1, 10));
        cd.addTrack(createAdvJingle("ddadd", 2, 21));
        cd.addTrack(createAdvJingle("dd", 4, 10));
        cd.addTrack(createAdvJingle("dude", 3, 12));
        cd.addTrack(createAdvJingle("anedaddd", 3, 11));
        cd.addTrack(createAdvJingle("abhdakjmwdk", 2, 25));
        // new medium
        cd = createCD("something", "no idea", 8989, "another thing");
        // tracks
        cd.addTrack(createMusicTrack("abcd", 12, 13));
        // new medium
        disk = createHarddisk("the C");
        // tracks
        preTrack = createMusicTrack("akljdj", 5, 5);
        track = createFileOnHDD(preTrack, "C:'\'Users'\'Fredrik'\'Documents'\'GitHub'\'Assignment-5'\'Assignment 5 kode");
        disk.addTrack(track);
    }
    
    
    /**
     * creates a music track
     */
    private MusicTrack createMusicTrack(String title, long min, long sec)
    {
        MusicTrack track = new MusicTrack(title, min, sec);
        return track;
    }
    
    /**
     * creates an advertising jingle
     */
    private AdvertisingJingle createAdvJingle(String title, long min, long sec)
    {
        AdvertisingJingle track = new AdvertisingJingle(title, min, sec);
        return track;
    }
    
    /**
     * creates a news file
     */
    private News createNews(String title, long min, long sec)
    {
        News track = new News(title, min, sec);
        return track;
    }
    
    /**
     * creates a sound effect
     */
    private SoundEffect createSoundEffect(String title, long min, long sec)
    {
        SoundEffect track = new SoundEffect(title, min, sec);
        return track;
    }
    
    
    /**
     * creates a file for harddisk storage
     */
    private FileOnHDD createFileOnHDD(SubTrack track, String path)
    {
        FileOnHDD result;
        result = new FileOnHDD(track,path);
        return result;
    }
    
//     /**
//      * creates a music track for hdd
//      */
//     private FileOnHDD musicTrackHDD(String title, long min, long sec,String path)
//     {
//         FileOnHDD result;
//         Mediums harddisks = mediumsList.get(1);
//         Medium harddisk = harddisks.getMedium(0);
//         MusicTrack track = createMusicTrack(title,min,sec);
//         String fileName = title + ".mp3";
//         FileOnHDD file = createFileOnHDD(track,fileName,path);
//         ((HDD)harddisk).addFile(file);
//         result=file;
//         return result;
//     }
//     
//     /**
//      * creates an advertising jingle for hdd
//      */
//     private FileOnHDD advJingleHDD(String title, long min, long sec,String path)
//     {
//         FileOnHDD result;
//         Mediums harddisks = mediumsList.get(1);
//         Medium harddisk = harddisks.getMedium(0);
//         AdvertisingJingle track = createAdvJingle(title,min,sec);
//         String fileName = title + ".mp3";
//         FileOnHDD file = createFileOnHDD(track,fileName,path);
//         ((HDD)harddisk).addFile(file);
//         result=file;
//         return result;
//     }
//     
//     /**
//      * creates news for hdd
//      */
//     private FileOnHDD newsHDD(String title, long min, long sec,String path)
//     {
//         FileOnHDD result;
//         Mediums harddisks = mediumsList.get(1);
//         Medium harddisk = harddisks.getMedium(0);
//         News track = createNews(title,min,sec);
//         String fileName = title + ".mp3";
//         FileOnHDD file = createFileOnHDD(track,fileName,path);
//         ((HDD)harddisk).addFile(file);
//         result=file;
//         return result;
//     }
//     
//     /**
//      * creates sound effects for hdd
//      */
//     private FileOnHDD soundEffectHDD(String title, long min, long sec,String path)
//     {
//         FileOnHDD result;
//         Mediums harddisks = mediumsList.get(1);
//         Medium harddisk = harddisks.getMedium(0);
//         SoundEffect track = createSoundEffect(title,min,sec);
//         String fileName = title + ".mp3";
//         FileOnHDD file = createFileOnHDD(track,fileName,path);
//         ((HDD)harddisk).addFile(file);
//         result=file;
//         return result;
//     }
//     
    
    
    
    
    /**
     * makes all medium lists
     */
    private void createMediumLists()
    {
        Mediums cds, harddisks, tapes;
        cds = new Mediums();
        harddisks = new Mediums();
        tapes = new Mediums();
        mediumsList.add(cds);
        mediumsList.add(harddisks);
        mediumsList.add(tapes);
    }

    /**
     * makes a new tape
     */
    private Tape createTape(boolean digital)
    {
        Mediums tapes = mediumsList.get(2);
        Tape tape = new Tape(digital);
        tapes.addMedium(tape);
        return tape;
    }

    /**
     * makes a new harddisk
     */
    private HDD createHarddisk(String name)
    {
        Mediums harddisks = mediumsList.get(1);
        HDD harddisk = new HDD(name);
        harddisks.addMedium(harddisk);
        return harddisk;
    }

    /**
     * makes a new CD
     */
    private CD createCD(String album, String artist,int year, String label)
    {
        Mediums cds = mediumsList.get(0);
        CD cd = new CD(album,artist,year,label);
        cds.addMedium(cd);
        return cd;
    }
}
