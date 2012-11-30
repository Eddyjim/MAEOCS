package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.naming.directory.DirContext;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.MapModel;
import model.RoadsDirectory;


/**
 * This class is used to contain the grid that simulates the map grille
 * 
 * @author Carlos Gait�n Mora && Edward Jim�nez Mart�nez
 */
@SuppressWarnings("serial")
public class MapPanel extends JPanel{

	/**
	 * Is the width of the panel
	 */
	private int width=0;
	 
	/**
	 * Is the height of the panel
	 */
	private int height=0;
	 
	/**
	 * Is the map model used to for calculations and other values
	 */
	private MapModel model;
	
	/**
	 * Its the roads' directory to save the outcoming roads
	 */
	private RoadsDirectory roads;
	
    /**
     * Selected state
     */
    private State state;
    
    /**
     * Selected node
     */
    private LocalAtributesManager localAtributesManager;
    
    /**
     * Section gird
     */
    private MapSection[][] mapSections;
    
    /**
     * Background image that contains the map
     */
    static Image mainBackGroundImg;
    
    /**
     * Grid Size
     */
    private int gridSize;
    
    /**
     * Back label
     */
    static JLabel backGroundlLabel = new JLabel ();
    
    /**
     * Window Background
     */
    static Color bgColor = Theme.background;
    
    public MapPanel(State state, LocalAtributesManager selectedNode) {
    	this.localAtributesManager = selectedNode;
    	this.state = state;
    	model = new MapModel();
    	selectedNode.setModel(model);
    	roads = new RoadsDirectory();
    }
    
    /**
     * This method allows to resize the panel
     * @param widthX is an integer that contains the value of the new width
     * @param heightY is an integer that contains the value of the new height
     * @param gridSize is an integer that contains the number of cells that the 
     * grid will have
     */
    
	public void resize(int widthX, int heightY, int gridSize) {
    	
    	this.width = widthX;
    	this.height = heightY;
    	this.gridSize = gridSize;
    	
    	this.setMinimumSize(new Dimension(widthX, heightY));
    	this.setMaximumSize(new Dimension(widthX, heightY));
    	this.setSize(new Dimension(widthX, heightY));

    	backGroundlLabel.setLayout(new GridLayout(heightY/gridSize, widthX/gridSize));
    	this.setLayout(new GridLayout(1, 1));
        createGrid();
        this.add(backGroundlLabel);
        this.setVisible(true);
        this.setOpaque(true);
    }

	/**
	 * This method creates a new grid with the new size
	 */
    private void createGrid(){
    	 
    	int w= width/gridSize;
    	int h = height/gridSize;
    	
    	this.mapSections = new MapSection[w][h];
    	
    	for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				mapSections[i][j]= new MapSection(state,localAtributesManager, i, j, model);
				backGroundlLabel.add(mapSections[i][j].getLabel());
			}
		}
    }

	public void setBackground(String imgFile) {
		ImageIcon icon = new ImageIcon(imgFile);
		
		Image temp = icon.getImage();
		
		mainBackGroundImg = temp.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon = new ImageIcon(mainBackGroundImg);
		backGroundlLabel.setIcon(icon);
		
	}

	public void paintBackground(Image img) {
		backGroundlLabel.setIcon(new ImageIcon(img.getScaledInstance(width, height, 1)));
		backGroundlLabel.setSize(width,height);
	}
	
	public void compileMap(){
		
		Hashtable<String, String> locals =  model.getDirectory();
		
		for(Entry<String, String> entry : locals.entrySet()){
			for (Entry<String, String> entry2 : locals.entrySet()) {
			
				String n1 = entry.getValue();
				String n2 = entry2.getValue();
				if(n2 != n1){
					ArrayList<String> road = model.aStar(model.getNode(n1),model.getNode(n2));
					if(road == null)
						System.out.println("camino vacio");
					roads.addRoad(model.getNode(n1),model.getNode(n2),road);
				}
				model.reset();
				
			}
		}
		
	}

	public void startSimulation() {
		
		JLabel grid = new JLabel();
		int h = height/gridSize;
		int w = width/gridSize;
		JLabel gridArray[][] = new JLabel[w][h];
		
		
		
		grid.setLayout(new GridLayout(h,w));
		
		JLabel label;
		for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				
				label = new JLabel();
				label.setLayout(new GridLayout(1,1));
				Border border = LineBorder.createGrayLineBorder();
				label.setBorder(border);
				
//				label.setEnabled(true);
//				label.setVisible(true);
//				label.setOpaque(false);
				gridArray[i][j] = label;
				switch (mapSections[i][j].getPointType()) {
				case NULL:
					label.setBackground(null);
					break;
				case ROAD:
					label.setBackground(Theme.roadColor);
					label.setOpaque(true);
					break;

				case LOCAL:
					label.setBackground(Theme.localColor);
					label.setOpaque(true);
					break;

				case STAIRS:
					label.setBackground(Theme.stairsColor);
					label.setOpaque(true);
					break;

				case EXIT:
					label.setBackground(Theme.exitColor);
					label.setOpaque(true);
					break;
					
				}
				
			}
		}
		
		if(mainBackGroundImg!= null){
			grid.setIcon(new ImageIcon(mainBackGroundImg));
			
		}
		SimulatorPanel simulation = new SimulatorPanel(width,height,gridSize,grid,gridArray,model.getDirectory(), roads);
		
		simulation.setVisible(true);
	}
}
 
