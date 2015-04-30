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
    
    public Mediums combineMediums(Mediums mediums1, Mediums mediums2)
    {
        Mediums mediums = mediums1;
        for(int index = 0; index < mediums2.getSize();index++)
        {
            Medium medium = mediums2.getMedium(index);
            mediums.addMedium(medium);
        }
        return mediums;
    }
    
    public Mediums combineAllMediums()
    {
        Mediums cds = mediumsList.get(0);
        Mediums harddisks = mediumsList.get(1);
        Mediums tapes = mediumsList.get(2);
        Mediums mediums = new Mediums();
        mediums = combineMediums(mediums, cds);
        mediums = combineMediums(mediums, harddisks);
        mediums = combineMediums(mediums, tapes);
        return mediums;
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
        cd = createCD("Wrecking Ball", "Bruce Springsteen", 2012, "Columbia");
        // tracks
        cd.addTrack(createMusicTrack("We Take Care Of Our Own", "Bruce Springsteen", 3, 53));
        cd.addTrack(createMusicTrack("Shackled And Draw", "Bruce Springsteen", 3, 44));
        cd.addTrack(createMusicTrack("Death To My Horn", "Bruce Springsteen", 3, 25));
        cd.addTrack(createMusicTrack("Land Of Hope And Dreams", "Bruce Springsteen", 6, 56));
        cd.addTrack(createMusicTrack("We Are Alive", "Bruce Springsteen", 5, 34));
        cd.addTrack(createMusicTrack("Swallowed Up", "Bruce Springsteen", 1, 10));
        cd.addTrack(createMusicTrack("this Depression", "Bruce Springsteen", 4, 8));
        cd.addTrack(createMusicTrack("Jack Of All Trades", "Bruce Springsteen", 5, 58));
        
         // new medium
        cd = createCD("Asylum", "Disturbed", 2010, "Reprise records");
        // tracks
        cd.addTrack(createMusicTrack("Remnants", "Disturbed", 2, 43));
        cd.addTrack(createMusicTrack("Asylum", "Disturbed", 4, 36));
        cd.addTrack(createMusicTrack("The Infection", "Disturbed", 4, 8));
        cd.addTrack(createMusicTrack("Another Way To Die", "Disturbed", 4, 13));
        cd.addTrack(createMusicTrack("Crucified", "Disturbed", 4, 36));
        cd.addTrack(createMusicTrack("Never Again", "Disturbed", 3, 33));
        
         // new medium
        cd = createCD("Underpantsblues", "Vidar and the Bluesberries", 2010, "vølda records");
        // tracks
        cd.addTrack(createMusicTrack("Those pants Must Come Off", "Vidar and the Bluesberries", 2, 43));
        cd.addTrack(createMusicTrack("Shave That Ass", "Vidar and the Bluesberries", 4, 36));
        cd.addTrack(createMusicTrack("Why Have`nt You Showered Yet", "Vidar and the Bluesberries", 4, 8));
        cd.addTrack(createMusicTrack("Another Way to Grow a Beard", "Vidar and the Bluesberries", 4, 13));
        cd.addTrack(createMusicTrack("Yerking Off in a Saloon", "Vidar and the Bluesberries", 4, 36));
        cd.addTrack(createMusicTrack("My Hairy Back", "Vidar and the Bluesberries", 3, 33));
        cd.addTrack(createMusicTrack("Can´t See My Wiener Anymore", "Vidar and the Bluesberries", 3, 56));
        
        
        //new medium
        cd = createCD("Songs Of God And Whiskey", "The Airborne Toxic Event", 2015, "Epic Records");
        //tracks
        cd.addTrack(createMusicTrack("Poor Isaac", "The Airborne Toxic Event", 3, 11));
        cd.addTrack(createMusicTrack("Cocaine and Abel", "The Airborne Toxic Event", 3, 17));
        cd.addTrack(createMusicTrack("Strangers", "The Airborne Toxic Event", 3, 36));
        cd.addTrack(createMusicTrack("California", "The Airborne Toxic Event", 3, 30));
        cd.addTrack(createMusicTrack("The Fall of Rome", "The Airborne Toxic Event", 3, 41));
        
        //new medium
        cd = createCD("No More Stories", "Mew", 2009, "Petrolium Records");
        //tracks
        cd.addTrack(createMusicTrack("New Terrain", "Mew", 3, 14));
        cd.addTrack(createMusicTrack("Beach", "Mew", 2, 46));
        cd.addTrack(createMusicTrack("Repeaterbeater", "Mew", 2, 33));
        cd.addTrack(createMusicTrack("Tricks Of The Trade", "Mew", 4, 29));
        cd.addTrack(createMusicTrack("Intermezzo 2", "Mew", 1, 35));
        
        //new medium
        cd = createCD("Friends On Mushrooms", "Infected Mushroom", 2015, "Dim Mak Records");
        //tracks
        cd.addTrack(createMusicTrack("Bass Nipple", "Infected Mushroom", 5, 47));
        cd.addTrack(createMusicTrack("Sanvant on Mushroom", "Infected Mushroom", 6, 18));
        cd.addTrack(createMusicTrack("Rise Up", "Infected Mushroom", 5, 29));
        cd.addTrack(createMusicTrack("Where Do I Belong", "Infected Mushroom", 3, 26));
        cd.addTrack(createMusicTrack("See Me Now", "Infected Mushroom", 5, 20));
        
        //new medium
        tape = createTape(true, "Sonic Soul Surfer");
        //tracks
        tape.addTrack(createMusicTrack("Roy`s Gang", "SEASICK STEVE", 6, 7));
        tape.addTrack(createMusicTrack("Bring it On", "SEASICK STEVE", 3, 47));
        tape.addTrack(createMusicTrack("In Peaceful Dream", "SEASICK STEVE", 2, 43));
        tape.addTrack(createMusicTrack("Sonic Soul Boggie", "SEASICK STEVE", 5, 22));
        tape.addTrack(createMusicTrack("We Be Moving", "SEASICK STEVE", 5, 21));
        
        //new medium
        tape = createTape(true, "The Day Is My Enemy");
        //tracks
        tape.addTrack(createMusicTrack("The Day Is My Enemy", "The Prodigy", 4, 24));
        tape.addTrack(createMusicTrack("Rebel Radio", "The Prodigy", 3, 52));
        tape.addTrack(createMusicTrack("Destroy", "The Prodigy", 4, 28));
        tape.addTrack(createMusicTrack("Beyond the Deathray", "The Prodigy", 3, 8));
        tape.addTrack(createMusicTrack("Medicine", "The Prodigy", 3, 56));
        
        //new medium
        tape = createTape(true, "Days To Come");
        //tracks
        tape.addTrack(createMusicTrack("Days to Come", "Seven Lions", 4, 44));
        tape.addTrack(createMusicTrack("The Truth", "Seven Lions", 5, 32));
        tape.addTrack(createMusicTrack("Fractals", "Seven Lions", 4, 54));
        tape.addTrack(createMusicTrack("She Was", "Seven Lions", 4, 54));
        
        //new medium
        tape = createTape(true, "Ten");
        // tracks
        tape.addTrack(createMusicTrack("Even Flow", "Parl Jam", 4, 54));
        tape.addTrack(createMusicTrack("Alive", "Parl Jam", 5, 41));
        tape.addTrack(createMusicTrack("Why Go", "Parl Jam", 3, 20));
        tape.addTrack(createMusicTrack("Jeremy", "Parl Jam", 5, 18));
        tape.addTrack(createMusicTrack("Oceans", "Parl Jam", 2, 42));
        tape.addTrack(createMusicTrack("Garden", "Parl Jam", 4, 59));
        
        //new medium
        tape = createTape(true, "Echo Of Miles");
        // tracks
        tape.addTrack(createMusicTrack("Heretic", "Soundgarden", 3, 50));
        tape.addTrack(createMusicTrack("Fresj Deadly Roses", "Soundgarden", 4, 51));
        tape.addTrack(createMusicTrack("Cold Bitch", "Soundgarden", 4, 59));
        tape.addTrack(createMusicTrack("Blind Dogs", "Soundgarden", 4, 40));
        tape.addTrack(createMusicTrack("Soundgarden", "Soundgarden", 3, 53));
        tape.addTrack(createMusicTrack("Live To Rise", "Soundgarden", 4, 40));
        tape.addTrack(createMusicTrack("Storm", "Soundgarden", 5, 25));
        tape.addTrack(createMusicTrack("Birth Ritiual", "Soundgarden", 6, 4));
        
        //new medium
        tape = createTape(true, "In A Time Lapse");
        // tracks
        tape.addTrack(createMusicTrack("Fly", "Ludovico Einaudi", 3, 43));
        tape.addTrack(createMusicTrack("Divenire", "Ludovico Einaudi", 4, 51));
        tape.addTrack(createMusicTrack("Ora", "Ludovico Einaudi", 7, 53));
        tape.addTrack(createMusicTrack("Una Mattina", "Ludovico Einaudi", 4, 40));
        tape.addTrack(createMusicTrack("Nuvole Bianche", "Ludovico Einaudi", 3, 53));
        tape.addTrack(createMusicTrack("Ancora", "Ludovico Einaudi", 4, 40));
        tape.addTrack(createMusicTrack("Walk", "Ludovico Einaudi", 3, 25));
        tape.addTrack(createMusicTrack("The Earth", "Ludovico Einaudi", 5, 4));
        
        //new medium
        cd = createCD("Adv.Jingles", "GloppenMade", 2009, "Advertising Records");
        // jingles
        cd.addTrack(createAdvJingle("soda", 1, 21, "Coca Cola", "Coca Cola Company"));
        cd.addTrack(createAdvJingle("Durexlove", 1, 10, "Ultrathin", "Private Shop"));
        cd.addTrack(createAdvJingle("clothsweare", 1, 3, "clothessale", "Jack & Jones"));
        cd.addTrack(createAdvJingle("foodadv.", 3, 11, "Milkproducts", "The Tine Meierimonopol"));
        cd.addTrack(createAdvJingle("Musicinstruments", 2, 25, "Vidars Ukulele", "Vidars Private giftshop"));
                
        // new medium
        disk = createHarddisk("the C");
        
        // track 
        disk.addTrack(createMusicTrack("Stole the Show", "Kygo feat.Parson James", 3, 43));
        disk.addTrack(createMusicTrack("Thinking Out Loud", "Ed Sheeran", 4, 41));
        disk.addTrack(createMusicTrack("FourFiveSeconds", "Rihanna & Kanye West & Paul McCartney", 3, 8));
        disk.addTrack(createMusicTrack("Leaving No Traces", "HighHasakite", 4, 21));
        disk.addTrack(createMusicTrack("Dangerous", "David Guetta", 3, 23));
        disk.addTrack(createMusicTrack("Am I Wrong", "Nico & Vinz", 4, 9));
        disk.addTrack(createMusicTrack("Pet Cemetary", "DJ QUIK", 4, 6));
        disk.addTrack(createMusicTrack("Dum Dum Minister", "Black Debbath", 4, 59));
        disk.addTrack(createMusicTrack("Seven Hills", "While She Sleeps", 4, 20));
        disk.addTrack(createMusicTrack("Scars", "Upon A Burning Body", 3, 45));
        disk.addTrack(createMusicTrack("Fear Of Napalm", "Terrorizer", 3, 1));
        disk.addTrack(createMusicTrack("Losing Sleep", "Comeback Kid", 2, 40));
        disk.addTrack(createMusicTrack("Prophet", "Truckfighters", 4, 47));
        disk.addTrack(createMusicTrack("Holy Matter", "Blood Suckers", 1, 39));
        disk.addTrack(createMusicTrack("Human Filler", "Heksed", 1, 16));
        disk.addTrack(createMusicTrack("One of These Days", "Die A Legend", 2, 51));
         
       
        
        //track = createFileOnHDD(preTrack, "C:'\'Users'\'Fredrik'\'Documents'\'GitHub'\'Assignment-5'\'Assignment 5 kode");
        //disk.addTrack(track);
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
