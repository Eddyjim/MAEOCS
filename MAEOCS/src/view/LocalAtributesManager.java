package view;

import model.Node;

public class LocalAtributesManager {
	
	private Node node;
	
	private AtributesPanel panel;
	
	public LocalAtributesManager(){
		node = null;
		panel = null;
	}
	
	public void selectNode(Node node) {
		if (node==null) {
			System.out.println("nulo");
		}
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
		panel.setEnabled(true);
	}

}
