package model;

import java.awt.Color;

import javax.swing.AbstractButton;

import model.Observer;
import view.DirectionGraphicsPanel;
import view.MapGraphicsPanel;
import view.TypeCreatorGraphicsPanel;

public class State implements Observer {
 	 
	private TypeCreatorGraphicsPanel toolsGraphicsPanel;
	 
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
	public void update(TypeCreatorGraphicsPanel M) {
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

	public TypeCreatorGraphicsPanel getToolsState() {
		return this.toolsGraphicsPanel;
	}
	
	public void setToolsState(SectionType type) {
		this.toolsGraphicsPanel.setStateType(type);
	}

	public void setTools(TypeCreatorGraphicsPanel toolsGraphicsPanel) {
		this.toolsGraphicsPanel = toolsGraphicsPanel;
		
	}

	public void setDirecctions(DirectionGraphicsPanel directionGraphicsPanel) {
		this.directionGraphicsPanel = directionGraphicsPanel;		
	}

}