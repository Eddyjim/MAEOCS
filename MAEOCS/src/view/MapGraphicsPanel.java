package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.MapSection;
import model.SectionType;
import model.State;

public class MapGraphicsPanel extends JPanel{
 	
    private int width=0;
    private int height=0;

    /*
     * Dimensiones de cada sección, en pixeles
     */
    private int sectionW=0;
    private int sectionH=0;

    /*
     * Estado de la seleccion del panel de secciones
     */
    private State state;
    /*
     * Grilla de secciones
     */
    
    private MapSection[][] mapSections;
    
    /*
     * Imagen usada para pintar el mapa
     */
    static Image mainBackGroundImg;
    
    /*
     * Tamano de la Grilla
     */
    static int gridTam=0;
    
    /*
     * Color de fondo del mapa
     */
    static Color bgColor = new Color (52, 101, 164);

    private MapGraphicsPanel(int widthX, int heightY, int TamGrid, 
    		State state) {
    	this.width = widthX;
    	this.height = heightY;
    	this.gridTam = TamGrid;
    	this.state = state;
    	
    	this.sectionW = (int)Math.ceil(width/gridTam);
    	this.sectionH = (int)Math.ceil(height/gridTam);
    	
    	this.width = sectionW*gridTam;
    	this.height = sectionH*gridTam;
    	
    	Dimension dim = new Dimension (width, height);
    	
    	this.setSize(width, height);
    	this.setMaximumSize(dim);
    	this.setMinimumSize(dim);
    	
    	this.setBackground(Color.WHITE);
    	
    	this.setLayout(new GridLayout(gridTam, gridTam));
    	
        setOpaque (false);
        createGrid();
        this.setVisible(true);
        
    }
    
    public static MapGraphicsPanel getInstance (int widthX, int heightY, int TamGrid,
    		State state){
    	return new MapGraphicsPanel (widthX,heightY,TamGrid,state);
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
    	this.mapSections = new MapSection[gridTam][gridTam];
    	
    	for (int i = 0; i < gridTam; i++) {
			for (int j = 0; j < gridTam; j++) {
				mapSections[i][j]= new MapSection(state);
				this.add(mapSections[i][j].getLabel());
			}
		}
    }

	public void setBackground(String img) {
		mainBackGroundImg = this.createImage(img).getImage();
	}
}
 
