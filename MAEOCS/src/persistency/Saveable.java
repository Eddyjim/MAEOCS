package persistency;

import java.awt.Image;
import java.io.Serializable;

import model.MapModel;
import model.RoadsDirectory;

/**
 * 
 * @author Carlos Gaitan Mora & Edward Jimenez Martinez
 *
 */
public class Saveable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 623782177068146958L;
	private Image image;
	private MapModel model;
	private RoadsDirectory roads;
	private int width;
	private int height;
	private int grindSize;
	
	public Saveable(Image image, MapModel model, RoadsDirectory roads, int width, int height, int grindSize) {
		this.image = image;
		this.model = model;
		this.roads = roads;
		this.width = width;
		this.height = height;
		this.grindSize = grindSize;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public MapModel getModel() {
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
