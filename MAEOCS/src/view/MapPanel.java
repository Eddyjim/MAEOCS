package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MapPanel extends JPanel{

	 private int width=0;
	 private int height=0;
	

    /**
     * Selected state
     */
    private State state;
    
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
    static int gridSize=0;
    
    /**
     * Back label
     */
    static JLabel principalLabel = new JLabel ();
    
    /**
     * Window Background
     */
    static Color bgColor = new Color (52, 101, 164);
    
    public MapPanel() {
		
	}
    
    @SuppressWarnings("static-access")
	public void resize(int widthX, int heightY, int TamGrid) {
    	
    	this.width = widthX;
    	this.height = heightY;
    	this.gridSize = TamGrid;
    	this.state = null;
    	
    	this.setMinimumSize(new Dimension(widthX, heightY));
    	this.setMaximumSize(new Dimension(widthX, heightY));
    	this.setSize(new Dimension(widthX, heightY));
    	
    	principalLabel.setLayout(new GridLayout(gridSize, gridSize));
    	this.setLayout(new GridLayout(1, 1));
        setOpaque (false);
        createGrid();
        this.setVisible(true);
        
    }
    
    public static MapPanel getInstance (int widthX, int heightY, int TamGrid,
    		State state){
    	return new MapPanel ();
    }
    
    
    public ImageIcon createImage(String path) {
	  URL imgURL = getClass().getResource(path);
	     if (imgURL != null) {
	         return new ImageIcon(imgURL);
	     } else {
	         System.err.println("Couldn't find files: " + path);
	         return null;
	     }
	 }
    	 
	 @Override
	 public void paint(Graphics g) {
	 
	  // Pintamos la imagen de fondo...
	  if(mainBackGroundImg != null) {
	   g.drawImage(mainBackGroundImg, 0, 0, null);
	  }
	  // Y pintamos el resto de cosas que pueda tener el panel
	  super.paint(g);
	 
	 }
    
    private void createGrid(){
    	this.mapSections = new MapSection[gridSize][gridSize];
    	
    	for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				mapSections[i][j]= new MapSection(state, i, j);
				principalLabel.add(mapSections[i][j].getLabel());
			}
		}
    }

	public void setBackground(String img) {
		mainBackGroundImg = this.createImage(img).getImage();
	}

	public void paintBackground(Image img) {
		principalLabel.setIcon(new ImageIcon(img.getScaledInstance(width, height, 1)));
		principalLabel.setSize(width,height);
		this.add(principalLabel);
	}
}
 
