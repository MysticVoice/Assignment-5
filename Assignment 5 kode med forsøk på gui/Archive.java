import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * All UI functionality will be collected here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Archive
{
    private Register register;
    private Scanner scan;
    private Mediums activeMediums;
    private Tracks activeTracks;
    private Parser parser;
    private static int MENY = 4;
    
    /**
     * Constructor for objects of class Archive
     */
    public Archive()
    {
        register = new Register();
        parser = new Parser();
        play();
    }
    
    /**
     * returns all medims in a single Mediums
     */
    public Mediums allMediums()
    {
        Mediums allMediums = register.combineAllMediums();
        return allMediums;
        
    }
    
    /**
     * keeps the program running
     */
    public void play()
    {
        clear();
        System.out.print("Hi folks, let's push some buttons" + "\n");
        printMainMenu();
        boolean finished = false;
        while (!finished)
        {
            finished = selectMenu();
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::");
    }
    
    /**
     * simulates the main menu
     */
    private boolean selectMenu()
    {
        boolean wantToQuit = false;
        
        int value = parser.getUserMenuSelection(MENY);
        switch(value) {
            case 1:
            clear();             
            printSearchMenu();
            printMainMenu();
            break;
            
            case 2:
            clear();
            printListMenu();
            printMainMenu();
            break;
            
            case 3:
            clear();
            printAddMediumMenu();
            printMainMenu();
            break;
            
            case 4:
            clear();
            return true;
        }
        return wantToQuit;
    }
    
    /**
     * Gets a mediums list from register
     */
    public Mediums selectMediums(int index)
    {
        return register.getMediums(index);
    }
   
    
    /**
     * Gets an arraylist of cds
     */
    public String[] getStringListMediums(Mediums mediums){
        return mediums.getMediumsString();
    }
    
    /**
     * searches mediums by archive number
     * returns a single medium
     */
    public Medium searchArchive()
    {
        String input =  parser.getStringidi();
        System.out.println(tellUsWhatToDo());
        
        ArchiveList cdArchive = register.getArchive(0);
        ArchiveList tapeArchive = register.getArchive(1);
        Medium medium = null;
        Medium medium1 = searchByArchiveNr(input, cdArchive);
        Medium medium2 = searchByArchiveNr(input, tapeArchive);
        if (medium1 != null)
        {
            medium = medium1;
        }
        else if (medium2 != null)
        {
            medium = medium2;
        }

        if(medium != null)
        {System.out.print(medium.getLongDescription());}
        else
        {System.out.print("No results.");}
        System.out.println("");

        
        System.out.print(medium.getLongDescription());

        return medium;
        
    }
    
    /**
     * Searches for cd with an artist string that contains the input string
     */
    public Medium searchByArchiveNr(String input,ArchiveList list)
    {
        Medium medium=null;
        Mediums listMediums = list.getMediums();
        scan = new Scanner(input);
        if(scan.hasNextInt())
        {
            int arcNr = scan.nextInt();
            int listValue = list.getSpecific()+1;
            if (arcNr >= listValue)
            {
                int index = arcNr - listValue;
                if(index <= listMediums.getSize())
                {
                    medium = listMediums.getMedium(index);
                }
            }
        }
        return medium;
    }
    
    /**
     * Searches for cd with an artist string that contains the input string
     */
    public Tracks searchByTitle()
    {
        String input =  parser.getStringidi();
        System.out.println("To edit a track type: Edit.");
        activeTracks=new Tracks();
        int stuffs = 0;
        for(int something = 0; something < allMediums().getSize(); something++)
        {
            Medium medium=allMediums().getMedium(something);
            for(int something2 = 0; something2 < medium.getSize(); something2++)
            {
                Track track = medium.getTrack(something2);
                if(track.getTitle()== null)
                {}
                else if(track.getTitle().toLowerCase().contains(input))
                {
                    activeTracks.addTrack(track);
                    
                    System.out.println(stuffs+". "+track.getLongDescription());
                    stuffs++;
                }
            }
        }
        if(activeTracks.getSize() == 0)
        {System.out.print("No results.");}
        System.out.println("");
        return activeTracks;
    }
    
    /**
     * Searches for cd with an artist string that contains the input string
     */
    public Tracks searchByArtist()
    {
        String input =  parser.getStringidi();
        System.out.println("To edit a track type: Edit (index).");
        activeTracks=new Tracks();
        int stuffs= 0;
        for(int something = 0; something < allMediums().getSize(); something++)
        {
            Medium medium=allMediums().getMedium(something);
            for(int something2 = 0; something2 < medium.getSize(); something2++)
            {
                Track track = medium.getTrack(something2);
                
                if(track instanceof FileOnHDD)
                {
                    if (((FileOnHDD)track).getTrack() instanceof MusicTrack)
                    {
                        if(((FileOnHDD)track).getArtist() == null){}
                        else if(((FileOnHDD)track).getArtist().toLowerCase().contains(input))
                        {
                            activeTracks.addTrack(track);
                            
                            System.out.println(stuffs+". "+track.getLongDescription());
                            stuffs++;
                        }
                    }
                }
                else if(track instanceof MusicTrack)
                {
                    if(((MusicTrack)track).getArtist() == null){}
                    if(((MusicTrack)track).getArtist().toLowerCase().contains(input))
                        {
                            activeTracks.addTrack(track);
                            
                            System.out.println(stuffs+". "+track.getLongDescription());
                            stuffs++;
                        }
                }
            }
        }
        if(activeTracks.getSize() == 0)
        {System.out.print("No results.");}
        System.out.println("");
        return activeTracks;
    }
    
    /**
     * Searches for cd with an artist string that contains the input string
     */
    public Tracks listMusic()
    {
        activeTracks=new Tracks();
        int stuffs= 0;
        for(int something = 0; something < allMediums().getSize(); something++)
        {
            Medium medium=allMediums().getMedium(something);
            for(int something2 = 0; something2 < medium.getSize(); something2++)
            {
                Track track = medium.getTrack(something2);
                
                if(track instanceof FileOnHDD)
                {
                    if (((FileOnHDD)track).getTrack() instanceof MusicTrack)
                    {
                        
                            activeTracks.addTrack(track);
                            
                            System.out.println(stuffs+". "+track.getLongDescription());
                            stuffs++;
                        
                    }
                }
                else if(track instanceof MusicTrack)
                {
                    
                            activeTracks.addTrack(track);
                            
                            System.out.println(stuffs+". "+track.getLongDescription());
                            stuffs++;
                        
                }
            }
        }
        if(activeTracks.getSize() == 0)
        {System.out.print("No results.");}
        System.out.println("");
        return activeTracks;
    }
    
    /**
     * selects which track type to add
     */
    private void selectTrackType(int index)
    {
        
        int key = parser.getUserMenuSelection(4);
        switch(key)
        {
            case 1:
            clear();
            addMusicTrackParsing(index);
            break;
            case 2:
            clear();
            addAdvertisingJingleParsing(index);
            break;
            case 3:
            clear();
            addNewsParsing(index);
            break;
            case 4:
            clear();
            addSoundEffectParsing(index);
            break;
        }
        
    }
    
    /**
     * Creates a new sound effect from TUI
     */
    private void addSoundEffectParsing(int index)
    {
        clear();
        System.out.println("Type the title.");
        String title = parser.getStringidi();
        clear();
        System.out.println("Type the length in minutes");
        long minutes = parser.getUserMenuSelection(60); 
        System.out.println("Type the remaining length in seconds.");
        long seconds = parser.getUserMenuSelection(60);
        clear();
        System.out.println("Type the description.");
        String description = parser.getStringidi();
        
        Medium medium = activeMediums.getMedium(index);
        
        if(medium instanceof HDD)
        {
            clear();
            System.out.println("Type the path for the file");
            SubTrack track = register.createSoundEffect(title, minutes, seconds, description);
            String path = parser.getStringidi();
            medium.addTrack(register.createFileOnHDD(track, path));
        }
        else
        {
            medium.addTrack(register.createSoundEffect(title, minutes, seconds, description));
        }
    }
    
    /**
     * Creates a new news track from TUI
     */
    private void addNewsParsing(int index)
    {
        clear();
        System.out.println("Type the title.");
        String title = parser.getStringidi();
        clear();
        System.out.println("Type the name of the journalist.");
        String journalist = parser.getStringidi();
        clear();
        System.out.println("Type the length in minutes");
        long minutes = parser.getUserMenuSelection(60); 
        System.out.println("Type the remaining length in seconds.");
        long seconds = parser.getUserMenuSelection(60);
        clear();
        System.out.println("Type the summary.");
        String summary = parser.getStringidi();
        
        Medium medium = activeMediums.getMedium(index);
        
        if(medium instanceof HDD)
        {
            clear();
            System.out.println("Type the path for the file");
            SubTrack track = register.createNews(title, journalist, minutes, seconds, summary);
            String path = parser.getStringidi();
            medium.addTrack(register.createFileOnHDD(track, path));
        }
        else
        {
            medium.addTrack(register.createNews(title, journalist, minutes, seconds, summary));
        }
    }
    
    /**
     * Creates a new advertising jingle from TUI
     */
    private void addAdvertisingJingleParsing(int index)
    {
        clear();
        System.out.println("Type the title.");
        String title = parser.getStringidi();
        clear();
        System.out.println("Type the name of the company.");
        String company = parser.getStringidi();
        clear();
        System.out.println("Type the length in minutes");
        long minutes = parser.getUserMenuSelection(60); 
        System.out.println("Type the remaining length in seconds.");
        long seconds = parser.getUserMenuSelection(60);
        clear();
        System.out.println("Type the name of the product.");
        String product = parser.getStringidi();
        
        Medium medium = activeMediums.getMedium(index);
        
        if(medium instanceof HDD)
        {
            clear();
            System.out.println("Type the path for the file");
            SubTrack track = register.createAdvJingle(title, minutes, seconds, company, product);
            String path = parser.getStringidi();
            medium.addTrack(register.createFileOnHDD(track, path));
        }
        else
        {
            medium.addTrack(register.createAdvJingle(title, minutes, seconds, company, product));
        }
        
    }
    
    /**
     * Creates a music track from TUI
     */
    private void addMusicTrackParsing(int index)
    {
        clear();
        System.out.println("Type the song title.");
        String title = parser.getStringidi();
        clear();
        System.out.println("Type the name of the artist.");
        String artist = parser.getStringidi();
        clear();
        System.out.println("Type the length in minutes");
        long minutes = parser.getUserMenuSelection(60); 
        System.out.println("Type the remaining length in seconds.");
        long seconds = parser.getUserMenuSelection(60);
        
        Medium medium = activeMediums.getMedium(index);
        
        if(medium instanceof HDD)
        {
            clear();
            System.out.println("Type the path for the file");
            SubTrack track = register.createMusicTrack(title, artist, minutes, seconds);
            String path = parser.getStringidi();
            medium.addTrack(register.createFileOnHDD(track, path));
        }
        
        medium.addTrack(register.createMusicTrack(title, artist, minutes, seconds));
    }
    
    /**
     * Selects what type of edit menu to print and use
     */
    private void printEditMediumSelect(int index)
    {
        String menuString =
        "\n"+"---Select field to modify---" + "\n";
        Medium medium = activeMediums.getMedium(index);
        if (medium instanceof CD)
        {
            menuString = menuString
            +"1. Edit album name." + "\n"
            +"2. Edit artist name." + "\n"
            +"3. Edit year made." + "\n"
            +"4. Edit label." + "\n"
            +"5. Return to Main Menu." + "\n";
            System.out.println(menuString);
            editMediumSelectCD(index);
        }
        else if(medium instanceof Tape)
        {
            menuString = menuString
            +"1. Edit title." + "\n"
            +"2. Edit digital." + "\n"
            +"3. Return to Main Menu." + "\n";
            System.out.println(menuString);
            editMediumSelectTape(index);
        }
        else if(medium instanceof HDD)
        {
            menuString = menuString
            +"1. Edit name." + "\n"
            +"2. Return to Main Menu." + "\n";
            System.out.println(menuString);
            editMediumSelectHDD(index);
        }
        
    }
    
    /**
     * selects which field to edit
     */
    private void editMediumSelectHDD(int index)
    {
        Medium medium = activeMediums.getMedium(index);
        Mediums cds = register.getMediums(0);
        int key = parser.getUserMenuSelection(3);
        String input;
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Type a new name.");
            input = parser.getStringidi();
            ((HDD)medium).setName(input);
            break;
            case 2:
            clear();
            break;
        }
    }
    
    /**
     * selects which field to edit
     */
    private void editMediumSelectTape(int index)
    {
        Medium medium = activeMediums.getMedium(index);
        Mediums cds = register.getMediums(0);
        int key = parser.getUserMenuSelection(3);
        String input;
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Type a new title.");
            input = parser.getStringidi();
            ((Tape)medium).setTitle(input);
            break;
            case 2:
            clear();
            System.out.println("Type 1 if the tape is digital and 0 if not.");
            int digitalInt = parser.getUserMenuSelection(1);
            boolean digital = false;
            if(digitalInt == 1)
            {
                digital = true;
            }
            ((Tape)medium).setDigital(digital);
            break;
            case 3:
            clear();
            break;
        }
    }
    
    /**
     * selects which field to edit
     */
    private void editMediumSelectCD(int index)
    {
        Medium medium = activeMediums.getMedium(index);
        Mediums cds = register.getMediums(0);
        int key = parser.getUserMenuSelection(5);
        String input;
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Type a new album name.");
            input = parser.getStringidi();
            ((CD)medium).setAlbum(input);
            break;
            case 2:
            clear();
            System.out.println("Type a new artist name.");
            input = parser.getStringidi();
            ((CD)medium).setArtist(input);
            break;
            case 3:
            clear();
            System.out.println("Type a new year released.");
            int year = parser.getUserMenuSelection(3000);
            ((CD)medium).setYearReleased(year);
            break;
            
            case 4:
            clear();
            System.out.println("Type a new label.");
            input = parser.getStringidi();
            ((CD)medium).setLabel(input);
            
            break;
            
            case 5:
            clear();
            break;
        }
    }
    
    
    /**
     * Prints main menu
     */
    private void printMainMenu()
    {
        String menuString = 
        "\n"+"--- Main Menu ---" + "\n"
        +"1. Search" + "\n"
        +"2. List" + "\n"
        +"3. Add Medium" +"\n"
        +"4. Quit" + "\n";
        System.out.print(menuString);
    }
    
    /**
     * Prints a menu for adding tracks
     */
    private void printAddTrackMenu()
    {
        String menuString = "\n" + "--- Add Track ---" + "\n"
        +"1. Add Music Track" + "\n"
        +"2. Add Advertising Jingle" + "\n"
        +"3. Add News" +"\n"
        +"4. Add Sound Effect" + "\n"
        +"5. Return to Main Menu" + "\n";
        System.out.print(menuString);
    }
    
    /**
     * simulates menu for adding a medium
     */
    private void addMediumMenu()
    {
        int key = parser.getUserMenuSelection(4);
        switch(key)
        {
            case 1:
            clear();
            addCDParsing();
            break;
            case 2:
            clear();
            addTapeParsing();
            break;
            case 3:
            clear();
            addHDDParsing();
            break;
            case 4:
            clear();
            break;
        }
    }
    
    /**
     * adds a HDD from TUI
     */
    private void addHDDParsing()
    {
        clear();
        System.out.println("Type the HDD name.");
        String name = parser.getStringidi();
        clear();
        
        register.createHarddisk(name);
    }
    
    /**
     * adds a tape from TUI
     */
    private void addTapeParsing()
    {
        clear();
        System.out.println("Type the title of the tape.");
        String title = parser.getStringidi();
        clear();
        System.out.println("Type 1 to make a digital tape and 0 for analog.");
        int digitalInt = parser.getUserMenuSelection(1); 
        boolean digital = false;
        if(digitalInt == 1)
        {
            digital = true;
        }
        register.createTape(digital, title);
    }
    
    /**
     * adds a CD from TUI
     */
    private void addCDParsing()
    {
        clear();
        System.out.println("Type the album name.");
        String album = parser.getStringidi();
        clear();
        System.out.println("Type the name of the artist.");
        String artist = parser.getStringidi();
        clear();
        System.out.println("Type the year made.");
        int year = parser.getUserMenuSelection(3000); 
        clear();
        System.out.println("Type the label.");
        String label = parser.getStringidi();
        
        register.createCD(album, artist, year, label);
    }
    
    /**
     * Prints a menu for adding a medium
     */
    private void printAddMediumMenu()
    {
        String menuString = 
        "\n"+"--- Add Medium ---" + "\n"
        +"1. Add CD" + "\n"
        +"2. Add Tape" + "\n"
        +"3. Add Harddisk" +"\n"
        +"4. Return" + "\n";
        System.out.print(menuString);
        addMediumMenu();
    }
    
    /**
     * prints a search menu
     */
    private void printSearchMenu()
    {
        String menuString =
        "--- Search ---" + "\n"
        + "1. Search by archive number" + "\n"
        + "2. Search by title" + "\n"
        + "3. Search by artist" + "\n"
        + "4. Return to Main Menu" + "\n";
        System.out.print(menuString);
        
        searchChoise();
    }
    
    /**
     * simulates which search function to use
     */
    public void searchChoise()
    {
        int key = parser.getUserMenuSelection(4);
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Search archive");
            searchArchive();
            break;
            case 2:
            clear();
            System.out.println("Search Track by Title.");
            searchByTitle();
            break;
            case 3:
            clear();
            System.out.println("Search Track by Artist.");
            searchByArtist();
            break;
            case 4:
            clear();
            break;
        }
    }
    
    /**
     * choses which list to list
     */
     public void listChoise()
    {
        int key = parser.getUserMenuSelection(6);
        Mediums harddisks = register.getMediums(1);
        Mediums cds = register.getMediums(0);
        Mediums tapes = register.getMediums(2);
        switch(key)
        {
            case 1:
            clear();
            System.out.println("List of all media and tracks");
            list(allMediums());
            editOrAdd();
            break;
            case 2:
            clear();
            System.out.println("List of CDs.");
            list(cds);
            editOrAdd();
            break;
            
            case 3:
            clear();
            System.out.println("List of Tapes.");
            list(tapes);
            editOrAdd();
            break;
            case 4:
            clear();
            System.out.println("List of Harddisks.");
            list(harddisks);
            editOrAdd();
            break;
            
            case 5:
            clear();
            System.out.println("List of Music.");
            listMusic();
            editOrAdd();
            break;
            
            case 6:
            clear();
            break;

        }
    }
    
    /**
     * Selects edit or add functions for a medium
     */
    private void editOrAdd()
    {
        int maxSize = activeMediums.getSize();
        String stringy = parser.getStringidi();
        stringy = stringy.toLowerCase();
        if(stringy.contains("edit") || stringy.contains("add") || stringy.contains("open"))
        {
            clear();
            list(activeMediums);
            System.out.println("\n"+"Select a medium by typing its index number.");
            int index = parser.getUserMenuSelection(maxSize);
            if(stringy.contains("edit"))
            {
                clear();
                printEditMediumSelect(index);
            }
            
            else if(stringy.contains("add"))
            {
                clear();
                printAddTrackMenu();
                selectTrackType(index);
            }
            else if(stringy.contains("open"))
            {
                clear();
                printTrackSelect(index);
            }
        }
        
        clear();

    }
    
    /**
     * checks if a track is a file
     */
    private void checkIfFile(Track track)
    {
        if(track instanceof FileOnHDD)
        {
            track = ((FileOnHDD)track).getTrack();
        }
        printEditTrack(track);
    }
    
    /**
     * prints an edit track menu depending on type
     */
    private void printEditTrack(Track track)
    {
        String resultString = "Select a field to edit" + "\n";
        if(track instanceof MusicTrack)
        {
            resultString = resultString 
            + "1. Edit title." + "\n"
            + "2. Edit artist." + "\n"
            + "3. Edit duration." + "\n"
            + "4. Play Track." + "\n"
            + "5. Return to Main Menu." + "\n";
            System.out.print(resultString);
            editMusicTrack(track);
        }
        else if(track instanceof AdvertisingJingle)
        {
            resultString = resultString 
            + "1. Edit title." + "\n"
            + "2. Edit company." + "\n"
            + "3. Edit duration." + "\n"
            + "4. Edit product." + "\n"
            + "5. Return to Main Menu." + "\n";
            System.out.print(resultString);
            editAdvertisingJingle(track);
        }
        else if(track instanceof News)
        {
            resultString = resultString 
            + "1. Edit title." + "\n"
            + "2. Edit summary." + "\n"
            + "3. Edit duration." + "\n"
            + "4. Broadcast" + "\n"
            + "5. Return to Main Menu." + "\n";
            System.out.print(resultString);
            editNews(track);
        }
        else if(track instanceof SoundEffect)
        {
            resultString = resultString 
            + "1. Edit title." + "\n"
            + "2. Edit description." + "\n"
            + "3. Edit duration." + "\n"
            + "4. Return to Main Menu." + "\n";
            System.out.print(resultString);
            editSoundEffect(track);
        }
        
    }
    
    /**
     * edits a sound effect from TUI
     */
    private void editSoundEffect(Track track)
    {
        int key = parser.getUserMenuSelection(4);
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Type a new title.");
            String title = parser.getStringidi();
            ((SubTrack)track).setTitle(title);
            break;
            case 2:
            clear();
            System.out.println("Type a new summary.");
            String description = parser.getStringidi();
            ((SoundEffect)track).setDescription(description);
            break;
            
            case 3:
            clear();
            System.out.println("Type a new duration in minutes.");
            long min = parser.getUserMenuSelection(60);
            clear();
            System.out.println("Type a new duration in seconds.");
            long sec = parser.getUserMenuSelection(60);
            ((SubTrack)track).setDuration(min, sec);
            break;
            
            case 4:
            clear();
            break;
            
        }
    }
    
    /**
     * edits a news track from TUI
     */
    private void editNews(Track track)
    {
        int key = parser.getUserMenuSelection(5);
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Type a new title.");
            String title = parser.getStringidi();
            ((SubTrack)track).setTitle(title);
            break;
            case 2:
            clear();
            System.out.println("Type a new summary.");
            String company = parser.getStringidi();
            ((News)track).setSummary(company);
            break;
            
            case 3:
            clear();
            System.out.println("Type a new duration in minutes.");
            long min = parser.getUserMenuSelection(60);
            clear();
            System.out.println("Type a new duration in seconds.");
            long sec = parser.getUserMenuSelection(60);
            ((SubTrack)track).setDuration(min, sec);
            break;
            
            case 4:
            clear();
            ((News)track).broadcast();
            break;
            
            case 5:
            clear();
            break;
        }
    }
    
    /**
     * edits an advertising jingle from TUI
     */
    private void editAdvertisingJingle(Track track)
    {
        int key = parser.getUserMenuSelection(5);
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Type a new title.");
            String title = parser.getStringidi();
            ((SubTrack)track).setTitle(title);
            break;
            case 2:
            clear();
            System.out.println("Type a new company name.");
            String company = parser.getStringidi();
            ((AdvertisingJingle)track).setCompany(company);
            break;
            
            case 3:
            clear();
            System.out.println("Type a new duration in minutes.");
            long min = parser.getUserMenuSelection(60);
            clear();
            System.out.println("Type a new duration in seconds.");
            long sec = parser.getUserMenuSelection(60);
            ((SubTrack)track).setDuration(min, sec);
            break;
            
            case 4:
            clear();
            System.out.println("Type a new product name.");
            String product = parser.getStringidi();
            ((AdvertisingJingle)track).setProduct(product);
            break;
            
            case 5:
            clear();
            break;
        }
    }
    
    /**
     * edits a music track from TUI
     */
    private void editMusicTrack(Track track)
    {
        int key = parser.getUserMenuSelection(5);
        switch(key)
        {
            case 1:
            clear();
            System.out.println("Type a new title.");
            String title = parser.getStringidi();
            ((SubTrack)track).setTitle(title);
            break;
            case 2:
            clear();
            System.out.println("Type a new artist name.");
            String artist = parser.getStringidi();
            ((MusicTrack)track).setArtist(artist);
            break;
            
            case 3:
            clear();
            System.out.println("Type a new duration in minutes.");
            long min = parser.getUserMenuSelection(60);
            clear();
            System.out.println("Type a new duration in seconds.");
            long sec = parser.getUserMenuSelection(60);
            ((SubTrack)track).setDuration(min, sec);
            break;
            case 4:
            clear();
            ((MusicTrack)track).play();
            break;
            
            case 5:
            clear();
            break;
        }
    }
    
    /**
     * selects which track to edit
     */
    private void trackSelect(Medium medium)
    {
        
        boolean done = false;
        int selected = parser.getUserMenuSelection(999);
        if(selected < medium.getSize())
        {
            clear();
            Track track;
            track = medium.getTrack(selected);
            System.out.println("Select which variable to edit."+ "\n");
            checkIfFile(track);
        }
        else
        {
            System.out.print("Your input was not valid");
        }
    
    }
    
    /**
     * prints instructions for track selection
     */
    private void printTrackSelect(int index)
    {
        String resultString = 
        "To edit a track type its index number" + "\n";
        Medium medium = activeMediums.getMedium(index);
        resultString = resultString + medium.getTracksDescriptionWIndex();
        System.out.print(resultString);
        trackSelect(medium);
    }
    
    /**
     * tells us how to use edit, add and open
     */
    public String tellUsWhatToDo()
    {
        String resultString = "To edit an item type: Edit" + "\n"
        +"To add a track type: Add" + "\n"
        +"To open a medium type: Open" + "\n"
        +"Anything else will return you to Main Menu" + "\n";
        return resultString;
    }
    
    /**
     * lists mediums and tracks from selected Mediums
     */
    public void list(Mediums mediums)
    {
        
        String topThingie = "We found " + mediums.getSize() + " medium(s)." + "\n";
        
        
        String mainString = mediums.getMediumPrintString();
        System.out.print(topThingie);
        System.out.print(mainString);
        activeMediums = mediums;
        System.out.println("\n"+tellUsWhatToDo());
    }
    
    /**
     * prints listing options
     */
    private void printListMenu()
    {
        String returnString =
        "--- List Menu ---" + "\n"
        + "1. List All" + "\n"
        + "2. List CDs" + "\n"
        + "3. List Tapes" + "\n"
        + "4. List HDDs" + "\n"
        + "5. List Music" + "\n"
        + "6. Return to Main Menu" + "\n";
        System.out.print(returnString);
        listChoise();
    }
    
    /**
     * removes text from window
     */
    public final static void clear()
    {
        System.out.print('\u000C');
    }
    
    /**
     * Removes a medium
     */
    public void removeMedium(Medium medium)
    {
        register.removeMedium(medium);
    }
}
