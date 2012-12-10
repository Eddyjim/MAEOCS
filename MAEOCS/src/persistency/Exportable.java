package persistency;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import sun.java2d.pipe.BufferedBufImgOps;

import model.RoadsDirectory;

public class Exportable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3213930124871683109L;
	/**
	 * 
	 */
	private byte[] image;
	private Hashtable<String, String> localsDictionary;
	private RoadsDirectory roads;
	private int width;
	private int height;
	private int xCells;
	private int yCells;
	
	public Exportable(Image image,Hashtable<String, String> localsDictionary,
			RoadsDirectory roads, int width, int height, int xCells, int yCels ){
		
		this.image = ImageConverter.convertToBytes(image);
		this.localsDictionary = localsDictionary;
		this.roads = roads;
		this.width = width;
		this.height = height;
		this.xCells = xCells;
		this.yCells = yCels;
		
	}
	

}
