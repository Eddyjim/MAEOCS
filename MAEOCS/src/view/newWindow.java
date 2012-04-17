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

public class newWindow extends JFrame {
	
	private static JTextField txWidth = new JTextField();
	private static JTextField txHeight = new JTextField();
	private static JTextField txGrilla = new JTextField();
	
	private JLabel lbWidth;
	private JLabel lbHeight;
	private JLabel lbGrilla;
	private static JButton ok_button = new JButton("OK");
	
	private JFrame principal;
	
	public newWindow (JFrame principal){
		super();
		this.setLayout(new GridLayout (4,2));
		this.principal=principal;
		this.setSize(400,200);
		this.setResizable(false);
		this.generateInterface();
		this.setVisible(true);
		
		
//		principal.setEnabled(false);
	}

	private void generateInterface() {
		
		this.lbWidth = new JLabel ("Width");
		this.lbHeight = new JLabel ("Height");
		this.lbGrilla = new JLabel ("Size for the Grid");
		
		newWindow.txWidth.setSize(100, 40);
		newWindow.txHeight.setSize(100, 40);
		newWindow.txGrilla.setSize(100, 40);
		this.lbWidth.setSize(100, 40);
		this.lbHeight.setSize(100, 40);
		this.lbGrilla.setSize(100, 40);
		
		newWindow.txWidth.setBackground(Color.BLACK);
		newWindow.txWidth.setForeground(Color.WHITE);
		newWindow.txHeight.setBackground(Color.BLACK);
		newWindow.txHeight.setForeground(Color.WHITE);
		newWindow.txGrilla.setBackground(Color.BLACK);
		newWindow.txGrilla.setForeground(Color.WHITE);
		this.lbWidth.setBackground(Color.BLACK);
		this.lbWidth.setForeground(Color.WHITE);
		this.lbHeight.setBackground(Color.BLACK);
		this.lbHeight.setForeground(Color.WHITE);
		this.lbGrilla.setBackground(Color.BLACK);
		this.lbGrilla.setForeground(Color.WHITE);
		
		this.getContentPane().add(lbWidth);
		this.getContentPane().add(txWidth);
		this.getContentPane().add(lbHeight);
		this.getContentPane().add(txHeight);
		this.getContentPane().add(lbGrilla);
		this.getContentPane().add(txGrilla);
		this.getContentPane().add(ok_button);
		
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
	
	public int getGrind(){
		return Integer.parseInt(txGrilla.getText());
	}
	
}
