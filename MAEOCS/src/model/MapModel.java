package model;

import java.util.HashMap;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MapModel {
	
	private static HashMap<String, Node> map;
	
	public MapModel(){
		map = new HashMap<String, Node>();
	}
	
	public static void addNode(String name, Node node){
		map.put(name, node);
	}
	
	/**
	 * Search engine that calculates the optimal road to connect two points using
	 * the A* algorithm
	 * 
	 * @param pointA
	 * @param pointB
	 */
	public static ArrayList<String> aStar(Node pointA, Node pointB){
		
		HashMap<String, ArrayList<String>> roads;
		
		roads = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> road = new ArrayList<String>();
		road.add(pointA.getName());

		roads.put(pointA.getName(), road);
		
		/**
		 * Calculates the roads until the desired point comes out
		 */
		while (!roads.containsKey(pointB.getName())){
						
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
				best = n.getName();
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
		
		HashMap<String,ArrayList<String>> conections = new HashMap<String, ArrayList<String>>();
		
		for (Entry<String, ArrayList<String>> entry : roads.entrySet()) {
			
			Node n = map.get(entry.getKey());
			Iterator<String> i = n.getConnectionsList().iterator();
			
			boolean usable = false;
			
			while (i.hasNext()) {
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
}
	