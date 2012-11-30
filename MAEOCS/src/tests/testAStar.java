package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import model.MapModel;
import model.Node;

import org.junit.Test;

public class testAStar {

	/*	This is the map for all the test
	 * 	x		x		x		x		x		
	 * 	n1		n2		n3		x		x		
	 * 	n4		x		n5		x		x		
	 * 	x		x		n6		n7		x		
	 * 	x		x		n8		x		x		
	 * 	x		x		n9		n10		x		
	 * 	x		n11		n12		x		x		
	 * 
	 */
	
	private MapModel model = new MapModel();
	
	Node n1 = new Node("0,1",new Point(0,1));
	Node n2 = new Node("1,1",new Point(1,1));
	Node n3 = new Node("2,1",new Point(2,1));
	Node n4 = new Node("0,2",new Point(0,2));
	Node n5 = new Node("2,2",new Point(2,2));
	Node n6 = new Node("2,3",new Point(2,3));
	Node n7 = new Node("3,3",new Point(3,3));
	Node n8 = new Node("2,4",new Point(2,4));
	Node n9 = new Node("2,5",new Point(2,5));
	Node n10 = new Node("3,5",new Point(3,5));
	Node n11 = new Node("1,6",new Point(1,6));
	Node n12 = new Node("2,6",new Point(2,6));
	
	@Test
	public void testn1n4() {
		initiate();
		
		ArrayList<String> temp = new ArrayList<String>();
		temp = model.aStar(n1, n4);
		String r=new String("");
		for (int i = 0; i < temp.size(); i++) {
			if (i!=0) {
				r=r+";";
			}
			r = r+temp.get(i);
		}
		
		assertEquals("Result","0,1;0,2",r);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testn1n12() {
		initiate();
		
		ArrayList<String> temp = new ArrayList<String>();
		temp = model.aStar(n1, n12);
		String r=new String("");
		for (int i = 0; i < temp.size(); i++) {
			if (i!=0) {
				r=r+";";
			}
			r = r+temp.get(i);
		}
		
		assertEquals("Result","0,1;1,1;2,1;2,2;2,3;2,4;2,5;2,6",r);
		
		//fail("Not yet implemented");
	}
	
	public void initiate(){
		
		n1.addConnection(n2.getId(), n2);
		n1.addConnection(n4.getId(), n4);
		
		n2.addConnection(n1.getId(), n1);
		n2.addConnection(n3.getId(), n3);
		
		n3.addConnection(n2.getId(), n2);
		n3.addConnection(n5.getId(), n5);
		
		n4.addConnection(n1.getId(), n1);
		
		n5.addConnection(n3.getId(), n3);
		n5.addConnection(n6.getId(), n6);
		
		n6.addConnection(n5.getId(), n5);
		n6.addConnection(n7.getId(), n7);
		n6.addConnection(n8.getId(), n8);
		
		n7.addConnection(n6.getId(), n6);
		
		n8.addConnection(n6.getId(), n6);
		n8.addConnection(n9.getId(), n9);
		
		n9.addConnection(n8.getId(), n8);
		n9.addConnection(n10.getId(), n10);
		n9.addConnection(n12.getId(), n12);
		
		n10.addConnection(n9.getId(), n9);
		
		n11.addConnection(n12.getId(), n12);
		
		n12.addConnection(n9.getId(), n9);
		n12.addConnection(n11.getId(), n11);
		
		model.addNode(n1);
		model.addNode(n2);
		model.addNode(n3);
		model.addNode(n4);
		model.addNode(n5);
		model.addNode(n6);
		model.addNode(n7);
		model.addNode(n8);
		model.addNode(n9);
		model.addNode(n10);
		model.addNode(n11);
		model.addNode(n12);
		
	}

}
