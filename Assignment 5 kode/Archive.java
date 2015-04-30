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
    private Mediums allMediums;
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
        allMediums = register.combineAllMediums();
        parser = new Parser();
        play();
    }
    
    public void play()
    {
        System.out.print("Hi folks, let's push some buttons" + "\n");
        printMainMenu();
        boolean finished = false;
        while (!finished)
        {
            finished = selectMenu();
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::");
    }
    
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
            printAddMediumMenu();
            clear();
            
            break;
            
            case 4:
            clear();
            return true;
        }
        return wantToQuit;
    }
    
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
        for(int something = 0; something < allMediums.getSize(); something++)
        {
            Medium medium=allMediums.getMedium(something);
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
        for(int something = 0; something < allMediums.getSize(); something++)
        {
            Medium medium=allMediums.getMedium(something);
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
        for(int something = 0; something < allMediums.getSize(); something++)
        {
            Medium medium=allMediums.getMedium(something);
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
    
    private void selectTrackType(int index)
    {
        
        int key = parser.getUserMenuSelection(5);
        switch(key)
        {
            case 1:
            clear();
            addMusicTrackParsing(index);
            break;
            case 2:
            clear();
            //addAdvertisingJingleParsing(index);
            break;
            case 3:
            clear();
            //addNewsParsing(index);
            break;
            case 4:
            clear();
            //addSoundEffectParsing(index);
            break;
        }
        
    }
    
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
        medium.addTrack(register.createMusicTrack(title, artist, minutes, seconds));
        
        //cd.addTrack(createMusicTrack("Remnants", "Disturbed", 2, 43));
    }
    
    private void editMediumSelect(int index)
    {
        
    }
    
    private void addMedium()
    {
        
    }
    
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
    
    private void printAddMediumMenu()
    {
        String menuString = 
        "\n"+"--- Main Menu ---" + "\n"
        +"1. Add CD" + "\n"
        +"2. Add Tape" + "\n"
        +"3. Add Harddisk" +"\n"
        +"4. Return" + "\n";
        System.out.print(menuString);
    }
    
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
            System.out.println(tellUsWhatToDo() + "List of all media and tracks");
            list(allMediums);
            editOrAdd();
            break;
            case 2:
            clear();
            System.out.println(tellUsWhatToDo()+"List of CDs.");
            list(cds);
            editOrAdd();
            break;
            
            case 3:
            clear();
            System.out.println(tellUsWhatToDo()+"List of Tapes.");
            list(tapes);
            editOrAdd();
            break;
            case 4:
            clear();
            System.out.println(tellUsWhatToDo()+"List of Harddisks.");
            list(harddisks);
            editOrAdd();
            break;
            
            case 5:
            clear();
            System.out.println(tellUsWhatToDo()+"List of Music.");
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
        if(stringy.contains("edit") || stringy.contains("add"))
        {
            clear();
            list(activeMediums);
            System.out.println("\n"+"Select a medium by typing its index number.");
            int index = parser.getUserMenuSelection(maxSize);
            if(stringy.contains("edit"))
            {
                clear();
                editMediumSelect(index);
            }
            
            else if(stringy.contains("add"))
            {
                clear();
                printAddTrackMenu();
                selectTrackType(index);
            }
        }
        clear();

    }
    
    public String tellUsWhatToDo()
    {
        String resultString = "To edit an item type: Edit" + "\n"
        +"To add a track type: Add" + "\n"
        +"Anything else will return you to Main Menu" + "\n";
        return resultString;
    }
    
    public void list(Mediums mediums)
    {
        
        String topThingie = "We found " + mediums.getSize() + " mediums." + "\n";
        
        
        String mainString = mediums.getMediumPrintString();
        System.out.print(topThingie);
        System.out.print(mainString);
        activeMediums = mediums;
        
    }
    
    
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
