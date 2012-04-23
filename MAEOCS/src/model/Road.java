package model;

import java.util.HashMap;

public class Road {
	
	private String name;
	private HashMap<String,Node> nodes;
	
	public Road(){
		nodes = new HashMap<String, Node>();
	};
	
	public void addNode(Node node, String name){
		nodes.put(name, node);
	}
	
}