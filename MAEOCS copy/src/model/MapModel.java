package model;

import java.util.HashMap;

public class MapModel {
	
	private Point[][] map;
	private HashMap<String, Road> roads;

	public MapModel(int width, int depth){
		map = new Point[width][depth];
	}
	
	public void addRoad(String name,Road road){
		roads.put(name, road);
	}
	
	public Road getRoad(String name){
		return roads.get(name);
	}
	
	public Point getNode(int x, int y){
		return map[x][y];
	}
	
}