package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import persistency.MCSFileFilter;

/**
 * This class is the main menu of the interface for the application
 * @author Carlos Gaitan Mora & Edward Jimenez Martinez
 */
@SuppressWarnings("serial")
public class MaeocsMappingApplication extends JFrame{
	
	private MaeocsMappingApplication parent = this;
	private JMenuBar menuBar;
	private ToolsGraphicsPanel tools;
	private MapWindow selected;
	private AtributesPanel atributes;
	private State selectedState;
	private LocalAtributesManager selectedNode;
	
	
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
		selectedNode = new LocalAtributesManager();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    menuBar = new JMenuBar();
	    
	    menuBar.setBackground(Theme.background);
	    menuBar.repaint();
	    
	    /*
	     * Add the menu bar to the frame
	     */
	    setJMenuBar(menuBar);
	    
	    /* 
	     * Define and add two drop down menu to the menu bar
	     */
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
        
        /*
         *  Create and add simple menu items to the drop down menu
         */
        final JMenuItem newAction = new JMenuItem("New");
        newAction.setForeground(Theme.foreground);
        newAction.setBackground(Theme.background);
        
        final JMenuItem loadAction = new JMenuItem("Load");
        loadAction.setForeground(Theme.foreground);
        loadAction.setBackground(Theme.background);

        
        final JMenuItem saveAction = new JMenuItem("Save");
        saveAction.setForeground(Theme.blockedBackground);
        saveAction.setBackground(Theme.background);
        saveAction.setEnabled(false);
        
        final JMenuItem exportAction = new JMenuItem("Export");
        exportAction.setForeground(Theme.blockedBackground);
        exportAction.setBackground(Theme.background);
        exportAction.setEnabled(false);
        
        final JMenuItem editAction = new JMenuItem("Edit Size");
        editAction.setForeground(Theme.blockedForeground);
        editAction.setBackground(Theme.background);
        editAction.setEnabled(false);

        final JMenuItem openImageAction = new JMenuItem("OpenImage");
        openImageAction.setForeground(Theme.blockedForeground);
        openImageAction.setBackground(Theme.background);
        openImageAction.setEnabled(false);
        
        final JMenuItem compileMapAction = new JMenuItem("Compile Map");
        compileMapAction.setForeground(Theme.blockedForeground);
        compileMapAction.setBackground(Theme.background);
        compileMapAction.setEnabled(false);
        
        
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
        
        final JMenuItem showSimulatorAction = new JMenuItem("Simulator");
        showSimulatorAction.setForeground(Theme.blockedForeground);
        showSimulatorAction.setBackground(Theme.background);
        showSimulatorAction.setEnabled(false);
        
        /*
         * add the items to the menu item
         */
        
        fileMenu.add(newAction);
        fileMenu.add(loadAction);
        fileMenu.add(saveAction);
        fileMenu.add(exportAction);
        fileMenu.add(editAction);
        fileMenu.add(openImageAction);
        fileMenu.add(compileMapAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        
        viewMenu.add(showSimulatorAction);
        
        /*
         * Sets the "New" button action
         */
        newAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected = new MapWindow(selectedState, selectedNode);
				new DimensionsWindow(selected);
				
				/*
				 * Enable edit size and compile map 
				 */
				editAction.setEnabled(true);
				editAction.setForeground(Theme.foreground);
				
				saveAction.setEnabled(true);
				saveAction.setForeground(Theme.foreground);
				
				exportAction.setEnabled(true);
				exportAction.setForeground(Theme.foreground);
				
				openImageAction.setEnabled(true);
				openImageAction.setForeground(Theme.foreground);
				
				compileMapAction.setEnabled(true);
				compileMapAction.setForeground(Theme.foreground);
				
				showSimulatorAction.setEnabled(true);
				showSimulatorAction.setForeground(Theme.foreground);
				
			}
		});

        /*
         * Sets the "Load" button action
         */
        loadAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new MCSFileFilter());
				chooser.setDialogTitle("Load Map");
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(parent);
				chooser.setFileHidingEnabled(true);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "MAEOCS");
				chooser.setFileFilter(filter);
				String saveFile = chooser.getSelectedFile().getAbsolutePath();
				System.out.println(saveFile);
				
				try {
					selected = new MapWindow(selectedState, selectedNode, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					/*
					 * Enable edit size and compile map 
					 */
					editAction.setEnabled(true);
					editAction.setForeground(Theme.foreground);
					
					saveAction.setEnabled(true);
					saveAction.setForeground(Theme.foreground);
					
					exportAction.setEnabled(true);
					exportAction.setForeground(Theme.foreground);
					
					openImageAction.setEnabled(true);
					openImageAction.setForeground(Theme.foreground);
					
					compileMapAction.setEnabled(true);
					compileMapAction.setForeground(Theme.foreground);
					
					showSimulatorAction.setEnabled(true);
					showSimulatorAction.setForeground(Theme.foreground);
					
					
				}
				
			}
		});
        
        /*
         * Sets the "Save" button action
         */
        saveAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new MCSFileFilter());
				chooser.setDialogTitle("Save Map");
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showSaveDialog(parent);
				String saveFile = chooser.getSelectedFile().getPath();
				if(!saveFile.endsWith(".mcs")){
					saveFile = saveFile.concat(".mcs");
					System.out.println(saveFile);
				}
				try {
					selected.saveFile(saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
        
        /*
         * Sets the "Export" button action
         */
        exportAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new MCSFileFilter());
				chooser.setDialogTitle("Export Map");
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showSaveDialog(parent);
				String saveFile = chooser.getSelectedFile().getPath();
				if(!saveFile.contains(".mmcs")){
					saveFile.concat(".mmcs");
				}
				try {
					selected.exportFile(saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
        
        /*
         * Sets the "Edit" button action
         */
        editAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new DimensionsWindow(selected);
			}
		});
        
        /*
         * Sets the "Open Image" button action
         */
        openImageAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new FileNameExtensionFilter("png", "JPG & GIF Images", "jpg", "gif"));
				chooser.setDialogTitle("Map Selection");
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(parent);
				String imgFile = chooser.getSelectedFile().getPath();
				selected.setBackgroundImage(imgFile);
				
			}
		});
        
        /*
         * Sets the "Compile Map" button action
         */
        compileMapAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected.compileMap();
			}
		});
        
        showSimulatorAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected.startSimulation();
			}
		});
        
        tools = new ToolsGraphicsPanel();
        atributes = new AtributesPanel(selectedNode);
        selectedNode.addPanel(atributes);
       
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
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MaeocsMappingApplication menu = new MaeocsMappingApplication();
		
	}
}
