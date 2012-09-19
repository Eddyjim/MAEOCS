package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Node{
	private String name;
	private boolean visited = false;
	private java.awt.Point position;
	private HashMap<String, Node> connections = new HashMap<String, Node>();
	
	public Node(String name, Point position){
		this.name = name;
		this.position = position;
	}
	
	public String getName(){
		return name;
	}
	//Position
	public java.awt.Point getPosition(){
		return position;
	}
	
	public Node getNode(String key){
		return connections.get(key);
	}
	
	public ArrayList<String> getConnectionsList(){
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (Entry<String, Node> entry : connections.entrySet()){
			list.add(entry.getKey());
		}
		
		return list;
		
	}
	
	public void addConnection(String key, Node node){
		connections.put(key, node);
	}
	
	public void visit(){
		visited = true;
	}
	
	public boolean isVisited(){
		return visited;
	}
	
	public double bestDistance(Node point){
		return Math.sqrt(Math.pow(position.getX()-point.getPosition().getX(),2)
				+ Math.pow(position.getY()-point.getPosition().getY(),2));
	}
}