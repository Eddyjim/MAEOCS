package persistency;

import java.awt.Image;
import java.io.Serializable;
import java.util.Hashtable;

import model.RoadsDirectory;

public class Exportable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3213930124871683109L;
	/**
	 * 
	 */
	private Image image;
	private static Hashtable<String, String> localsDictionary;
	private RoadsDirectory roads;
	private int width;
	private int height;
	private int xCells;
	private int yCells;
	

}
