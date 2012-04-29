package model;

import java.awt.RadialGradientPaint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Point {
	
	private String name;
	private HashMap<String,ArrayList<String>> points;
	
	public Point(String name){
		this.name = name;
		points = new HashMap<String, ArrayList<String>>();
	}
	
	public void update(ArrayList<String> nodes, String point, Point previous){
		
		
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
			@SuppressWarnings("unchecked")
			ArrayList<String> aux = (ArrayList<String>) previous.getPoints().get(key).clone();
			aux.addAll(nodes);
			points.put(key, aux);
		}
	}
	
	public void update2(ArrayList<String> nodes, String next){
		
		if (points.get(next).size() > nodes.size()){
//			ArrayList<String> aux = (ArrayList<String>) nodes.clone();
			points.put(next, nodes);
		}
	}
	
	public void recalc(Point previous, ArrayList<String> nodes){
	
		HashMap<String, ArrayList<String>> aux = previous.getPoints();
		
		for(String key : aux.keySet()){
			ArrayList<String> temp = (ArrayList<String>) aux.get(key).clone();
			temp.addAll(nodes);
			this.update2(temp, key);
		}
	}
	
	
	
	public  String[] dijstra(ArrayList<String>[][] mat, int start, int end)
    {
        String[] dij = new String[mat.length];
        for (int i = 0; i < dij.length; i++)
        {
            dij[i] = "*";
        }

        Boolean b = true;
        while (b)
        {
            for (int i = 0; i < mat.length; i++)
            {
                if (start == i)
                    dij[i] = "" + start;
                else
                {
                    int x = min(i, dij, mat);
                    if (x != 0)
                    {
                        dij[i] = dij[x] + "," + i;
                    }
                }
            }
            if (verificar(dij))
                b = !b;
        }
        return dij;
    }

    public Boolean verificar(String[] dij)
    {
        // TODO Auto-generated method stub
        Boolean b = true;
        for (int i = 0; i < dij.length && b; i++)
        {
            if (dij[i].equals("*"))
            {
                b = false;
            }
        }
        return b;
    }

    public int min(int i, String[] dij, ArrayList<String>[][] mat)
    {
        int m = Integer.MAX_VALUE;
        int r = 0;
        for (int j = 0; j < dij.length; j++)
        {
            if (!mat[i][j].equals(""))
            {
                if (dij[j].split(",").length < m && !dij[j].equals("*"))
                {
                    m = dij[j].split(",").length;
                    r = j;
                }
            }
        }
        return r;
    }
    
    public static ArrayList<String> findRoad(Point start, Point end, HashMap<String, Road> roads){
    	
    	String road1 = null,road2 = null;
    	for(String key:roads.keySet()){
    		if(roads.containsKey(start.getName())){
    			road1 = key;
    			if (roads.containsKey(end.getName())) {
    				road2 = key;
				}
    		}
    		else if (roads.containsKey(end.getName())) {
				road2= key;
			}
    	}
    	
    	Road r1 = roads.get(road1);
    	Road r2 = roads.get(road2);
    	
    	ArrayList<String> aux = new ArrayList<String>();
    	
    	
    	
    	
    	
    	
    	
    	for (String key : r1.getIntersections().keySet()) {
    		
			aux.addAll((ArrayList<String>) r1.getIntersections().get(key).getRoads().keySet());
			
    	}
    	
    	Boolean b = true;
    	
    	while (b){
    		
    		Iterator<String> i = aux.iterator();
    		
    		while(i.hasNext()){
    			
    			String s = i.next();
    			roads.get(s).getIntersections();
    			
    		}
    	}
    	
    }
	
}
