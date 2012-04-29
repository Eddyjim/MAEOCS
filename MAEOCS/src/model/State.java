package model;

import java.awt.Color;

import javax.swing.AbstractButton;

import model.Observer;
import view.ToolsGraphicsPanel;
import view.MapGraphicsPanel;
import view.TypeCreatorGraphicsPanel;

public class State {
 	 
	private SectionType type;
	 
	private Color color;
	
	public State(){
		type = SectionType.NULL;
		color = null;
	}
		 
	public void setStateType(SectionType type) {
		this.type = type;
	}
	 
	public void setActualColor(Color color) {
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public SectionType getType() {
		return type;
	}

}