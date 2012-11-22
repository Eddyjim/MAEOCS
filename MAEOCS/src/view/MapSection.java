package view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;


//import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.Local;
import model.MapModel;
import model.Node;

/**
 * This class is used at every square made in the panel's grid,
 * it contains all the actions performed over every cell 
 * 
 * @author Carlos Gaitán Mora & Edward Jiménez Martínez
 *
 */
@SuppressWarnings("serial")
public class MapSection extends JLabel{
 
	private State state;
	
	private LocalAtributesManager atributesPanelManager;
	
	private MapModel model;
	
	private PointType type;
		
//	private ImageIcon icon;
	
	private Node node;

	private int posX;
	
	private int posY;
	
	public MapSection (State state, LocalAtributesManager panel, int x, int y, MapModel model){
		
		super();
		
		Border border = LineBorder.createGrayLineBorder();
		this.setVisible(true);
		setBorder(border);
		setLayout(new GridLayout(1,1));
		setOpaque(false);
		
		this.model = model;
		
		this.atributesPanelManager = panel;
		this.state = state;
		this.setActionListener();
		this.type = PointType.NULL;
		this.posX = x;
		this.posY = y;
		
	}
	
	
	private void setActionListener(){
		
//		final MapSection thisMapSection = this;
		
		addMouseListener( new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (node == null){
					
					String name = ""+posX+","+posY;
					node = new Node(name, new Point(posX,posY));
					model.addNode(name, node);
				}
					
				/**
				 * Find all the adjacent nodes that have not been added
				 */
				ArrayList<Node> connections = model.getNotConnectedNeighbors(node);
				Iterator<Node> i = connections.iterator();
				
				/**
				 * Adds all the adjacent nodes that have not been added in the model
				 */
				while (i.hasNext()) {
					Node n = i.next();
					if (!n.equals(null))
						n.addConnection(node.getId(), node);
						node.addConnection(n.getId(), n);
				}
				
				setOpaque(true);
				
				atributesPanelManager.selectNode(node);
				
				switch (state.getType()) {
				
					case SELECT:
						
						break;
					
					case ROAD:
						
						if(!type.equals(PointType.ROAD)){
							
							setBackground(Theme.roadColor);
						}
						
					break;
						
					case LOCAL:
						
						node.setLocal(new Local());
						type = PointType.LOCAL;
						setBackground(Theme.localColor);
						atributesPanelManager.enablePanel();
						atributesPanelManager.updatePanel();
						
						break;
					
					case STAIRS:
						
						type = PointType.STAIRS;
						setBackground(Theme.stairsColor);
						
						break;
					
					case EXIT:
						
						type = PointType.EXIT;
						setBackground(Theme.exitColor);
					
						break;
					
					case ERASE:
					
						type = PointType.NULL;
						setBackground(null);
						model.remove(node);
						atributesPanelManager.selectNode(null);
						node = null;
						
						break;
					
				}
			}
	
			@Override
			public void mousePressed(MouseEvent e) {
				;
			}
	
			@Override
			public void mouseReleased(MouseEvent e) {
				;
			}
	
			@Override
			public void mouseEntered(MouseEvent e) {
				;
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				;
			}
		});
	}


	public Component getLabel() {
		return this;
	}
	
}