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

import model.MapModel;


@SuppressWarnings("serial")
public class MapPanel extends JPanel{

	 private int width=0;
	 private int height=0;
	 
	 private MapModel model;
	

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
    static JLabel backGroundlLabel = new JLabel ();
    
    /**
     * Window Background
     */
    static Color bgColor = Theme.background;
    
    public MapPanel(State state) {
    	
    	this.state = state;
    	model = new MapModel();
    }
    
    @SuppressWarnings("static-access")
	public void resize(int widthX, int heightY, int TamGrid) {
    	
    	this.width = widthX;
    	this.height = heightY;
    	this.gridSize = TamGrid;
    	
    	this.setMinimumSize(new Dimension(widthX, heightY));
    	this.setMaximumSize(new Dimension(widthX, heightY));
    	this.setSize(new Dimension(widthX, heightY));

    	backGroundlLabel.setLayout(new GridLayout(gridSize, gridSize));
    	this.setLayout(new GridLayout(1, 1));
        createGrid();
        this.add(backGroundlLabel);
        this.setVisible(true);
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
				mapSections[i][j]= new MapSection(state, i, j, model);
				backGroundlLabel.add(mapSections[i][j].getLabel());
			}
		}
    }

	public void setBackground(String imgFile) {
		mainBackGroundImg = this.createImage(imgFile).getImage();
		
	}

	public void paintBackground(Image img) {
		backGroundlLabel.setIcon(new ImageIcon(img.getScaledInstance(width, height, 1)));
		backGroundlLabel.setSize(width,height);
		this.add(backGroundlLabel);
	}
}
 
