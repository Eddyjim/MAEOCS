package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import persistency.Exportable;
import persistency.Saveable;

import model.MapModel;
import model.RoadsDirectory;


/**
 * This class is used to contain the grid that simulates the map grille
 * 
 * @author Carlos Gaitan Mora & Edward Jimenez Martinez
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
    
    /**
     * This method creates a new MapPanel, with all the necessary data 
     * @param state is the actual state that is selected
     * @param selectedNode is the selected node on the map
     */
    public MapPanel(State state, LocalAtributesManager selectedNode) {
    	this.localAtributesManager = selectedNode;
    	this.state = state;
    	model = new MapModel();
    	selectedNode.setModel(model);
    	roads = new RoadsDirectory();
    }
    
    public MapPanel(State selectedState, LocalAtributesManager selectedNode,
    		String saveFile) throws IOException, ClassNotFoundException {
    		this.localAtributesManager = selectedNode;
    		this.state = selectedState;
    		loadMap(saveFile);
    		selectedNode.setModel(model);
    		redo();
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
	
	public void redo() {
    	
    	
    	this.setMinimumSize(new Dimension(width, height));
    	this.setMaximumSize(new Dimension(width, height));
    	this.setSize(new Dimension(width, height));

    	backGroundlLabel.setLayout(new GridLayout(height/gridSize, width/gridSize));
    	this.setLayout(new GridLayout(1, 1));
        loadGrid();
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
    
    /**
     * 
     */
    private void loadGrid(){
   	 
    	int w= width/gridSize;
    	int h = height/gridSize;
    	
    	this.mapSections = new MapSection[w][h];
    	
    	for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				mapSections[i][j]= new MapSection(state,localAtributesManager, i, j, model);
				if(model.containsNode(""+i+","+j)){
					mapSections[i][j].setNode(model.getNode(""+i+","+j));
				}
				backGroundlLabel.add(mapSections[i][j].getLabel());
				
			}
		}
    }

    /**
     * This method allows to set a new background on the map
     * @param imgFile is the new image that is going to be settled
     */
	public void setBackground(String imgFile) {
		ImageIcon icon = new ImageIcon(imgFile);
		
		Image temp = icon.getImage();
		
		mainBackGroundImg = temp.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon = new ImageIcon(mainBackGroundImg);
		backGroundlLabel.setIcon(icon);
		
	}

	/**
	 * This method allows to paint the background
	 * @param img 
	 */
	public void paintBackground(Image img) {
		backGroundlLabel.setIcon(new ImageIcon(img.getScaledInstance(width, height, 1)));
		backGroundlLabel.setSize(width,height);
	}
	
	/**
	 * Calculates all possible combination of roads between all the Locals in the map
	 */
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
					roads.addRoad(n1,n2,road);
				}
				model.reset();
				
			}
		}
		
	}

	/**
	 * Creates a new grid that has only plane JLabels to show the map and no 
	 * logic under them, and call a new frame to create a simulation panel
	 */
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
				grid.add(label);
				label.setLayout(new GridLayout(1,1));
				Border border = LineBorder.createGrayLineBorder();
				label.setBorder(border);
				
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
		grid.setSize(width,height);
		SimulatorPanel simulation = new SimulatorPanel(width,height,gridSize,grid,gridArray,model.getDirectory(), roads);
		
		simulation.setVisible(true);
	}

	/**
	 * This method allows to create a Save-able object that is going to be saved
	 * @param saveFile is the path of the file that is going to be used
	 * @throws IOException in case of an error during the file writing
	 */
	public void saveMap(String saveFile) throws IOException {
		
		Saveable save = new Saveable(mainBackGroundImg,model,roads,width,height,gridSize);
		
		File file = new File(saveFile);
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			new ObjectOutputStream(os).writeObject(save);
		} catch (FileNotFoundException e) {
			throw new IOException("Error writing file");
		}
		finally{
			os.close();
		}
	}
	
	/**
	 * This method allows to create a Save-able object that is going to be saved
	 * @param saveFile is the path of the file that is going to be used
	 * @throws IOException in case of an error during the file writing
	 * @throws ClassNotFoundException 
	 */
	public void loadMap(String saveFile) throws IOException, ClassNotFoundException {
		
		Saveable save = null;
		File file = new File(saveFile);
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
			save = (Saveable) new ObjectInputStream(is).readObject();
		} catch (FileNotFoundException e) {
			throw new IOException("Error writing file");
		}
		finally{
			is.close();
		}
		if (save!= null){
			this.model = save.getModel();
		}
		
	}

	/**
	 * This method allows to create a Exportable object that is going to be saved
	 * @param saveFile is the path of the file that is going to be used
	 * @throws IOException in case of an error during the file writing
	 */
	public void exportMap(String saveFile) throws IOException {

		Exportable save = new Exportable(mainBackGroundImg, model.getDirectory(), roads, width, height, width/gridSize, height/gridSize);
		
		File file = new File(saveFile);
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			new ObjectOutputStream(os).writeObject(save);
		} catch (FileNotFoundException e) {
			throw new IOException("Error writing file");
		}
		finally{
			os.close();
		}
	}
}
 
