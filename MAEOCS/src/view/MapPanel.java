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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.MapSection;
import model.SectionType;
import model.State;

public class MapPanel extends JPanel{
 	
    private int width=0;
    private int height=0;

    /**
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
     * Label para fondo de la ventana
     */
    static JLabel principalLabel = new JLabel ();
    
    /*
     * Color de fondo del mapa
     */
    static Color bgColor = new Color (52, 101, 164);
    
    public MapPanel() {
		// TODO Auto-generated constructor stub
	}
    
    public void resize(int widthX, int heightY, int TamGrid) {
    	this.width = widthX;
    	this.height = heightY;
    	this.gridTam = TamGrid;
    	this.state = null;
    	
    	this.setMinimumSize(new Dimension(widthX, heightY));
    	this.setMaximumSize(new Dimension(widthX, heightY));
    	this.setSize(new Dimension(widthX, heightY));
    	
    	principalLabel.setLayout(new GridLayout(gridTam, gridTam));
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
    	this.mapSections = new MapSection[gridTam][gridTam];
    	
    	for (int i = 0; i < gridTam; i++) {
			for (int j = 0; j < gridTam; j++) {
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
 
