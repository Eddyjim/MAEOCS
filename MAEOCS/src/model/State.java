package model;

import java.awt.Color;

import javax.swing.AbstractButton;

import model.Observer;
import view.DirectionGraphicsPanel;
import view.MapGraphicsPanel;
import view.ToolsGraphicsPanel;

public class State implements Observer {
 	 
	private ToolsGraphicsPanel toolsGraphicsPanel;
	 
	private MapGraphicsPanel mapGraphicsPanel;
	 
	private DirectionGraphicsPanel directionGraphicsPanel;
	
	private MapSection mapSection;
		 
	public void setMapSectionSelected(MapSection mapSectionSelected) {
		this.mapSection = mapSectionSelected;
	}
	 
	public MapSection getMapSectionSelected() {
		return this.mapSection;
	}
	 
	public void setDirecctionsState(Boolean[] direcctions) {
		this.directionGraphicsPanel.setDirecctions(direcctions);
		this.directionGraphicsPanel.paint();
	}
	 
	public Boolean[] getDirecctionsState() {
		return this.directionGraphicsPanel.getDirecctions();
	}

	@Override
	public void update(ToolsGraphicsPanel M) {
		this.toolsGraphicsPanel = M;		
	}

	@Override
	public void update(MapSection M) {
		this.mapSection = M;
	}

	@Override
	public void update(DirectionGraphicsPanel M) {
		this.directionGraphicsPanel = M;
	}

	public DirectionGraphicsPanel getDirecctions() {
		return this.directionGraphicsPanel;
	}

	public ToolsGraphicsPanel getToolsState() {
		return this.toolsGraphicsPanel;
	}
	
	public void setToolsState(SectionType type) {
		this.toolsGraphicsPanel.setStateType(type);
	}

	public void setTools(ToolsGraphicsPanel toolsGraphicsPanel) {
		this.toolsGraphicsPanel = toolsGraphicsPanel;
		
	}

	public void setDirecctions(DirectionGraphicsPanel directionGraphicsPanel) {
		this.directionGraphicsPanel = directionGraphicsPanel;		
	}

}