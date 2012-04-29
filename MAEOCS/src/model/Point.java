package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Point {
	
	private String name;
	private HashMap<String,ArrayList<String>> points;
	
	public Point(String name){
		this.name = name;
		points = new HashMap<String, ArrayList<String>>();
	}
	
	public void update(ArrayList<String> nodes, String point, String previous){
		
		ArrayList<String> aux = (ArrayList<String>) points.get(previous).clone();
		aux.addAll(nodes);
		points.put(point, aux);
		
	}
	
	public String getName(){
		return name;
	}
	
	public HashMap<String, ArrayList<String>> getPoints(){
		return points;
	}

	public void generateNodes(Point previous, ArrayList<String> nodes) {
		
		for(String key : previous.getPoints().keySet()){
			ArrayList<String> aux = (ArrayList<String>) previous.getPoints().get(key).clone();
			aux.addAll(nodes);
			points.put(key, aux);
		}
	}
	
	
	
}
