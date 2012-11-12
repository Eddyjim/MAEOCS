package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * 
 * @author Eddyjim
 *	This class is the main menu of the interface for the application
 */
@SuppressWarnings("serial")
public class GeneralMenuBar extends JFrame{
	
	private JMenuBar menuBar;
	
	private MapWindow selected;
	
	Dimension principalDim = new Dimension (800,50);
	Dimension createDim = new Dimension (250,200);
	Dimension propertiesDim = new Dimension (250,250);
	Dimension toolsDim = new Dimension (800,150);
	Dimension simulatorDim = new Dimension(250, 670);
	Dimension mapDim;
	
	/**
	 * Standard creator for the General Menu Bar
	 */
	public GeneralMenuBar(){
		
		this.setSize(principalDim);
		this.setLocation(10, 10);
		this.setBackground(Theme.background);
		this.setForeground(Theme.foreground);
		this.setMaximumSize(principalDim);
		this.setMinimumSize(principalDim);
		this.setResizable(false);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    menuBar = new JMenuBar();
	    
	    menuBar.setBackground(Theme.background);
	    menuBar.repaint();
	    
	    // Add the menubar to the frame
	    setJMenuBar(menuBar);
	    
	    // Define and add two drop down menu to the menubar
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setForeground(Theme.foreground);
	    fileMenu.setBackground(Theme.background);
	    
	    JMenu editMenu = new JMenu("Edit");
	    editMenu.setForeground(Theme.foreground);
	    editMenu.setBackground(Theme.background);
	    
	    JMenu createMenu = new JMenu("Create");
	    editMenu.setForeground(Theme.foreground);
	    editMenu.setBackground(Theme.background);
	    
	    JMenu viewMenu = new JMenu("View");
	    editMenu.setForeground(Theme.foreground);
	    editMenu.setBackground(Theme.background);
	    
	    menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(createMenu);
        menuBar.add(viewMenu);
        
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        newAction.setForeground(MaeocsMappingApplication.black);
        newAction.setBackground(MaeocsMappingApplication.white);
        
//        JMenuItem openAction = new JMenuItem("OpenImage");
//        openAction.setForeground(MaeocsMappingApplication.black);
//        openAction.setBackground(MaeocsMappingApplication.white);
        
        JMenuItem exitAction = new JMenuItem("Exit");
        exitAction.setForeground(Theme.foreground);
        exitAction.setBackground(Theme.background);
        
        JMenuItem cutAction = new JMenuItem("Cut");
        cutAction.setForeground(Theme.foreground);
        cutAction.setBackground(Theme.background);
        
        JMenuItem copyAction = new JMenuItem("Copy");
        copyAction.setForeground(Theme.foreground);
        copyAction.setBackground(Theme.background);
        
        JMenuItem pasteAction = new JMenuItem("Paste");
        pasteAction.setForeground(Theme.foreground);
        pasteAction.setBackground(Theme.background);
        
        //add the items to the menu item
        
        fileMenu.add(newAction);
//        fileMenu.add(openAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        
       
        newAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				selected = new MapWindow();
				selected.setDimensionWindow(new DimensionsWindow(selected));
			
			}
		});
        
        menuBar.updateUI();        
        
	}
}
