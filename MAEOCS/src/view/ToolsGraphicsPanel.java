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
		
		create.setBackground(Color.WHITE);
		create.setForeground(Color.BLACK);
		modify.setBackground(Color.WHITE);
		modify.setForeground(Color.BLACK);
		delete.setBackground(Color.WHITE);
		delete.setForeground(Color.BLACK);
		compile.setBackground(Color.WHITE);
		compile.setForeground(Color.BLACK);
		helpTx.setBackground(Color.WHITE);
		helpTx.setForeground(Color.BLACK);

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
 
