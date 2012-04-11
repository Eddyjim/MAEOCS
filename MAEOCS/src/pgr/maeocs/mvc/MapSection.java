package pgr.maeocs.mvc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MapSection extends Section {
 
	private Boolean[] connections = new Boolean[8];
	 
	private MaeocsMappingApplication maeocsMappingApplication;
	 	
	private SectionSelectedState panelState;
	
	private MapSection thisMapSection = this;
	
	private DirGraphicsPanel dir;
	
	private boolean selected = false;
	
	public MapSection (SectionSelectedState panel, DirGraphicsPanel diri){
		super();
		this.defineActionListener();
		this.panelState = panel;
		this.dir = diri;
		Border border = LineBorder.createGrayLineBorder();
		label.setBorder(border);
		for (int i = 0; i < connections.length; i++) {
			connections[i]=false;
		}
	}
	
	public Boolean[] getConections() {
		return connections;
	}
	
	private void defineActionListener(){
		final JLabel label = this.getLabel();
		label.addMouseListener( new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
						
			switch (panelState.getToolsState()) {
			case NULL:
				thisMapSection.setType(SectionType.NULL);
				label.setForeground(panelState.getColor());
				label.setText("");
				break;
			
			case ROAD:
				
				thisMapSection.setType(SectionType.ROAD);
				label.setForeground(panelState.getColor());
				label.setText("o");
				break;
				
			case IO:
				
				thisMapSection.setType(SectionType.IO);
				label.setForeground(panelState.getColor());
				label.setText("o");
				break;
				
			case DIRECCTIONS:
				if(thisMapSection.getType().equals(SectionType.ROAD)){
					panelState.setMapSectionSelected(thisMapSection);
					label.setForeground(panelState.getColor());
					dir.rePaintArrows(connections);
				}else{
					panelState.setMapSectionSelected(null);
					dir.paintArrows();
				}
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
}
 
