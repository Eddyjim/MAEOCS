package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.State;

public class MaeocsMappingApplication extends JFrame {
 
	private JFrame principal = this;
	
	private JFrame mapa;
	
	private JFrame tool;
	
	private JFrame directions;
		
	private MapGraphicsPanel grid;
	 
	private ToolsGraphicsPanel tools;
	
	private DirectionGraphicsPanel dir;
	 
	private JButton processMap;
	
	private Boolean pressed = false;
	
	private String path = File.separator+"tmp";
	private JFileChooser loadFile = new JFileChooser(new File(path));
	private File imgFile;
	 
	
	/*
	 * Colors
	 * */
	private final Color black = new Color(0, 0, 0);
	private final Color grayblack = new Color(50, 50, 50);
	private final Color white = new Color(255, 255, 255);
	private final Color blue = new Color(114, 159, 207);
	private final Color green = new Color(138, 226, 52);
	private final Color orange = new Color(252, 175, 62);
	private final Color purple = new Color(173, 127, 168);
	private final Color yellow = new Color(252, 233, 79);
	
	/*
	 * Dimensiones
	 * 
	 * */
	
	Dimension size = new Dimension (900,50);
	Dimension sizeFHalf = new Dimension (600,600);
	Dimension sizeSHalf = new Dimension (900,100);
	Dimension sizeButton = new Dimension (210,95);
	Dimension sizeDirPan = new Dimension (250,250);

	private State state;
	
	private MaeocsMappingApplication (){
		super("MAEOCS Mapping Application");
		this.setSize(900, 50);
		this.setLocation(10, 10);
		this.setBackground(black);
		this.setForeground(white);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.interfaceGenerator();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void interfaceGenerator (){
		
		/*
		 * create the menu
		 * 
		 * */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(grayblack);
        menuBar.repaint();
        // Add the menubar to the frame
        setJMenuBar(menuBar);
        
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        fileMenu.setForeground(white);
        fileMenu.setBackground(grayblack);
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.setForeground(white);
        editMenu.setBackground(grayblack);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        newAction.setForeground(white);
        newAction.setBackground(grayblack);
        JMenuItem openAction = new JMenuItem("OpenImage");
        openAction.setForeground(white);
        openAction.setBackground(grayblack);
        JMenuItem exitAction = new JMenuItem("Exit");
        exitAction.setForeground(white);
        exitAction.setBackground(grayblack);
        JMenuItem cutAction = new JMenuItem("Cut");
        cutAction.setForeground(white);
        cutAction.setBackground(grayblack);
        JMenuItem copyAction = new JMenuItem("Copy");
        copyAction.setForeground(white);
        copyAction.setBackground(grayblack);
        JMenuItem pasteAction = new JMenuItem("Paste");
        pasteAction.setForeground(white);
        pasteAction.setBackground(grayblack);
        
        //add the items to the menu item
        
        fileMenu.add(newAction);
        fileMenu.add(openAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
		
        this.setJMenuBar(menuBar);
        
        //creating the panels
        this.state = new State();

        tools = new ToolsGraphicsPanel(this);
        tools.setBackground(black);
        tools.setMaximumSize(sizeSHalf);
        tools.setMinimumSize(sizeSHalf);
        tools.setState(state);
        tools.setLayout(new GridLayout(1,4));
        
        dir = new DirectionGraphicsPanel(state);
        dir.setSize(sizeDirPan);        
        
        directions = new JFrame("DIRECTIONS");
        
        
        mapa = new JFrame ("MAPA");
        
        
        tool = new JFrame ("TOOLS");

        //set action listeners
        
        openAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadFile.showOpenDialog(principal);
				imgFile = loadFile.getSelectedFile();
				System.out.println(imgFile.getAbsolutePath());
				grid.setBackground(imgFile.getAbsolutePath());
			}
		});

        newAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final newWindow sizeWindow =new newWindow(principal);
				
				sizeWindow.setOkActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						if(sizeWindow.getWidhtSize()>100&& sizeWindow.getHeightSize()>100&&sizeWindow.getGrind()>10){
							
							grid = MapGraphicsPanel.getInstance(sizeWindow.getWidhtSize(),
							sizeWindow.getHeightSize(), sizeWindow.getGrind(), state);
							
							directions.setLocation(660, 60);
					        directions.getContentPane().setBackground(black);
					        directions.setForeground(white);
					        directions.setMaximumSize(sizeDirPan);
					        directions.setMinimumSize(sizeDirPan);
					        directions.setResizable(false);
					        directions.setBackground(black);
					        directions.getContentPane().add(dir);
					        directions.setEnabled(true);
					        
					        mapa.setLocation(10, 60);
					        mapa.getContentPane().setBackground(black);
					        mapa.setForeground(white);
					        mapa.setMaximumSize(new Dimension(sizeWindow.getWidhtSize(),sizeWindow.getWidhtSize()));
					        mapa.setMinimumSize(new Dimension(sizeWindow.getWidhtSize(),sizeWindow.getWidhtSize()));
					        mapa.setResizable(false);
					        mapa.setBackground(black);
					        mapa.getContentPane().add(grid);
					        mapa.setEnabled(true);
							
					        tool.setLocation(10, 665);
					        tool.setBackground(black);
					        tool.setForeground(white);
					        tool.setMaximumSize(sizeSHalf);
					        tool.setMinimumSize(sizeSHalf);
					        tool.setResizable(false);
					        tool.setBackground(black);
					        tool.getContentPane().add(tools);
					        
					        tool.setVisible(true);
					        mapa.setVisible(true);
					        directions.setVisible(true);
						}
						
					}
				});
			}
		});
	}
	
	
	public static void main(String[] args) {
		new MaeocsMappingApplication();
	}

	public void setMapEnabled(boolean b) {
		this.mapa.setEnabled(b);
	}
	
}