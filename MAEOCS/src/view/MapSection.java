package view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
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
 * @author Carlos Gait�n Mora & Edward Jim�nez Mart�nez
 *
 */
@SuppressWarnings("serial")
public class MapSection extends JLabel implements Serializable{
 
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
		
		addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				atributesPanelManager.disableEdition();
				if (node == null){
					
					String id = ""+posX+","+posY;
					node = new Node(id, new Point(posX,posY));
					model.addNode(node);
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
						if (!n.equals(null)){
							n.addConnection(node.getId(), node);
							node.addConnection(n.getId(), n);
						}
					}	
				
				
				setOpaque(true);
				
				atributesPanelManager.selectNode(node);
				
				switch (state.getType()) {
				
					case SELECT:
						if(!type.equals(PointType.NULL)){
							atributesPanelManager.enablePanel();
							atributesPanelManager.updatePanel();
						}
						break;
					
					case ROAD:
						
						if(!type.equals(PointType.ROAD)){
							if (type.equals(PointType.LOCAL))
								node.setLocal(null);
							setBackground(Theme.roadColor);
							type = PointType.ROAD;
							node.setType(type);
						}
						
						break;
						
					case LOCAL:
						
						if(!type.equals(PointType.LOCAL)){
							node.setLocal(new Local());
							type = PointType.LOCAL;
							node.setType(type);
							setBackground(Theme.localColor);
							atributesPanelManager.enablePanel();
							atributesPanelManager.updatePanel();
						}
						
						break;
					
					case STAIRS:
						
						if(!type.equals(PointType.STAIRS)){
							if (type.equals(PointType.LOCAL))
								node.setLocal(null);
							type = PointType.STAIRS;
							node.setType(type);
							setBackground(Theme.stairsColor);
						}
						break;
					
					case EXIT:
						
						if(!type.equals(PointType.EXIT)){
							if (type.equals(PointType.LOCAL))
								node.setLocal(null);
							type = PointType.EXIT;
							node.setType(type);
							setBackground(Theme.exitColor);
						}
						
						break;
					
					case ERASE:
					
						if(!type.equals(PointType.NULL)){
							
							setBackground(null);
							setOpaque(false);
							model.remove(node);
							if (type.equals(PointType.LOCAL))
								model.removeFromLocalDictionary(node.getLocal().getName());
							type = PointType.NULL;
							node.setType(type);
							atributesPanelManager.selectNode(null);
							node = null;
						}
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

	public PointType getPointType(){
		return type;
	}
	
	public void setType(PointType type) {
		this.type = type;
	}
	
	public Component getLabel() {
		return this;
	}
	
	public void setNode(Node node){
		this.node = node;
		
		switch (node.getType()) {
		case ROAD:
			this.type = PointType.ROAD;
			setBackground(Theme.roadColor);
			setOpaque(true);
			break;
		case EXIT:
			this.type = PointType.EXIT;
			setBackground(Theme.exitColor);
			setOpaque(true);
			break;
		case LOCAL:
			this.type = PointType.LOCAL;
			setBackground(Theme.localColor);
			setOpaque(true);
			break;
		case STAIRS:
			this.type = PointType.STAIRS;
			setBackground(Theme.stairsColor);
			setOpaque(true);
			break;
		default:
			break;
		
		}
	}
}