package persistency;

import java.io.Serializable;
import java.util.Hashtable;
import model.RoadsDirectory;

/**
 * @author Carlos Gaitan & Edward Jimenez
 * This class contains the necessary information for the mobile application use
 */
public class Exportable implements Serializable{

	/**
	 * Serial Number
	 */
	private static final long serialVersionUID = -3213930124871683109L;

	/**
	 * An image saved in an array of bytes
	 */
	private byte[] image;
	
	/**
	 * The dictionary that contains all the locals using the local number as a key
	 */
	private Hashtable<String, String> localsDictionary;
	
	/**
	 * The dictionary of all roads for each local
	 */
	private RoadsDirectory roads;
	
	/**
	 * Width of the map in pixels
	 */
	private int width;
	
	/**
	 * Height of the map in pixels
	 */
	private int height;
	
	/**
	 * Number of cells in horizontal axis
	 */
	private int xCells;
	
	/**
	 * Number of cells in vertical axis
	 */
	private int yCells;
	
	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the localsDictionary
	 */
	public Hashtable<String, String> getLocalsDictionary() {
		return localsDictionary;
	}

	/**
	 * @param localsDictionary the localsDictionary to set
	 */
	public void setLocalsDictionary(Hashtable<String, String> localsDictionary) {
		this.localsDictionary = localsDictionary;
	}

	/**
	 * @return the roads
	 */
	public RoadsDirectory getRoads() {
		return roads;
	}

	/**
	 * @param roads the roads to set
	 */
	public void setRoads(RoadsDirectory roads) {
		this.roads = roads;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the xCells
	 */
	public int getxCells() {
		return xCells;
	}

	/**
	 * @param xCells the xCells to set
	 */
	public void setxCells(int xCells) {
		this.xCells = xCells;
	}

	/**
	 * @return the yCells
	 */
	public int getyCells() {
		return yCells;
	}

	/**
	 * @param yCells the yCells to set
	 */
	public void setyCells(int yCells) {
		this.yCells = yCells;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Exportable(byte[] image,Hashtable<String, String> localsDictionary,
			RoadsDirectory roads, int width, int height, int xCells, int yCels ){
		
		this.image = image;
		this.localsDictionary = localsDictionary;
		this.roads = roads;
		this.width = width;
		this.height = height;
		this.xCells = xCells;
		this.yCells = yCels;
		
	}
}
