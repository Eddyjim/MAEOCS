package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class RoadsDirectory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4336516856872480761L;
	
	private HashMap<String, HashMap<String, ArrayList<String>>> directory;
	
	public RoadsDirectory(){
		directory = new HashMap<String, HashMap<String,ArrayList<String>>>();
	}

	public void addRoad(Node node, Node node2, ArrayList<String> road) {
		String key1 = node.getLocal().getName();
		String key2 = node2.getLocal().getName();
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
	
	public ArrayList<String> getRoad(String node1, String node2){
		return directory.get(node1).get(node2);
	}

}
