package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class allows to save all the calculated nodes of the map
 * @author Carlos Gaitan & Edward Jimenez 
 */
public class RoadsDirectory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4336516856872480761L;
	
	/**
	 * Contains a directory that will contain the calculated roads for the map
	 */
	private HashMap<String, HashMap<String, ArrayList<String>>> directory;
	
	/**
	 * A constructor that initializes creates the actual directory
	 */
	public RoadsDirectory(){
		directory = new HashMap<String, HashMap<String,ArrayList<String>>>();
	}

	/**
	 * This method allows to add a road to the directory
	 * @param node is the Node1 Local Name to set in the directory 
	 * @param node2 is the Node2 Local Name to set in the directory
	 * @param road contains a list of nodes that are the road to connect the two nodes
	 */
	public void addRoad(String node, String node2, ArrayList<String> road) {
		String key1 = node;
		String key2 = node2;
		HashMap<String, ArrayList<String>> temp;
		
		if (!directory.containsKey(key1)) {
			temp = new HashMap<String, ArrayList<String>>();
			directory.put(key1, temp);
		}
		
		temp = directory.get(key1);
		temp.put(key2, road);
		
		if (!directory.containsKey(key2)) {
			temp = new HashMap<String, ArrayList<String>>();
			directory.put(key2, temp);
		}
		
		temp = directory.get(key2);
		temp.put(key1, road);
		
	}
	
	/**
	 * This method allows to get the road to connect 2 nodes
	 * @param node1 is the Node1 Local Name to get from the directory 
	 * @param node2 is the Node1 Local Name to get from the directory 
	 * @return contains a list of nodes that are the road to connect the two nodes
	 */
	public ArrayList<String> getRoad(String node1, String node2){
		return directory.get(node1).get(node2);
	}

}
