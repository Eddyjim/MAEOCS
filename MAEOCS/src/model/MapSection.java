package model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MapSection {
 
	private State state;
	
	protected JLabel label;
	 
	private SectionType type;
	
	private Boolean[] connections = new Boolean[8];
	
	private ImageIcon icon;
	
	private Boolean pressed = false;
	
	public MapSection (State state){
		this.label = new JLabel("", SwingConstants.CENTER);
		Border border = LineBorder.createGrayLineBorder();
		label.setBorder(border);
		this.defineActionListener();
		this.state = state;
		this.type = SectionType.NULL;
		for (int i = 0; i < connections.length; i++) {
			connections[i]=false;
		}
	}
	
	public Boolean[] getConections() {
		return connections;
	}
	
	private void defineActionListener(){
		
		final MapSection thisMapSection = this;
		
		label.addMouseListener( new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				state.update(thisMapSection);
				state.setDirecctionsState(connections);
				String path = "";  
				URL url;
				
				switch (state.getToolsState().getStateType()) {
				case NULL:
					type = SectionType.NULL;
					label.setIcon(null);
					label.setText("");
					break;
				
				case ROAD:
					if(pressed){
						state.getDirecctions().setDirecctions(connections);
						state.getDirecctions().paint();
					}
					type = SectionType.ROAD;
					path = "/img/road.gif";   
					icon = new ImageIcon(path);
					label.setIcon(icon);
					label.setBackground(Color.WHITE);
					label.setForeground(Color.WHITE);
					label.setText("o");
					connections = state.getDirecctions().getDirecctions();
					pressed=true;
					break;
					
				case IO:
					
					type = SectionType.IO;
					path = "/img/io.gif";  
					url = this.getClass().getResource(path);  
					icon = new ImageIcon(url);
					label.setIcon(icon);
					break;
				
				case IN:
					
					type = SectionType.IN;
					path = "/img/in.gif";  
					url = this.getClass().getResource(path);  
					icon = new ImageIcon(url);
					label.setIcon(icon);
					break;
					
				case OUT:
					
					type = SectionType.OUT;
					path = "/img/out.gif";  
					url = this.getClass().getResource(path);  
					icon = new ImageIcon(url);
					label.setIcon(icon);
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
	
	public JLabel getLabel() {
		return label;
	}
}
 
