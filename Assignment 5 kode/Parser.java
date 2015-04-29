import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Parser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parser
{

    private Scanner reader = new Scanner(System.in);
    /**
     * Constructor for objects of class Parser
     */
    public Parser()
    {

    }

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
    
    public int getUserMenuSelection(int max) 
    {
        boolean validInput = false;
        int selection = 0;

        while (!validInput) {
            try {
                selection = reader.nextInt();
                if ((selection <= max) && (selection > 0)) {
                    validInput = true;
                } else
                {
                    System.out.print("You must provide a number between 1 and " 
                        + max + "\n>");
                }
            } catch (InputMismatchException ime) {
                System.out.print("Your input must be an integer (a positiv number)\n>");
                // Empty the Scanner
                reader.next();
            }
        }
        return selection;
    }
}
