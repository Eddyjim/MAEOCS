package edu.eci.model;

import java.io.Serializable;
import java.util.Hashtable;

@SuppressWarnings("unused")
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
