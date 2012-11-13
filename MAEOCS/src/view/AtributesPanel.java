package view;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AtributesPanel extends JFrame {
	
	private JLabel lbName;
	private JTextField txName;
	private JLabel lbCategory;
	private JComboBox cbCategory;
	private JPanel panel;
	
	public AtributesPanel(){
		
		
		this.setTitle("Atributes");
		
		this.setSize(Theme.atributesPanelDimension);
		panel = new JPanel();
		this.add(panel);
		panel.setLayout(new GridLayout(2,2));
		
		lbName = new JLabel("Name");
		lbCategory = new JLabel("Category");
		txName = new JTextField();
		cbCategory = new JComboBox();
		
		
		lbName.setBackground(Theme.background);
		lbName.setForeground(Theme.foreground);
		lbCategory.setBackground(Theme.background);
		lbCategory.setForeground(Theme.foreground);
		cbCategory.setBackground(Theme.background);
		cbCategory.setForeground(Theme.foreground);
		
		cbCategory.addItem("Restroom");
		cbCategory.addItem("Restaurant");
		cbCategory.addItem("Shoping");
	
		panel.add(lbName);
		panel.add(txName);
		panel.add(lbCategory);
		panel.add(cbCategory);
		
		this.setVisible(true);
	}
	
	
	 
}
