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

    /**
     * Constructor for objects of class Archive
     */
    public Archive()
    {
        register = new Register();
    }
    
    private Mediums getCDList(){
        Mediums list = register.getMediumsList().get(0);
        return list;
    }
    
    public void searchCDsByArtist(String input)
    {
        ArrayList<Medium> unSearched = getCDList().getMediums();
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
}
