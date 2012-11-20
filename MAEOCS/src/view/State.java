package view;

import java.awt.Color;

import javax.swing.AbstractButton;

import model.Observer;

public class State {
 	 
	private SelectedState type;
	 
	public State(){
		type = SelectedState.SELECT;
	}
		 
	public void setStateType(SelectedState type) {
		this.type = type;
	}
	
	public SelectedState getType() {
		return type;
	}

}