package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MapSection {
 
	private State state;
	
	protected Label label;
	
	protected JLabel jlabel;
	
	private SectionType type;
		
	private ImageIcon icon;
	
	
	public MapSection (State state){
		this.label = new Label("", Label.CENTER);
		this.jlabel = new JLabel("", JLabel.CENTER);
		Border border = LineBorder.createGrayLineBorder();
		jlabel.setBorder(border);
		jlabel.setLayout(new GridLayout(1,1));
		jlabel.setOpaque(false);
		this.state = state;
		this.defineActionListener();
		this.type = SectionType.NULL;
	}
	
	
	private void defineActionListener(){
		
		final MapSection thisMapSection = this;
		
		jlabel.addMouseListener( new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				switch (state.getType()) {
				
				case NULL:
					type = SectionType.NULL;
					jlabel.setBackground(new Color(0, 0, 0, 0));
					jlabel.setText("");
					jlabel.setOpaque(false);
					if(jlabel.getComponents().length!=0)
						jlabel.remove(label);
					break;
				
				case ROAD:
					
					type = SectionType.ROAD;
					label.setBackground(state.getColor());
					label.setText("o");
					jlabel.add(label);
					break;
					
				case POINT:
					
					type = SectionType.POINT;
					label.setBackground(state.getColor());
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
	}
	
	public Component getLabel() {
		return jlabel;
	}
	
}