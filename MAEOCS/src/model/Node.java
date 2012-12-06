package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * This class contains the data an all the values needed for a node in the map
 * 
 * @author Carlos Gaitán Mora & Edward Jiménez Martínez
 */	
public class Node{
	
	/**
	 * String that contains the name of the node, the name is given by a notation
	 * x,y in which x is the position in the horizontal axis and y the position in 
	 * the vertical axis
	 */
	private String id;
	
	/**
	 * Contains the information if the node is a local
	 */
	private Local local;
	
	/**
	 * Its a flag to see if the node has been visited in the search of the roads
	 */
	private boolean visited = false;
	
	/**
	 * Contains the position of the node in a java.awt.Point
	 */
	private java.awt.Point position;
	
	/**
	 * Contains all the connections that a node may have
	 */
	private HashMap<String, Node> connections = new HashMap<String, Node>();

	/**
	 * Creator of the class
	 * 
	 * @param id is the String that identifies the node
	 * @param position is the position that the node will have
	 */
	public Node(String id, Point position){
		this.id = id;
		this.position = position;
	}
	
	/**
	 * It's a method to get the node's id
	 * @return is a String that contains the node's id
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * It's a method to get the position of the node
	 * @return is a Point that contains the position of the node
	 */
	public java.awt.Point getPosition(){
		return position;
	}
	
	/**
	 * A method that allows to get the all the connections for a node
	 * @return a List of nodes which are the nodes connected to the actual node
	 */
	public ArrayList<String> getConnectionsList(){
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (Entry<String, Node> entry : connections.entrySet()){
			list.add(entry.getKey());
		}
		
		return list;
		
	}
	
	/**
	 * This method sets a new connection to the node
	 * @param key is a string that contains the key used to find the node connected
	 * @param node is the node to connect
	 */
	public void addConnection(String key, Node node){
		connections.put(key, node);
	}
	
	/**
	 * A method that sets the node as visited
	 */
	public void visit(){
		visited = true;
	}
	
	/**
	 * A method that allows to know if the node is already visited
	 * @return a boolean that is true when the node is already visited
	 * and false if the node hasn't been visited
	 */
	public boolean isVisited(){
		return visited;
	}
	
	/**
	 * A method that calculates the best distance between two points using 
	 * geometry to calculate
	 * @param point is the other node to calculate the distance
	 * @return a double that contains the distance between the two points
	 */
	public double bestDistance(Node point){
		return Math.sqrt(Math.pow(position.getX()-point.getPosition().getX(),2)
				+ Math.pow(position.getY()-point.getPosition().getY(),2));
	}
	
	/**
	 * This method allows to erase a connection from the node
	 * @param node is the connection that is going to be erased
	 */
	public void eraseConnection(Node node) {
		connections.remove(node.getId());
	}
	
	/**
	 * Verifies if this node has an specific connection with another
	 * @param node is a string that contains the key of the node that is asked if is connected
	 * @return a boolean with the value true if the relation exist and with false if it doesn't
	 */
	public boolean isConnectedTo(String node){
		return connections.containsKey(node);
	}

	/**
	 * This method get the local information in a node
	 * @return a Local with all the information stored in this node
	 */
	public Local getLocal() {

		return local;
		
	}
	
	/**
	 * This method sets a local for the actual node
	 * @param local is the local that is going to be the node's local
	 */
	public void setLocal(Local local){
		this.local = local;
	}
	
	/**
	 * This method sets the node to an unvisited state
	 */
	public void unVisit(){
		visited=false;
	}
}