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
    public Tracks searchByTitle(String input)
    {
        activeTracks=new Tracks();
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
                    System.out.println(something2+". "+track.getLongDescription());
                }
            }
        }
        
        return activeTracks;
    }
    
        /**
     * Searches for cd with an artist string that contains the input string
     */
    public Tracks searchByArtist(String input)
    {
        activeTracks=new Tracks();
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
                            System.out.print(something2+". "+track.getLongDescription());
                        }
                    }
                }
                else if(track instanceof MusicTrack)
                {
                    if(((MusicTrack)track).getArtist() == null){}
                    if(((MusicTrack)track).getArtist().toLowerCase().contains(input))
                        {
                            activeTracks.addTrack(track);
                            System.out.print(something2+". "+track.getLongDescription());
                        }
                }
            }
        }
        
        return activeTracks;
    }
    
    private void printMainMenu()
    {
        String menuString = 
        "\n"+"--- Main Menu ---" + "\n"
        +"1. Search" + "\n"
        +"2. list" + "\n"
        +"3. medium" +"\n"
        +"4. quit" + "\n";
        System.out.print(menuString);
    }
    
    private void printSearchMenu()
    {
        String menuString =
        "--- Search ---" + "\n"
        + "1. Search by archive number" + "\n"
        + "2. Search by title" + "\n"
        + "3. Search by artist" + "\n";
        System.out.print(menuString);
        
        searchChoise();
    }
    
    public void searchChoise()
    {
        int key = parser.getUserMenuSelection(3);
        switch(key)
        {
            case 1:
            clear();
            searchArchive();
            break;
            case 2:
            break;
        }
    }
    
    public void printList()
    {
        String topThingie = "We found " + allMediums.getSize() + " mediums." + "\n"
        +"To edit an item type : Edit (index)" + "\n";
        String mainString = allMediums.getMediumPrintString();
        System.out.print(topThingie);
        System.out.print(mainString);
    }
    
    
    private void printListMenu()
    {
        String returnString =
        "--- List Menu ---" + "\n"
        + "1. List All" + "\n"
        + "2. List CDs" + "\n"
        + "3. List Tapes" + "\n"
        + "4. List HDDs" + "\n"
        + "5. List Music" + "\n";
        System.out.print(returnString);
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
