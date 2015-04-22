import java.util.ArrayList;
/**
 * Write a description of class Archive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Archive
{
    private Register register;
    private Medium activeMedium;

    /**
     * Constructor for objects of class Archive
     */
    public Archive()
    {
        register = new Register();
        activeMedium = getCDList().get(0);
        String something = ((CD)activeMedium).getArtist();
        System.out.println(something);
    }
    
    /**
     * Gets an arraylist of cds
     */
    private ArrayList<Medium> getCDList(){
        Mediums list = register.getMediumsList().get(0);
        ArrayList<Medium> returnList = list.getMediums();
        return returnList;
    }
    
    /**
     * Gets an arraylist of tapes
     */
    private ArrayList<Medium> getTapeList(){
        Mediums list = register.getMediumsList().get(2);
        ArrayList<Medium> returnList = list.getMediums();
        return returnList;
    }
    
    /**
     * Gets an arraylist of harddisks
     */
    private ArrayList<Medium> getHarddiskList(){
        Mediums list = register.getMediumsList().get(1);
        ArrayList<Medium> returnList = list.getMediums();
        return returnList;
    }
    
    public void removeActiveMedium()
    {
        removeMedium(activeMedium);
    }
    
    /**
     * Searches for cd with an artist string that contains the input string
     */
    public void searchCDsByArtist(String input)
    {
        ArrayList<Medium> unSearched = getCDList();
        Mediums mediums = new Mediums();
        for (int i = 0; i<unSearched.size(); i++)
        {
            Medium medium = unSearched.get(i);
            String inputLowrCase = input.toLowerCase();
            String cdArtist = ((CD)medium).getArtist().toLowerCase();
            if(cdArtist.contains(inputLowrCase))
            {
                mediums.addMedium(medium);
                System.out.print(((CD)medium).printString());
                System.out.println();
            }
        }
    }
    
    /**
     * Removes the active medium
     */
    public void removeMedium(Medium medium)
    {
        register.removeMedium(medium);
    }
}
