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

    /**
     * Constructor for objects of class Archive
     */
    public Archive()
    {
        register = new Register();
        //activeMedium = getCDList().get(0);
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
    
    public Medium searchArchive(String input)
    {
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
        return medium;
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
    
//         /**
//      * Searches for cd with an artist string that contains the input string
//      */
//     public Medium searchByTitle(String input,ArchiveList list)
//     {
//         Medium medium=null;
//         Mediums listMediums = list.getMediums();
//         scan = new Scanner(input);
//         if(scan.hasNext())
//         {
//             

//             int listValue = list.getSpecific()+1;
//             if (arcNr >= listValue)
//             {
//                 int index = arcNr - listValue;
//                 if(index <= listMediums.getSize())
//                 {
//                     medium = listMediums.getMedium(index);
//                 }
//             }
//         }
//         return medium;
//     }
    
    public String getStringidi() 

    { BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userName = null;

        //  read the username from the command-line; need to use try/catch with the
        //  readLine() method
        try {
            userName = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your text!");
            System.exit(1);
        }
        return userName;
    }
    
    /**
     * Removes a medium
     */
    public void removeMedium(Medium medium)
    {
        register.removeMedium(medium);
    }
}
