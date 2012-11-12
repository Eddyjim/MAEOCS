package view;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class ToolsGraphicsPanel extends JPanel {
 
	private State state;
	 
	private MaeocsMappingApplication maeocsMappingApplication;
	private JButton create;
	private JButton modify;
	private JButton delete;
	private JButton compile;
	private JTextPane helpTx;
		
	public ToolsGraphicsPanel (){
		super();
		this.setLayout(new GridLayout (1,2));
		this.controlMatrixCreator();
	}
	
	private void controlMatrixCreator(){
		create = new JButton("Create");
		modify = new JButton("Modify");
		delete = new JButton("Delete");
		compile = new JButton("Compile");
		helpTx = new JTextPane();
		
		helpTx.setText("Help is going to appear\nhere, stay attend XP");
		
		JPanel auxPanel = new JPanel(new GridLayout (1,4));
		
		create.setBackground(Theme.background);
		create.setForeground(Theme.foreground);
		modify.setBackground(Theme.background);
		modify.setForeground(Theme.foreground);
		delete.setBackground(Theme.background);
		delete.setForeground(Theme.foreground);
		compile.setBackground(Theme.background);
		compile.setForeground(Theme.foreground);
		helpTx.setBackground(Theme.background);
		helpTx.setForeground(Theme.foreground);

		this.add(helpTx);
		auxPanel.add(create);
		auxPanel.add(modify);
		auxPanel.add(delete);
		auxPanel.add(compile);
		auxPanel.add(helpTx);
		this.add(auxPanel);
		
	}
	
	public void setCreateBtAction(ActionListener ls){
		create.addActionListener(ls);
	}
	
	public void setModifyBtAction(ActionListener ls){
		create.addActionListener(ls);
	}
	
	public void setDeleteBtAction(ActionListener ls){
		create.addActionListener(ls);
	}
	
	public void setCompileBtAction(ActionListener ls){
		create.addActionListener(ls);
	}
	
	public void setHelpText(ActionListener ls){
		create.addActionListener(ls);
	}
}
 
