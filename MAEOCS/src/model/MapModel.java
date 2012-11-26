package model;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * This class contains is used to build an abstract model of the map, and contains
 * the search engine to find the closest route between two points 
 *
 * @author Carlos Gaitán Mora && Edward Jiménez Martínez
 *
 */
public class MapModel {
	
	private static HashMap<String, Node> map;
	private static Hashtable<String, String> localsDictionary;
	
	public MapModel(){
		map = new HashMap<String, Node>();
		localsDictionary = new Hashtable<String, String>();
	}
	
	public void addNode(Node node){
		
		map.put(node.getId(), node);
	}
	
	/**
	 * Search engine that calculates the optimal road to connect two points using
	 * the A* algorithm
	 * 
	 * @param pointA is the first point used for reference in the algorithm
	 * @param pointB is the second point used for reference in the algorithm
	 */
	public static ArrayList<String> aStar(Node pointA, Node pointB){
		
		HashMap<String, ArrayList<String>> roads;
		
		roads = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> road = new ArrayList<String>();
		road.add(pointA.getId());

		roads.put(pointA.getId(), road);
		
		/**
		 * Calculates the roads until the desired point comes out
		 */
		while (!roads.containsKey(pointB.getId())){
						
			HashMap<String, ArrayList<String>> choices = getChoices(roads);
			String selected = bestChoice(choices,pointB);
			
			map.get(selected).visit();
			cleanRoads(roads);
			roads.put(selected, choices.get(selected));
			
		}
		
		return roads.get(pointB);
	}
	
	/**
	 * This method gets all the choices that can be used
	 * 
	 * @param roads
	 * @return
	 */
	private static HashMap<String, ArrayList<String>> getChoices(
			HashMap<String, ArrayList<String>> roads) {
		
		HashMap<String,ArrayList<String>> conections = new HashMap<String, ArrayList<String>>();
		
		for (Entry<String, ArrayList<String>> entry : roads.entrySet()) {
			
			Node n = map.get(entry.getKey());
			Iterator<String> i = n.getConnectionsList().iterator();
			
			
			/**
			 * 	Adds only the nodes that haven't been visited
			 */
			while (i.hasNext()) {
				String s = i.next();
				if (!map.get(s).isVisited()){
					ArrayList<String> visited = new ArrayList<String>();
					visited.addAll(entry.getValue());
					visited.add(s);
					conections.put(s, visited);
				}
			}
		}
		return conections;
	}
	
	/**
	 * This method choose the best option based on a heuristic made by geometry
	 * 
	 * @param choices
	 * @param pointB
	 * @return
	 */
	private static String bestChoice(HashMap<String, ArrayList<String>> choices, Node pointB) {
		
		double min = Double.MAX_VALUE;
		
		String best = null;
		
		for (Entry<String, ArrayList<String>> entry : choices.entrySet()){
			
			Node n = map.get(entry.getKey());
			double expert = n.bestDistance(pointB);
			
			if (expert+entry.getValue().size()<min){
				min = expert+entry.getValue().size();
				best = n.getId();
			}
		}
		return best;
	}
	
	
	/**
	 * This method erases any roads that are no longer necessary 
	 * 
	 * @param roads
	 */
	private static void cleanRoads(HashMap<String, ArrayList<String>> roads) {
		
//		HashMap<String,ArrayList<String>> conections = new HashMap<String, ArrayList<String>>();
		
		for (Entry<String, ArrayList<String>> entry : roads.entrySet()) {
			
			Node n = map.get(entry.getKey());
			Iterator<String> i = n.getConnectionsList().iterator();
			
			boolean usable = false;
			
			while (i.hasNext() && !usable) {
				String s = i.next();
				if (!map.get(s).isVisited()){
					usable = true; 	
				}
			}
			
			if(!usable){
				roads.remove(entry);
			}
		}
	}
	
	/**
	 * This method allows to get a list of the adjacent nodes to this one
	 * 
	 * @param x is an integer that contains the position on the horizontal axis
	 * @param y is an integer that contains the position on the vertical axis
	 * @return a list that contains all the neighbors of the node in position (x,y)
	 */
	public ArrayList<Node> getNeighbors(int x, int y){
		
		ArrayList<Node> ans = new ArrayList<Node>();
		
		/**
		 * Adds the next node to the right
		 */
		int x1 = x+1;
		String key = ""+x1+","+y;
		
		if(map.containsKey(key)){
			ans.add( map.get(key));
		}
		
		/**
		 * Adds the next node to the left
		 */
		x1=x-1;
		key = ""+x1+","+y;

		if(map.containsKey(key)){
			ans.add( map.get(key));
		}
		
		/**
		 * Adds the next node above
		 */
		x1=y+1;
		key = ""+x+","+x1;
		
		if(map.containsKey(key)){
			ans.add( map.get(key));
		}
		
		/**
		 * Adds the next node bellow
		 */
		x1=y-1;
		key = ""+x+","+x1;

		if(map.containsKey(key)){
			ans.add( map.get(key));
		}
		
		return ans;
		
	}

	/**
	 * This method erase a node from the map and all the connections it has
	 * @param node that is going to be erased
	 */
	public void remove(Node node) {
		
		ArrayList<Node> connenctions = getNeighbors(node.getPosition().x, node.getPosition().y);
		
		Iterator<Node> i = connenctions.iterator();
		
		while(i.hasNext()){
			i.next().eraseConnection(node);
		}
		
		map.remove(node.getId());
		
	}

	/**
	 * This method get all the adjacent nodes that are not yet connected to the base node
	 * @param node is the base node to calculate all the other nodes
	 * @return a list of nodes that are not connected yet with the base node
	 */
	public ArrayList<Node> getNotConnectedNeighbors(Node node) {
		
		ArrayList<Node> connenctions = getNeighbors(node.getPosition().x, node.getPosition().y);
		Iterator<Node> i = connenctions.iterator();
		
		while (i.hasNext()) {
			Node n = i.next();
			if(node.isConnectedTo(n.getId())){
				connenctions.remove(n);
			}
		}
		
		return connenctions;
	}
	
	/**
	 * This method adds a combination between local name and node id for future requirements
	 * 
	 */
	public void addLocalToDictionary(String id, String name){
		localsDictionary.put(name, id);
	}
}
	