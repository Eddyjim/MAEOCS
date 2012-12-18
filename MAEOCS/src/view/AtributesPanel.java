package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Category;
import model.Local;

/**
 * This class is used to show and edit the attributes of a local
 * 
 * @author Carlos Gaitan Mora & Edward Jimenez Martinez
 */
@SuppressWarnings("serial")
public class AtributesPanel extends JFrame {
	
	/**
	 * This contains the node that will be modified in this class
	 */
	private LocalAtributesManager node;
	
	/**
	 * Is the label that says "Id"
	 */
	private JLabel lbId;
	
	/**
	 * Is the tetxFiel for the id to be showed
	 */
	private JTextField txId;
	
	/**
	 * Is the label that says "Category"
	 */
	private JLabel lbCategory;
	
	/**
	 * Is the comboBox to select the category
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox cbCategory;
	
	/**
	 * Its the label that says "local Number"
	 */
	private JLabel lbLocalNumber;
	/**
	 * Is the tetxFiel for the local number to be edited
	 */
	private JTextField txLocalNumber;
	
	/**
	 * Is the label that says "Local Name"
	 */
	private JLabel lbLocalName;
	
	/**
	 * Is the tetxFiel for the local name to be edited
	 */
	private JTextField txLocalName;
	
	/**
	 * Is the panel used to organize all components
	 */
	private JPanel panel;
	
	private JButton btApply;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AtributesPanel(LocalAtributesManager node){
		
		this.setTitle("Atributes");
		
		this.setSize(Theme.atributesPanelDimension);
		setLocation(Theme.atributesPanelLocation);
		panel = new JPanel();
		this.add(panel);
		panel.setLayout(new GridLayout(5,2));
		this.node = node;
		
		/*
		 * Create the components
		 */
		lbId = new JLabel("Id");
		lbCategory = new JLabel("Category");
		lbLocalNumber = new JLabel("Local Number");
		lbLocalName = new JLabel("Local Name");
		
		txId = new JTextField();
		txLocalNumber = new JTextField();
		txLocalName = new JTextField();
		cbCategory = new JComboBox();
		
		btApply = new JButton("Apply");
		
		
		/*
		 * Set the controls and backgrounds
		 */
		lbId.setBackground(Theme.background);
		lbId.setForeground(Theme.foreground);
		lbLocalName.setBackground(Theme.background);
		lbLocalName.setForeground(Theme.foreground);
		lbLocalNumber.setBackground(Theme.background);
		lbLocalNumber.setForeground(Theme.foreground);
		lbCategory.setBackground(Theme.background);
		lbCategory.setForeground(Theme.foreground);
		
		cbCategory.setBackground(Theme.background);
		cbCategory.setForeground(Theme.foreground);
		
		btApply.setBackground(Theme.background);
		btApply.setForeground(Theme.foreground);
		
		/*
		 * Add the categories to the comboBox
		 */
		cbCategory.addItem(Category.Restroom); 	//Index 0
		cbCategory.addItem(Category.Restaurant);	//Index 1
		cbCategory.addItem(Category.Shopping);		//Index 2

		txId.setEnabled(false);
		
		setBtApplyListener();
		
		disableEdition();
		
		/*
		 * Add the components to the panel
		 */
		panel.add(lbId);
		panel.add(txId);
		panel.add(lbLocalNumber);
		panel.add(txLocalNumber);
		panel.add(lbLocalName);
		panel.add(txLocalName);
		panel.add(lbCategory);
		panel.add(cbCategory);
		panel.add(btApply);
		
		this.setVisible(true);
		
	}
	
	public void setBtApplyListener(){
		btApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				node.updateLocal(txLocalName.getText(),txLocalNumber.getText(),(Category) cbCategory.getSelectedItem());
				
			}
		});
	}
	
	/**
	 * This method shows all the local's attributes on the panel
	 */
	public void showValues() {
		
		txId.setText(node.getSelectedNode().getId());
		Local local = node.getSelectedNode().getLocal();
		
		if (local != null){
			txLocalName.setText(local.getName());
			txLocalNumber.setText(local.getLocalNumber());
			
			if(local.getCategory() != null){
				switch (local.getCategory()) {
				case Restroom:
					cbCategory.setSelectedIndex(0);
					break;
		
				case Restaurant:
					cbCategory.setSelectedIndex(1);
					break;
					
				case Shopping:
					cbCategory.setSelectedIndex(2);
					break;
				
				default:
					break;
				}
			}
			
		}
		else{
			disableEdition();
		}
	}

	/**
	 * This methods disables all the fields that allow to edit a Local value
	 */
	public void disableEdition() {
		
		txLocalName.setEnabled(false);
		txLocalNumber.setEnabled(false);
		cbCategory.setEnabled(false);
		btApply.setEnabled(false);
		
	}

	/**
	 * This methods enables all the fields that allow to edit a Local value
	 */
	public void enableEdition() {
		
		txLocalName.setEnabled(true);
		txLocalNumber.setEnabled(true);
		cbCategory.setEnabled(true);
		btApply.setEnabled(true);
	}
}
