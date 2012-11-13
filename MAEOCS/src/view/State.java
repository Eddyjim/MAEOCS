package view;

import java.awt.Color;

import javax.swing.AbstractButton;

import model.Observer;

public class State {
 	 
	private SelectedState type;
	 
	private Color color;
	
	public State(){
		type = SelectedState.SELECT;
		color = null;
	}
		 
	public void setStateType(SelectedState type) {
		this.type = type;
	}
	 
	public void updateColor(Color color) {
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public SelectedState getType() {
		return type;
	}

}