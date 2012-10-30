package view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.Node;
import model.SectionType;

public class MapSection {
 
	private State state;
	
	protected Label label;
	
	protected JLabel jlabel;
	
	private SectionType type;
		
	private ImageIcon icon;

	private JLabel jlabelVacia;
	
	private int posI;
	
	private int posJ;
	
	private Node node;
	
	
	public MapSection (State state, int i, int j){
		this.label = new Label("", Label.CENTER);
		this.jlabel = new JLabel();
		this.jlabelVacia = new JLabel();
		Border border = LineBorder.createGrayLineBorder();
		jlabel.setBorder(border);
		jlabel.setLayout(new GridLayout(1,1));
		jlabel.setOpaque(false);
		this.state = state;
		this.defineActionListener();
		this.type = SectionType.NULL;
		this.posI = i;
		this.posJ = j;
	}
	
	public void setNode(Node node){
		this.node=node;
	}
	
	public Node getNode(){
		return node;
	}
	
	
	private void defineActionListener(){
		
		final MapSection thisMapSection = this;
		
		jlabel.addMouseListener( new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				switch (state.getType()) {
				
				case NULL:
					;
					break;
				
				case ROAD:
					
					type = SectionType.ROAD;
					label.setBackground(state.getColor());
					jlabel.setText("o");
					label.setText("o");
					jlabel.add(label);
					
					break;
					
				case POINT:
					
					type = SectionType.POINT;
					label.setBackground(state.getColor());
					jlabel.setText("p");
					label.setText("p");
					jlabel.add(label);
					break;
				
					
				default:
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
		
		label.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (state.getType()) {
				
				case NULL:
					jlabel.setText("");
					jlabel.removeAll();
					break;
				
				case ROAD:
					
					type = SectionType.ROAD;
					label.setBackground(state.getColor());
					jlabel.setText("o");
					label.setText("o");
					break;
					
				case POINT:
					
					type = SectionType.POINT;
					label.setBackground(state.getColor());
					jlabel.setText("p");
					label.setText("p");
					break;
				
					
				default:
					break;
			
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}			
		});
	}
	
	public Component getLabel() {
		return jlabel;
	}
	
}