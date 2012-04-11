package pgr.maeocs.mvc;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.FileChooserUI;

public class MaeocsMappingApplication extends JFrame {
 
	private JFrame principal = this;
	
	private JFrame mapa;
	
	private JFrame tool;
	
	private JFrame direc;
	
	private DirGraphicsPanel dir;
	
	private SectionSelectedState state;
	
	private MapGraphicsPanel grid;
	 
	private JPanel tools;
	 
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
	
	Dimension size = new Dimension (900,50);
	Dimension sizeFHalf = new Dimension (600,600);
	Dimension sizeSHalf = new Dimension (900,100);
	Dimension sizeButton = new Dimension (210,95);
	Dimension sizeDirPan = new Dimension (250,250);
	
	private MaeocsMappingApplication (){
		super("MAEOCS Mapping Application");
		this.setSize(900, 50);
		this.setLocation(10, 10);
		this.setBackground(black);
		this.setForeground(white);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		new newWindow(principal);
		this.interfaceGenerator();
		this.setResizable(false);
//		this.setVisible(true);
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
        this.state = new SectionSelectedState();
        
        dir = new DirGraphicsPanel(state);
        dir.setSize(sizeDirPan);
        
        grid = MapGraphicsPanel.getInstance(500,300, 40, state, dir);
//        	grid.setBackground("/mnt/eddy/Pictures/anime/unda.gif");
        tools = new JPanel(new GridLayout(1,4));
        tools.setBackground(black);
        tools.setMaximumSize(sizeSHalf);
        tools.setMinimumSize(sizeSHalf);
        
        direc = new JFrame("DIRECTIONS");
        direc.setLocation(660, 60);
        direc.getContentPane().setBackground(black);
        direc.setForeground(white);
        direc.setMaximumSize(sizeDirPan);
        direc.setMinimumSize(sizeDirPan);
        direc.setResizable(false);
        direc.setBackground(black);
        direc.getContentPane().add(dir);
        direc.setEnabled(false);
        
        mapa = new JFrame ("MAPA");
        mapa.setLocation(10, 60);
        mapa.getContentPane().setBackground(black);
        mapa.setForeground(white);
        mapa.setMaximumSize(sizeFHalf);
        mapa.setMinimumSize(sizeFHalf);
        mapa.setResizable(false);
        mapa.setBackground(black);
        mapa.getContentPane().add(grid);
        mapa.setEnabled(false);
        
        tool = new JFrame ("TOOLS");
        tool.setLocation(10, 665);
        tool.setBackground(black);
        tool.setForeground(white);
        tool.setMaximumSize(sizeSHalf);
        tool.setMinimumSize(sizeSHalf);
        tool.setResizable(false);
        tool.setBackground(black);
        this.buttonsSection();
        tool.getContentPane().add(tools);
        
        tool.setVisible(true);
        mapa.setVisible(true);
        direc.setVisible(true);

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

        
	}
	
	
	public void buttonsSection (){
		final JButton nulo = new JButton("nulo");
		final JButton road = new JButton("road");
		final JButton io = new JButton("io");
		final JButton directions = new JButton("dir");
		
		nulo.setBackground(white);
		road.setBackground(white);
		io.setBackground(white);
		directions.setBackground(white);

		nulo.setBounds(3, 0, 210, 94);
		road.setBounds(3, 215, 210, 94);
		io.setBounds(3, 430, 210, 94);
		directions.setBounds(3, 645, 210, 94);
		
		nulo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					mapa.setEnabled(false);
					road.setEnabled(true);
					io.setEnabled(true);
					directions.setEnabled(true);
					pressed= !pressed;
				}
				else{
					mapa.setEnabled(true);
					road.setEnabled(false);
					io.setEnabled(false);
					directions.setEnabled(false);
					state.setToolsState(SectionType.NULL);
					state.setColor(null);
					pressed= !pressed;
				}
			}
		});
		
		road.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					mapa.setEnabled(false);
					nulo.setEnabled(true);
					io.setEnabled(true);
					directions.setEnabled(true);
					pressed= !pressed;
				}
				else{
					mapa.setEnabled(true);
					nulo.setEnabled(false);
					io.setEnabled(false);
					directions.setEnabled(false);
					state.setToolsState(SectionType.ROAD);
					state.setColor(purple);
					pressed= !pressed;
				}
			}
		});
		
		io.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					mapa.setEnabled(false);
					nulo.setEnabled(true);
					road.setEnabled(true);
					directions.setEnabled(true);
					pressed= !pressed;
				}
				else{
					mapa.setEnabled(true);
					nulo.setEnabled(false);
					road.setEnabled(false);
					directions.setEnabled(false);
					state.setToolsState(SectionType.IO);
					state.setColor(green);
					pressed= !pressed;
				}
			}
		});
		
		directions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					mapa.setEnabled(false);
					nulo.setEnabled(true);
					io.setEnabled(true);
					road.setEnabled(true);
					direc.setEnabled(false);
					pressed= !pressed;
				}
				else{
					mapa.setEnabled(true);
					nulo.setEnabled(false);
					io.setEnabled(false);
					road.setEnabled(false);
					direc.setEnabled(true);
					dir.setConnections();
					dir.createActions();
					state.setToolsState(SectionType.DIRECCTIONS);
					state.setColor(yellow);
					pressed= !pressed;
				}
			}
		});
		
		tools.add(nulo);
		tools.add(road);
		tools.add(io);
		tools.add(directions);
		
	}
	
	
	public static void main(String[] args) {
	  MaeocsMappingApplication app = new MaeocsMappingApplication();
	  app.setVisible(true);
	}
	 
}
 
