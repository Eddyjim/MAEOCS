package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is used to show and edit the attributes of a local
 * 
 * @author Carlos Gaitan Mora & Edward Jimenez Martinez
 */
public class AtributesPanel extends JFrame {
	/**
	 * 
	 */
	private JLabel lbId;
	
	private JTextField txId;
	
	private JLabel lbCategory;
	
	private JComboBox cbCategory;
	
	private JLabel lbLocalNumber;
	
	private JTextField txLocalNumber;
	
	private JLabel lbLocalName;
	
	private JTextField txLocalName;
	
	private JPanel panel;
	
	private JButton applyBt;
	
	public AtributesPanel(){
		
		this.setTitle("Atributes");
		
		this.setSize(Theme.atributesPanelDimension);
		setLocation(Theme.atributesPanelLocation);
		panel = new JPanel();
		this.add(panel);
		panel.setLayout(new GridLayout(4,2));
		
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
		
		applyBt = new JButton("Apply");
		
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
		
		/*
		 * Add the categories to the comboBox
		 */
		cbCategory.addItem("Restroom");
		cbCategory.addItem("Restaurant");
		cbCategory.addItem("Shoping");

		txId.setEnabled(false);
		
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
		
		this.setVisible(true);
	
	}
	
	
	
}
