package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DimensionsWindow extends JFrame {
	
	private static JTextField txWidth = new JTextField();
	private static JTextField txHeight = new JTextField();
	private static JTextField txGrindSize = new JTextField();
	
	private JLabel lbWidth;
	private JLabel lbHeight;
	private JLabel lbGrind;
	private static JButton ok_button = new JButton("OK");
	
	private MapWindow map;
	
	public DimensionsWindow (MapWindow map){
		super();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout (4,2));
		this.setSize(400,200);
		this.setResizable(false);
		this.generateInterface();
		this.setVisible(true);
		this.map = map;
		
		
//		principal.setEnabled(false);
	}

	private void generateInterface() {
		
		this.lbWidth = new JLabel ("Width");
		this.lbHeight = new JLabel ("Height");
		this.lbGrind = new JLabel ("Size for the Grid");
		
		DimensionsWindow.txWidth.setSize(100, 40);
		DimensionsWindow.txHeight.setSize(100, 40);
		DimensionsWindow.txGrindSize.setSize(100, 40);
		this.lbWidth.setSize(100, 40);
		this.lbHeight.setSize(100, 40);
		this.lbGrind.setSize(100, 40);
		
		DimensionsWindow.txWidth.setBackground(Theme.background);
		DimensionsWindow.txWidth.setForeground(Theme.foreground);
		DimensionsWindow.txHeight.setBackground(Theme.background);
		DimensionsWindow.txHeight.setForeground(Theme.foreground);
		DimensionsWindow.txGrindSize.setBackground(Theme.background);
		DimensionsWindow.txGrindSize.setForeground(Theme.foreground);
		
		
		this.lbWidth.setBackground(Theme.background);
		this.lbWidth.setForeground(Theme.foreground);
		this.lbHeight.setBackground(Theme.background);
		this.lbHeight.setForeground(Theme.foreground);
		this.lbGrind.setBackground(Theme.background);
		this.lbGrind.setForeground(Theme.foreground);
		
		this.getContentPane().add(lbWidth);
		this.getContentPane().add(txWidth);
		this.getContentPane().add(lbHeight);
		this.getContentPane().add(txHeight);
		this.getContentPane().add(lbGrind);
		this.getContentPane().add(txGrindSize);
		this.getContentPane().add(ok_button);
		
		ok_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				map.newSize(Integer.parseInt(txWidth.getText()), Integer.parseInt(txWidth.getText()), Integer.parseInt(txGrindSize.getText()));
				
			}
		});
		
	}
	
	
	public void setOkActionListener(ActionListener actionListener){
		ok_button.addActionListener(actionListener); 
	}
	
	public int getWidhtSize(){
		return Integer.parseInt(txWidth.getText());
	}
	
	public int getHeightSize() {
		return Integer.parseInt(txHeight.getText());
	}
	
	public int getGrindSize(){
		return Integer.parseInt(txGrindSize.getText());
	}
	
}
