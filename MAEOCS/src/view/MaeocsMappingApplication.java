package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * 
 * @author Eddyjim
 *	This class is the main menu of the interface for the application
 */
@SuppressWarnings("serial")
public class MaeocsMappingApplication extends JFrame{
	
	private MaeocsMappingApplication parent = this;
	private JMenuBar menuBar;
	private ToolsGraphicsPanel tools;
	private MapWindow selected;
	private AtributesPanel atributes;
	private State selectedState;
	
	
	Dimension principalDim = new Dimension (800,50);
	Dimension createDim = new Dimension (250,200);
	Dimension propertiesDim = new Dimension (250,250);
	Dimension toolsDim = new Dimension (800,150);
	Dimension simulatorDim = new Dimension(250, 670);
	Dimension mapDim;
	
	/**
	 * Standard creator for the General Menu Bar
	 */
	public MaeocsMappingApplication(){
		
		this.setSize(principalDim);
		this.setLocation(Theme.menuBarLocation);
		this.setBackground(Theme.background);
		this.setForeground(Theme.foreground);
		this.setMaximumSize(principalDim);
		this.setMinimumSize(principalDim);
		this.setResizable(false);
		this.setVisible(true);
		selectedState = new State();
		
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
        final JMenuItem newAction = new JMenuItem("New");
        newAction.setForeground(Theme.foreground);
        newAction.setBackground(Theme.background);

        final JMenuItem editAction = new JMenuItem("Edit Size");
        editAction.setForeground(Theme.blockedForeground);
        editAction.setBackground(Theme.background);
        editAction.setEnabled(false);

        final JMenuItem openImageAction = new JMenuItem("OpenImage");
        openImageAction.setForeground(Theme.blockedForeground);
        openImageAction.setBackground(Theme.background);
        openImageAction.setEnabled(false);
        
        
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
        fileMenu.add(editAction);
        fileMenu.add(openImageAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        
       
        newAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected = new MapWindow(selectedState);
				new DimensionsWindow(selected);
				
				editAction.setEnabled(true);
				editAction.setForeground(Theme.foreground);
				
				openImageAction.setEnabled(true);
				openImageAction.setForeground(Theme.foreground);
				
			}
			
		});
        
        editAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new DimensionsWindow(selected);
			}
		});
        
        openImageAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new FileNameExtensionFilter("png", "JPG & GIF Images", "jpg", "gif"));
				chooser.setDialogTitle("Map Selection");
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(parent);
				String imgFile = chooser.getSelectedFile().getPath();
				System.out.println(imgFile);
				selected.setBackgroundImage(imgFile);
				
			}
		});
        
        tools = new ToolsGraphicsPanel();
        atributes = new AtributesPanel();
       
        
        
        tools.setSelectBtAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedState.setStateType(SelectedState.SELECT);
				
			}
		});
        
        tools.setRoadBtAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedState.setStateType(SelectedState.ROAD);
				
			}
		});
        
        tools.setLocalBtAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedState.setStateType(SelectedState.LOCAL);
				
			}
		});
        
        tools.setStairsBtAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedState.setStateType(SelectedState.STAIRS);
				
			}
		});
        
        tools.setExitBtAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedState.setStateType(SelectedState.EXIT);
				
			}
		});
        
        tools.setEraseBtAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedState.setStateType(SelectedState.ERASE);
				
			}
		});
        
        menuBar.updateUI();        
        
	}
	
	public static void main(String[] args) {
		MaeocsMappingApplication menu = new MaeocsMappingApplication();
		
	}
}
