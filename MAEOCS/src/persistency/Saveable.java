package persistency;

import java.awt.Image;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.ImageIcon;

import model.MapModel;
import model.Node;
import model.RoadsDirectory;

/**
 * This  class contains all the data that contains a map
 * 
 * @author Carlos Gaitan Mora & Edward Jimenez Martinez
 */
public class Saveable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 623782177068146958L;
	private ImageIcon image;
	private MapModel model;
	private RoadsDirectory roads;
	private int width;
	private int height;
	private int grindSize;
	private HashMap<String, Node> map;
	private Hashtable<String, String> localsDictionary;
	
	/**
	 * Creates a class ready to be saved that contains the information in a file
	 * @param image is the image used as background on the application
	 * @param model contains an abstract model of the map
	 * @param roads contains the roads already compilated
	 * @param width contains the width of the map
	 * @param height contains the height of the map
	 * @param grindSize contains cells' size of the map
	 */
	public Saveable(Image image, MapModel model, RoadsDirectory roads, int width, int height, int grindSize) {
		if(image != null)
			this.image = new ImageIcon(image);
		this.model = model;
		this.roads = roads;
		this.width = width;
		this.height = height;
		this.grindSize = grindSize;
		this.map = model.getMap();
		this.localsDictionary = model.getLocalsDictionary();
	}

	public Image getImage() {
		return image.getImage();
	}

	public void setImage(Image image) {
		this.image = new ImageIcon(image);
	}

	public MapModel getModel() {
		model.setLocalsDictionary(localsDictionary);
		model.setMap(map);
		return model;
	}

	public void setModel(MapModel model) {
		this.model = model;
	}

	public RoadsDirectory getRoads() {
		return roads;
	}

	public void setRoads(RoadsDirectory roads) {
		this.roads = roads;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getGrindSize() {
		return grindSize;
	}

	public void setGrindSize(int grindSize) {
		this.grindSize = grindSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
