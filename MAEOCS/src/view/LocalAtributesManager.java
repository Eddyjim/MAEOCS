package view;

import model.Category;
import model.Node;

public class LocalAtributesManager {
	
	private Node node;
	
	private AtributesPanel panel;
	
	public LocalAtributesManager(){
		node = null;
		panel = null;
	}
	
	public void selectNode(Node node) {
		this.node = node;
		
	}
	
	public Node getSelectedNode(){
		return node;
	}

	public void addPanel(AtributesPanel panel) {
		this.panel = panel;
	}
	
	public void updatePanel(){
		panel.showValues();
	}
	
	public void enablePanel(){
		panel.enableEdition();
	}

	public void updateLocal(String localName, String localNumber, Category category) {
		node.getLocal().setName(localName);
		node.getLocal().setLocalNumber(localNumber);
		node.getLocal().setCategory(category);
	}

	public void disableEdition() {
		panel.disableEdition();
		
	}

}
