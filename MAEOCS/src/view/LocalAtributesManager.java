package view;

import model.Category;
import model.MapModel;
import model.Node;

/**
 * This class allows to communicate all the nodes with the Attributes Panel to be modified
 * 
 * @author Carlos Gaitan Mora & Edward Jimenez Martinez
 */
public class LocalAtributesManager {
	
	/**
	 * It's the node selected
	 */
	private Node node;
	
	/**
	 * Is the panel
	 */
	private AtributesPanel panel;
	
	/**
	 * Is the map model with the directory of locals
	 */
	private MapModel model;
	
	public LocalAtributesManager(){
		node = null;
		panel = null;
	}
	
	/**
	 * This methods allows to set the node in the manager, allowing to modify the data of it
	 * @param node is the Node that is going to be settled
	 */
	public void selectNode(Node node) {
		this.node = node;
		
	}
	
	/**
	 * This is used to return the actual node selected
	 * @return the selected node that is modifiable 
	 */
	public Node getSelectedNode(){
		return node;
	}

	/**
	 * This method allows to set the panel to the manager
	 * @param panel is a JFrame that contains every option to modify a node
	 */
	public void addPanel(AtributesPanel panel) {
		this.panel = panel;
	}
	
	/**
	 * This method allows to update the Attributes panel with the data of the node
	 */
	public void updatePanel(){
		panel.showValues();
	}
	
	/**
	 * This method allows to enable the Attributes panel for edition
	 */
	public void enablePanel(){
		panel.enableEdition();
	}

	/**
	 * This method allows to update the values of the local, with the data on the panel
	 * @param localName contains the new name for the local
	 * @param localNumber contains the new local number for the local
	 * @param category contains the new category for the local
	 */
	public void updateLocal(String localName, String localNumber, Category category) {
		node.getLocal().setName(localName);
		node.getLocal().setLocalNumber(localNumber);
		node.getLocal().setCategory(category);
		model.addLocalToDictionary(node.getId(),localName);
	}

	/**
	 * This method disables the Attributes panel to edit the nodes that not contain a Local
	 */
	public void disableEdition() {
		panel.disableEdition();
		
	}

	/**
	 * This method allows to set a model on the manager
	 * @param model
	 */
	public void setModel(MapModel model) {
		this.model = model;		
	}

}
