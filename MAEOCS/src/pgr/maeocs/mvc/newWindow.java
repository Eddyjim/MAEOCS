package pgr.maeocs.mvc;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class newWindow extends JFrame {
	
	private JTextField txWidth;
	private JTextField txHeight;
	private JTextField txGrilla;
	
	private JLabel lbWidth;
	private JLabel lbHeight;
	private JLabel lbGrilla;
	
	private JFrame principal;
	
	public newWindow (JFrame principal){
		super();
		this.setLayout(new GridLayout (4,2));
		this.principal=principal;
		this.setSize(400,200);
		this.setResizable(false);
		this.generateInterface();
		this.setVisible(true);
		principal.setEnabled(false);
	}

	private void generateInterface() {
		
		this.txWidth = new JTextField ();
		this.txHeight = new JTextField ();
		this.txGrilla = new JTextField ();
		this.lbWidth = new JLabel ("Width");
		this.lbHeight = new JLabel ("Height");
		this.lbGrilla = new JLabel ("Size for the Grid");
		
		this.txWidth.setSize(100, 40);
		this.txHeight.setSize(100, 40);
		this.txGrilla.setSize(100, 40);
		this.lbWidth.setSize(100, 40);
		this.lbHeight.setSize(100, 40);
		this.lbGrilla.setSize(100, 40);
		
		this.txWidth.setBackground(Color.BLACK);
		this.txWidth.setForeground(Color.WHITE);
		this.txHeight.setBackground(Color.BLACK);
		this.txHeight.setForeground(Color.WHITE);
		this.txGrilla.setBackground(Color.BLACK);
		this.txGrilla.setForeground(Color.WHITE);
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
		
	}
	
}
