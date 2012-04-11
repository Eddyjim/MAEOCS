package pgr.maeocs.mvc;

import java.awt.Color;

public class SectionSelectedState {
	
	private SectionType toolsState;
	private Color color;
	private MapSection mapSectionSelected;
	
	public SectionSelectedState(){
		this.toolsState = SectionType.NULL;
		this.color = Color.RED;
		this.mapSectionSelected = null;
	}
	
	public void setToolsState(SectionType state) {
		this.toolsState = state;
	}
	
	public SectionType getToolsState() {
		return toolsState;
	}
		
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setMapSectionSelected(MapSection mapSectionSelected) {
		this.mapSectionSelected = mapSectionSelected;
	}
	
	public MapSection getMapSectionSelected() {
		return mapSectionSelected;
	}

}
