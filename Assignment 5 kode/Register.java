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
    private ArrayList<ArchiveList> archiveLists;
    
    /**
     * makes a register to initialize objects
     */
    public Register()
    {
        archiveLists = new ArrayList<ArchiveList>();
        mediumsList = new ArrayList<Mediums>();
        fillRegister();
    }
    
    public ArchiveList getArchive(int index)
    {
        return archiveLists.get(index);
    }
    
    /**
     * creates all medium objects and track objects
     */
    private void fillRegister()
    {
        createMediumLists();
        
        createArchiveList("Archive CDs", 10000);
        createArchiveList("Archive Tapes", 20000);
        
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
        cd.addTrack(createMusicTrack("abc", "runnaround foools", 1, 10));
        cd.addTrack(createAdvJingle("ddadd", 2, 21, "broomstick", "The totaly not witches assosciation"));
        cd.addTrack(createAdvJingle("dd", 4, 10, "broomstick v2", "The totaly not witches assosciation"));
        cd.addTrack(createAdvJingle("dude", 3, 12, "death in a box", "a very large squirrel"));
        cd.addTrack(createAdvJingle("anedaddd", 3, 11, "natural disasters", "Mad cows"));
        cd.addTrack(createAdvJingle("abhdakjmwdk", 2, 25, "Three skittles", "Cats"));
        
        
        // new medium
        cd = createCD("something", "no idea", 8989, "another thing");
        // tracks
        cd.addTrack(createMusicTrack("abcd", "Tryhard squad", 12, 13));
        // new medium
        disk = createHarddisk("the C");
        // tracks
        preTrack = createMusicTrack("akljdj", "The indiginous idiots", 5, 5);
        track = createFileOnHDD(preTrack, "C:'\'Users'\'Fredrik'\'Documents'\'GitHub'\'Assignment-5'\'Assignment 5 kode");
        disk.addTrack(track);
    }
    
    public Mediums getMediums(int index)
    {
        return mediumsList.get(index);
    }
    
    /**
     * creates a music track
     */
    private MusicTrack createMusicTrack(String title, String artist, long min, long sec)
    {
        MusicTrack track = new MusicTrack(title, artist, min, sec);
        return track;
    }
    
    /**
     * creates an advertising jingle
     */
    private AdvertisingJingle createAdvJingle(String title, long min, long sec, String product, String company)
    {
        AdvertisingJingle track = new AdvertisingJingle(title, min, sec, product, company);
        return track;
    }
    
    /**
     * creates a news file
     */
    private News createNews(String title, String journalist, long min, long sec, String summary)
    {
        News track = new News(title, journalist, min, sec, summary);
        return track;
    }
    
    /**
     * creates a sound effect
     */
    private SoundEffect createSoundEffect(String title, long min, long sec, String description)
    {
        SoundEffect track = new SoundEffect(title, min, sec, description);
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
    
    /**
     * returns mediumsList
     */
    public ArrayList<Mediums> getMediumsList()
    {
        return mediumsList;
    }
    
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
     * creates a new Mediums
     */
    public Mediums createMediums()
    {
        Mediums mediums = new Mediums();
        return mediums;
    }

    /**
     * makes a new Tape
     */
    private Tape createTape(boolean digital, String title)
    {
        Mediums tapes = mediumsList.get(2);
        Tape tape = new Tape(digital,title);
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
    public CD createCD(String album, String artist,int year, String label)
    {
        ArchiveList cdArchive = archiveLists.get(0);
        Mediums cds = mediumsList.get(0);
        CD cd = new CD(album,artist,year,label);
        cds.addMedium(cd);
        cdArchive.addMedium(cd);
        
        return cd;
    }
    
    /**
     * Creates a new ArchiveList
     */
    public void createArchiveList(String name, int archiveNr)
    {
        Mediums mediums = createMediums();
        ArchiveList archive = new ArchiveList(name, archiveNr, mediums);
        archiveLists.add(archive);
    }
    
    /**
     * removes a medium from archivelist and mediums
     */
    public void removeMedium(Medium medium)
    {
        Mediums cds, tapes, harddisks;
        ArchiveList archiveCds, archiveTapes;
        
        cds = mediumsList.get(0);
        harddisks = mediumsList.get(1);
        tapes = mediumsList.get(2);
        
        archiveCds = archiveLists.get(0);
        archiveTapes = archiveLists.get(1);
        
        boolean stuff;
        
        if(medium instanceof ExternalMedium)
        {
            if(medium instanceof CD)
            {
                cds.removeMedium(medium);
                archiveCds.setNull(medium);
                stuff = true;
            }
            else if (medium instanceof Tape)
            {
                tapes.removeMedium(medium);
                archiveTapes.setNull(medium);
            }
        }
        else if (medium instanceof HDD)
        {
            harddisks.removeMedium(medium);
        }
    }
}
