package view;

/**
 * This class is used to know the actual option selected by the user
 * 
 * @author Carlos Gaitán Mora & Edward Jiménez Martínez
 *
 */
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