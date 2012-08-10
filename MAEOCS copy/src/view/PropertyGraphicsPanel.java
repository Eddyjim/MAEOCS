package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.State;

public class PropertyGraphicsPanel extends JPanel {
	
	private State state;
	 
	private MaeocsMappingApplication maeocsMappingApplication;
	private JButton createBt;
	private JTextField nameTx;
	private JLabel nameLb;
	private JButton colorBt;
	private Label colorLb;
	private JButton fontBt;
	private JTextField fontTx;
	
	
	public PropertyGraphicsPanel (){
		super();
		this.setLayout(new GridLayout (4,2));
		this.controlsMatrixCreator();
	}
	
	private void controlsMatrixCreator(){
		createBt = new JButton("Create");
		nameTx = new JTextField ();
		nameLb = new JLabel("Name", JLabel.CENTER);
		colorBt = new JButton("Color");
		colorLb = new Label();
		fontBt = new JButton("Font");
		fontTx = new JTextField("1");
				
		createBt.setBackground(Color.WHITE);
		createBt.setForeground(Color.BLACK);
		nameTx.setBackground(Color.WHITE);
		nameTx.setForeground(Color.BLACK);
		nameLb.setBackground(Color.WHITE);
		nameLb.setForeground(Color.BLACK);
		colorBt.setBackground(Color.WHITE);
		colorBt.setForeground(Color.BLACK);
		colorLb.setBackground(Color.WHITE);
		colorLb.setForeground(Color.BLACK);
		fontBt.setBackground(Color.WHITE);
		fontTx.setForeground(Color.BLACK);
				
		this.add(nameLb);
		this.add(nameTx);
		this.add(colorBt);
		this.add(colorLb);
		this.add(fontBt);
		this.add(fontTx);
		this.add(createBt);		
	}
		
	public void setColorBtAction (ActionListener ls){
		
		this.colorBt.addActionListener(ls);
		/*
	    Color bgColor
	      = JColorChooser.showDialog(this,
	                                 "Choose Background Color",
	                                 getBackground());
	    if (bgColor != null)
	      getContentPane().setBackground(bgColor);
	    */
		
	}
	
	public void setFontBtAction (ActionListener ls){
		this.colorBt.addActionListener(ls);
	}
	
	public void setCreateBtAction (ActionListener ls){
		this.createBt.addActionListener(ls);
	}
	
	public void setLabelColor(Color color){
		colorLb.setBackground(color);
	}
}
