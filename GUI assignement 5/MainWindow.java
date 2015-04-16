import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

/**
 * Write a description of class MainWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWindow extends JFrame 
{
    private JTextField textField;
    private JLabel statusText;
    private JTextField display;
    
    public static void main(String[] args)
    {
        MainWindow myApp = new MainWindow();
    }

    public MainWindow()
    {
        super("Gloppen NærRadio");
        makeFrame();
        
    }

	
    private void makeFrame()
    {
       
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.BLUE);
        contentPane.setLayout(new BorderLayout());

        JPanel toolBar = new JPanel();
        {
            toolBar.setBackground(Color.RED);
            toolBar.setLayout(new GridLayout(4,2));
             
            JButton aCDButton = new JButton("Add CD");
            aCDButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(aCDButton);
            
            JButton rCDButton = new JButton("Remove CD");
            rCDButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(rCDButton);
            
            JButton aTapeButton = new JButton("Add Tape");
            aTapeButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(aTapeButton);
            
            JButton rTapeButton = new JButton("Remove Tape");
            rTapeButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(rTapeButton);
            
            JButton aTrackButton = new JButton("Add Track");
            aTrackButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(aTrackButton);
            
            JButton rTrackButton = new JButton("Remove Track");
            rTrackButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(rTrackButton);
            
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(okButton);
        }
        
        JPanel textPane = new JPanel();
        {
            
             textPane.setLayout(new FlowLayout());
             
            textPane.add( new JButton("CD"));
            textPane.add( new JButton("TAPE"));
            textPane.add( new JButton("HDD"));
            
        }
        
        /*JPanel textPane1 = new JPanel();
        {
            textPane1.setLayout(new GridLayout(2,2));
            
            textPane1.add(new JLabel("Title:"));
            
            textField = new JTextField("");
            textPane1.add(textField);
            textPane1.add(new JLabel("Artist:"));
            textPane1.add(new JTextField(""));
            
        }*/
        
        JPanel statusBar = new JPanel();
        {
            statusText = new JLabel("Version Awsome");
            
            statusBar.add( statusText );
        }
 
        JPanel flowPanel = new JPanel();
        flowPanel.add(toolBar);
        contentPane.add( flowPanel, BorderLayout.WEST);
        contentPane.add( textPane, BorderLayout.CENTER);
        //contentPane.add( textPane1, BorderLayout.CENTER);
        contentPane.add( statusBar, BorderLayout.SOUTH );
        

        this.pack();
        this.setVisible(true);

    }
    
    

}
