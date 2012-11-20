package view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.MapModel;
import model.Node;

public class MapSection extends JLabel{
 
	private State state;
	
	//protected Label label;
	
	private PointType type;
		
	private ImageIcon icon;
	
	private Node node;

	//private JLabel empyLabel;
	
	private int posI;
	
	private int posJ;
	
	public MapSection (State state, int i, int j, MapModel model){
		
		super();
		//this.label = new Label("", Label.CENTER);
		//this.empyLabel = new JLabel();
		Border border = LineBorder.createGrayLineBorder();
		this.setVisible(true);
		setBorder(border);
		setLayout(new GridLayout(1,1));
		setOpaque(true);
		
		this.state = state;
		this.setActionListener();
		this.type = PointType.NULL;
		this.posI = i;
		this.posJ = j;
		
	}
	
	
	private void setActionListener(){
		
		final MapSection thisMapSection = this;
		
		addMouseListener( new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				switch (state.getType()) {
				
					case SELECT:
						
						break;
					
					case ROAD:
						
						type = PointType.ROAD;
						setBackground(Theme.roadColor);
						node = new Node(""+posI+","+posJ, new Point(posI,posJ));
						
						
					break;
						
					case LOCAL:
						
						type = PointType.LOCAL;
						setBackground(Theme.localColor);
						//label.setBackground(Theme.localColor);
						
						//add(label);
					
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
						setBackground(Theme.background);
				
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
		
//		label.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				switch (state.getType()) {
//				
//				case SELECT:
//					break;
//				
//				case ROAD:
//					
//					type = PointType.ROAD;
//					label.setBackground(Theme.roadColor);
//					break;
//					
//				case LOCAL:
//					
//					type = PointType.LOCAL;
//					label.setBackground(Theme.localColor);
//					break;
//				
//					
//				default:
//					break;
//			
//				}
//			}
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}			
//		});
	}


	public Component getLabel() {
		return this;
	}
	
}