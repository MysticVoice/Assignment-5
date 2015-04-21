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
    
    
    private JButton aCDButton, rCDButton, aTapeButton, rTapeButton, aTrackButton, rTrackButton, okButton, backButton;
    
    private JFrame frame;
    private JScrollPane listScroller;
<<<<<<< Updated upstream
    private JPanel textPane, mediumPane, toolBar;
    
=======
    private JPanel textPane1, textPane2,  mediumPane, listPane;
    private JButton aCDButton;
>>>>>>> Stashed changes
  
    public static void main(String[] args)
    {
        MainWindow myApp = new MainWindow();
        
    }

    public MainWindow()
    {
        super("Gloppen NærRadio");
<<<<<<< Updated upstream
       
        
        makeFrame();
        
        //textPane = new JPanel;
        /*aCDButton = new JButton();
        rCDButton = new JButton();
        aTapeButton = new JButton();
        rTapeButton = new JButton();
        aTrackButton = new JButton();
        rTrackButton = new JButton();
        okButton = new JButton();
        backButton = new JButton();*/
        
        
        listScroller = new JScrollPane();
        
        
        textPane = new JPanel();
=======
        //listScroller = new JPanel();
        textPane1 = new JPanel();
        textPane2 = new JPanel();
>>>>>>> Stashed changes
        mediumPane = new JPanel();
       
        makeMenuBar();
    }

    
    private void makeFrame()
    {
       
        JPanel contentPane = (JPanel) this.getContentPane();
       
        contentPane.setLayout(new BorderLayout());

        toolBar = new JPanel();
        {
            
            toolBar.setLayout(new GridLayout(4,2));
             
            aCDButton = new JButton("Add CD");
            aCDButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {   
                   JButton button =(JButton) event.getSource();
                    if (button == aCDButton)
<<<<<<< Updated upstream
                    {
                        contentPane.remove(textPane);
                                                            
                                            
                       
                        addNewCD();
                        
                          
                        
                       
                        
                    }
                        
                        
                    
                }});
=======
                   {
                        //contentPane.remove(listPane);
                        contentPane.remove(mediumPane);
                        contentPane.remove(textPane1);
                        run();
                      
                       
                        
                   }
                        
                    
                }
>>>>>>> Stashed changes


            }); 
             
            toolBar.add(aCDButton);
            
             rCDButton = new JButton("Remove CD");
            rCDButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                
                }
             });
            toolBar.add(rCDButton);
            
             aTapeButton = new JButton("Add Tape");
            aTapeButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(aTapeButton);
            
             rTapeButton = new JButton("Remove Tape");
            rTapeButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(rTapeButton);
            
             aTrackButton = new JButton("Add Track");
            aTrackButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                     makeTextField();
                    
                }
            });
            toolBar.add(aTrackButton);
            
             rTrackButton = new JButton("Remove Track");
            rTrackButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                 
                }
            });
            toolBar.add(rTrackButton);
            
             okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event) 
                {
                   
                }
            });
            toolBar.add(okButton);
            
             backButton = new JButton("Back");
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
        makeTextField();
        makeMenuBar();
        makeList();
        

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
        textPane1 = new JPanel();
        {
            textPane1.setLayout(new GridLayout(6,1));
            
            
            textPane1.add(new JLabel("Title:")); 
            textPane1.add(new JTextField(""));
            textPane1.add(new JLabel("Artist:"));
            textPane1.add(new JTextField(""));
            textPane1.add(new JLabel("Duration:"));
            textPane1.add(new JTextField(""));

        
            
                 


        }  
        contentPane.add( textPane1, BorderLayout.CENTER);
                           
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
      /* JPanel contentPane = (JPanel) this.getContentPane();
        
       JPanel textPane2 = new JPanel();
        {
<<<<<<< HEAD
            textPane.setLayout(new GridLayout(3,2));
            
            textPane.add(new JLabel("Title:"));
            
            textField = new JTextField("");
            textPane.add(textField);
=======
            textPane2.setLayout(new GridLayout(2,1));
            textPane2.add(new JLabel("CD name"));
            textPane2.add(new JTextField(""));
           
>>>>>>> c9de154d78b81715cea3d6d612236fc80c37684e

            
        }  
        contentPane.add( textPane2, BorderLayout.CENTER);
    */
    }
    
      private void run()
      {
        JPanel frame = new JPanel();
                            
        javax.swing.JLabel jLabel1;
        javax.swing.JTextField jTextField1;
        this.pack();
        this.setVisible(true);

    // End of variables declaration    
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
                    "Gloppen NærRadio\n" + VERSION,
                    "About Gloppen NærRadio", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
 

}

