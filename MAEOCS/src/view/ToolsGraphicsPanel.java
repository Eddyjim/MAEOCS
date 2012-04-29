package view;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.State;

public class ToolsGraphicsPanel extends JPanel {
 
	private State state;
	 
	private MaeocsMappingApplication maeocsMappingApplication;
	private JButton create;
	private JButton modify;
	private JButton delete;
	private JButton compile;
	private JTextArea helpTx;
		
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
		helpTx = new JTextArea("Help is going to appear here, stay attend XP");
		
		JPanel auxPanel = new JPanel(new GridLayout (1,4));
		
		create.setBackground(Color.BLACK);
		create.setForeground(Color.WHITE);
		modify.setBackground(Color.BLACK);
		modify.setForeground(Color.WHITE);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		compile.setBackground(Color.BLACK);
		compile.setForeground(Color.WHITE);
		helpTx.setBackground(Color.BLACK);
		helpTx.setForeground(Color.WHITE);

		this.add(helpTx);
		this.add(auxPanel);
		auxPanel.add(create);
		auxPanel.add(modify);
		auxPanel.add(modify);
		auxPanel.add(helpTx);
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
 
