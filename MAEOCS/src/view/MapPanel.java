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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MapModel;


/**
 * This class is used to contain the grid that simulates the map grille
 * 
 * @author Carlos Gaitán Mora && Edward Jiménez Martínez
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
    
    /**
     * This method allows to resize the panel
     * @param widthX is an integer that contains the value of the new width
     * @param heightY is an integer that contains the value of the new height
     * @param gridSize is an integer that contains the number of cells that the 
     * grid will have
     */
    @SuppressWarnings("static-access")
	public void resize(int widthX, int heightY, int gridSize) {
    	
    	this.width = widthX;
    	this.height = heightY;
    	this.gridSize = gridSize;
    	
    	this.setMinimumSize(new Dimension(widthX, heightY));
    	this.setMaximumSize(new Dimension(widthX, heightY));
    	this.setSize(new Dimension(widthX, heightY));

    	backGroundlLabel.setLayout(new GridLayout(gridSize, gridSize));
    	this.setLayout(new GridLayout(1, 1));
        createGrid();
        this.add(backGroundlLabel);
        this.setVisible(true);
        this.setOpaque(true);
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
	 
	  // Paint the background picture
	  if(mainBackGroundImg != null) {
	   g.drawImage(mainBackGroundImg, 0, 0, null);
	  }
	  
	  super.paint(g);
	 
	 }
    
	/**
	 * This method creates a new grid with the new size
	 */
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
}
 
