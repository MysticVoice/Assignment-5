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
     private static final String VERSION = "Version 1.0";
    private JTextField textField;
    private JLabel statusText;
    
    private static String [] colornames = {"black" , "yello"};
    private static Color[] colors = {Color.BLACK, Color.YELLOW};
    private JList list;
   
    private JFrame frame;
    
  
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
       
        contentPane.setLayout(new BorderLayout());

        JPanel toolBar = new JPanel();
        {
            
            toolBar.setLayout(new GridLayout(4,2));
             
            JButton aCDButton = new JButton("Add CD");
            aCDButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                    makeFrame();
                    addNewCD();
                   
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
               
        JPanel statusBar = new JPanel();
        {
            statusText = new JLabel("Version Awsome");
            
            statusBar.add( statusText );
        }
 
        JPanel flowPanel = new JPanel();
        flowPanel.add(toolBar);
        contentPane.add( flowPanel, BorderLayout.WEST);
        
        
        contentPane.add( statusBar, BorderLayout.SOUTH );
        
        makeMediumPane();
        makeTextField();
        makeMenuBar();
        makeList();
        

        this.pack();
        this.setVisible(true);

    }
    /**
     * Content pane to list mediums
     */
    private void makeList()
    {
     JPanel contentPane = (JPanel) this.getContentPane();
       
       list = new JList(colors);
       list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       add(new JScrollPane(list));
       this.setVisible(true);
       
       
        contentPane.add( list, BorderLayout.EAST);
    }
    
    private void makeMediumPane()
    {
        
        JPanel contentPane = (JPanel) this.getContentPane();
        JPanel mediumPane = new JPanel();
        {
            
            mediumPane.setLayout(new FlowLayout());
             
            mediumPane.add( new JButton("CD"));
            mediumPane.add( new JButton("TAPE"));
            mediumPane.add( new JButton("HDD"));
            
        }
        contentPane.add( mediumPane, BorderLayout.EAST);
    }
    
    private void makeTextField()
    {
       JPanel contentPane = (JPanel) this.getContentPane();
       JPanel textPane = new JPanel();
        {
            textPane.setLayout(new BoxLayout(textPane, BoxLayout.Y_AXIS));
            
            
            textPane.add(new JLabel("Title:"));            
            textField = new JTextField("", 8);
            textPane.add(textField);
            textPane.add(new JLabel("Artist:"));
            textPane.add(new JTextField("", 1));
            textPane.add(new JLabel("Duration:"));
            textPane.add(new JTextField("", 8));
                 


        }  
        contentPane.add( textPane, BorderLayout.CENTER);
                           
    }
    
     private void makeMenuBar()
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        
        JMenuBar menuBar = new JMenuBar();        
        this.setJMenuBar(menuBar);
            
        JMenu menu;
        JMenuItem item;
        
                
        menu = new JMenu("File");        
        menuBar.add(menu);
        
        item = new JMenuItem("Open...");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));       
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) 
                               {
                                   
                               }
                           });
        menu.add(item);
        
        item = new JMenuItem("Quit");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) 
                               { 
                                   quit();                                
                               }
                           });
        menu.add(item);
            
            
       menu = new JMenu("Help");
        menuBar.add(menu);
        
        item = new JMenuItem("About...");
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { showAbout(); }
                           });
        menu.add(item);
            
        
        
          
        
          
            
        }
        
        
        
    
    
    private void addNewCD()
    {
       JPanel contentPane = (JPanel) this.getContentPane();
       JPanel textPane = new JPanel();
        {
            textPane.setLayout(new GridLayout(3,1));
            
            textPane.add(new JLabel("CD name"));            
            textField = new JTextField("");
            textPane.add(textField);
            
            

            
        }  
        contentPane.add( textPane, BorderLayout.CENTER);
        
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
     private void showAbout()
    {
        JOptionPane.showMessageDialog(frame, 
                    "Globben NærRadio\n" + VERSION,
                    "About Globben NærRadio", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    

}

