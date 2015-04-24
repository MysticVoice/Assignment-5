import java.util.ArrayList;
/**
 * All UI functionality will be collected here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Archive
{
    private Register register;
    private Track activeTrack;

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
    
//     /**
//      * Searches for cd with an artist string that contains the input string
//      */
//     public void searchCDsByArtist(String input)
//     {
//         ArrayList<Medium> unSearched = getCDList();
//         Mediums mediums = new Mediums();
//         for (int i = 0; i<unSearched.size(); i++)
//         {
//             Medium medium = unSearched.get(i);
//             String inputLowrCase = input.toLowerCase();
//             String cdArtist = ((CD)medium).getArtist().toLowerCase();
//             if(cdArtist.contains(inputLowrCase))
//             {
//                 mediums.addMedium(medium);
//                 System.out.print(((CD)medium).printString());
//                 System.out.println();
//             }
//         }
//     }
    
    /**
     * Removes a medium
     */
    public void removeMedium(Medium medium)
    {
        register.removeMedium(medium);
    }
}
