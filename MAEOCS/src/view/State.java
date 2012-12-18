package view;

/**
 * This class is used to know the actual option selected by the user
 * 
 * @author Carlos Gaitán Mora & Edward Jiménez Martínez
 *
 */
public class State {
 	 
	private SelectedState type;
	
	/**
	 * The creator sets the initial state as "Select"
	 */
	public State(){
		type = SelectedState.SELECT;
	}
		 
	/**
	 * This method allows to set a new selected state
	 * @param type is the new SelectedState to be setted
	 */
	public void setStateType(SelectedState type) {
		this.type = type;
	}
	
	/**
	 * This method allows to get the current state selected
	 * @return the current SelectedState
	 */
	public SelectedState getType() {
		return type;
	}

}