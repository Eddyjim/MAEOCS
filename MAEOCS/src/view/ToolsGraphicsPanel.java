package view;


import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * This class contains all the tools available to be selected to edit the map
 * 
 * @author Carlos Gaitán Mora & Edward Jiménez Martínez
 */
public class ToolsGraphicsPanel extends JFrame {
	/**
	 * This class contains all the tools available for the map's edition
	 */
	private static final long serialVersionUID = -5539159538499332789L;

	private JPanel panel;

	private JButton select;
	private JButton road;
	private JButton local;
	private JButton stairs;
	private JButton exit;
	private JButton erase;
	private JTextPane helpTx;
		
	public ToolsGraphicsPanel (){
		super();
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,1));
		this.add(panel);
		this.setLocation(Theme.toolBarLocation);
		this.showTools();
		
	}
	
	/**
	 * Creates and shows all the options available
	 */
	private void showTools(){
		
		select = new JButton("Select");
		road = new JButton("Road");
		local = new JButton("Local");
		stairs = new JButton("stairs");
		exit = new JButton("Exit");
		erase = new JButton("Erase");
		helpTx = new JTextPane();
		
		helpTx.setText("Help is going to appear\nhere, stay attend XP");
		
		
		select.setBackground(Theme.background);
		select.setForeground(Theme.foreground);
		road.setBackground(Theme.background);
		road.setForeground(Theme.foreground);
		local.setBackground(Theme.background);
		local.setForeground(Theme.foreground);
		stairs.setBackground(Theme.background);
		stairs.setForeground(Theme.foreground);
		exit.setBackground(Theme.background);
		exit.setForeground(Theme.foreground);
		erase.setBackground(Theme.background);
		erase.setForeground(Theme.foreground);
		helpTx.setBackground(Theme.background);
		helpTx.setForeground(Theme.foreground);
		
		
		this.setSize(Theme.toolBarDimension);
		select.setSize(Theme.toolIconDimension);
		road.setSize(Theme.toolIconDimension);
		local.setSize(Theme.toolIconDimension);
		stairs.setSize(Theme.toolIconDimension);
		exit.setSize(Theme.toolIconDimension);
		erase.setSize(Theme.toolIconDimension);
		
		
		
		panel.add(new JLabel("Tools"));
		panel.add(select);
		panel.add(road);
		panel.add(local);
		panel.add(stairs);
		panel.add(exit);
		panel.add(erase);

		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	/**
	 * Set an action listener in "Select" button
	 * @param ls is the acctionListener to be setted
	 */
	public void setSelectBtAction(ActionListener ls){
		select.addActionListener(ls);
	}
	
	/**
	 * Set an action listener in "Road" button
	 * @param ls is the acctionListener to be setted
	 */
	public void setRoadBtAction(ActionListener ls){
		road.addActionListener(ls);
	}
	
	/**
	 * Set an action listener in "Local" button
	 * @param ls is the acctionListener to be setted
	 */
	public void setLocalBtAction(ActionListener ls){
		local.addActionListener(ls);
	}
	
	/**
	 * Set an action listener in "Stairs" button
	 * @param ls is the acctionListener to be setted
	 */
	public void setStairsBtAction(ActionListener ls){
		stairs.addActionListener(ls);
	}
	
	/**
	 * Set an action listener in "Exit" button
	 * @param ls is the acctionListener to be setted
	 */
	public void setExitBtAction(ActionListener ls){
		exit.addActionListener(ls);
	}
	
	/**
	 * Set an action listener in "Erase" button
	 * @param ls is the acctionListener to be setted
	 */
	public void setEraseBtAction(ActionListener ls){
		erase.addActionListener(ls);
	}
}
 
