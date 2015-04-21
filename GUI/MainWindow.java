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
    
    private static String [] colornames = {"black" , "yello" , "Dole" , "Ole" , "Doffen" ,"Freeeedrik"};
    
    private JList list;
    
    private String labelText;           
    
    private JFrame frame;
    private JScrollPane listScroller;
    private JPanel textPane, mediumPane;
    
  
    public static void main(String[] args)
    {
        MainWindow myApp = new MainWindow();
    }

    public MainWindow()
    {
        super("Gloppen NærRadio");
        //listScroller = new JPanel();
        textPane = new JPanel();
        mediumPane = new JPanel();
        makeFrame();
        makeMenuBar();
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
                    JButton button =(JButton) event.getSource();
                    if (button == aCDButton)
                    {
                        frame.remove(listScroller);
                        frame.remove(mediumPane);
                        frame.remove(textPane);
                        
                        addNewCD();
                        makeFrame();
                    }
                        
           
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
                     makeTextField();
                    
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
            
            JButton backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                  
                   
                }
            });
            toolBar.add(backButton);
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
        /*makeTextField();
        makeMenuBar();
        makeList();
        */

        this.pack();
        this.setVisible(true);

    }
    /**
     * Content pane to list mediums
     */
    /*private void makeList()
    {
       
     JPanel contentPane = (JPanel) this.getContentPane();
       
       list = new JList(colornames);
       list.setLayout(new BoxLayout(list, BoxLayout.X_AXIS));
       list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       add(new JScrollPane(list));
       this.setVisible(true);
       
       
        contentPane.add( list, BorderLayout.EAST);
    }*/
    
    
    private void makeList()
    {   
         list = new JList(colornames); 
         
        
        
        
        
        listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(RIGHT_ALIGNMENT);
        
        
        
        
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel(labelText);
        label.setLabelFor(list);
        listPane.add(label);
        listPane.add(Box.createRigidArea(new Dimension(0,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        Container contentPane = (JPanel) this.getContentPane();
        contentPane.add(listPane, BorderLayout.EAST);
    }
    
    private void makeMediumPane()
    {
        
        JPanel contentPane = (JPanel) this.getContentPane();
        mediumPane = new JPanel();
        {
            
            mediumPane.setLayout(new FlowLayout());
             
            mediumPane.add( new JButton("CD"));
            mediumPane.add( new JButton("TAPE"));
            mediumPane.add( new JButton("HDD"));
            
        }
        contentPane.add( mediumPane, BorderLayout.NORTH);
    }
    
    private void makeTextField()
    {
       JPanel contentPane = (JPanel) this.getContentPane();
        textPane = new JPanel();
        {
            textPane.setLayout(new GridLayout(6,2));
            
            
            textPane.add(new JLabel("Title:")); 
            textPane.add(new JLabel(""));
            textField = new JTextField("");
            textPane.add(textField);
            textPane.add(new JLabel(""));
            textPane.add(new JLabel("Artist:"));
            textPane.add(new JLabel(""));
            textPane.add(new JTextField(""));
            textPane.add(new JLabel(""));
            textPane.add(new JLabel("Duration:"));
            textPane.add(new JLabel(""));
            textPane.add(new JTextField(""));
                 


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
            textPane.setLayout(new GridLayout(3,2));
            
            textPane.add(new JLabel(""));
            textPane.add(new JLabel(""));
            textPane.add(new JLabel("CD name"));
            textPane.add(new JLabel(""));
            textField = new JTextField("");
            textPane.add(textField);

            
        }  
        contentPane.add( textPane, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
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

