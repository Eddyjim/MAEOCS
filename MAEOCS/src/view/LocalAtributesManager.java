package view;

import java.nio.channels.FileChannel.MapMode;
import java.util.Dictionary;

import model.Category;
import model.MapModel;
import model.Node;

public class LocalAtributesManager {
	
	private Node node;
	
	private AtributesPanel panel;
	
	private MapModel model;
	
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
		model.addLocalToDictionary(node.getId(),localName);
	}

	public void disableEdition() {
		panel.disableEdition();
		
	}

	public void setModel(MapModel model) {
		this.model = model;		
	}

}
