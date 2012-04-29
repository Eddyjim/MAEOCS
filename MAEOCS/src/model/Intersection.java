package model;

import java.util.HashMap;

public class Intersection extends Point{
	
	
	public Intersection(String name) {
		super(name);
	}
	private HashMap<String, Road> roads;

	public HashMap<String, Road> getRoads() {
		return roads;
	}
	
}
