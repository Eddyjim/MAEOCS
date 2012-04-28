package view;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.State;

public class ToolsGraphicsPanel extends JPanel {
 
	private State state;
	 
	private MaeocsMappingApplication maeocsMappingApplication;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton buttonNull;
	
	private Boolean[] connections = new Boolean[8];
	
	public ToolsGraphicsPanel (State state){
		super();
		this.setLayout(new GridLayout (3,3));
		this.state = state;
		this.state.setDirecctions(this);
		this.buttonMatrixCreator();
		for (int i = 0; i < connections.length; i++) {
			connections[i]=false;
		}
		this.createActions();
	}
	
	private void buttonMatrixCreator(){
		button1 = new JButton("N");
		button2 = new JButton("NE");
		button3 = new JButton("E");
		button4 = new JButton("SE");
		button5 = new JButton("S");
		button6 = new JButton("SW");
		button7 = new JButton("W");
		button8 = new JButton("NW");
		buttonNull = new JButton("X");
		
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.WHITE);
		button2.setBackground(Color.BLACK);
		button2.setForeground(Color.WHITE);
		button3.setBackground(Color.BLACK);
		button3.setForeground(Color.WHITE);
		button4.setBackground(Color.BLACK);
		button4.setForeground(Color.WHITE);
		button5.setBackground(Color.BLACK);
		button5.setForeground(Color.WHITE);
		button6.setBackground(Color.BLACK);
		button6.setForeground(Color.WHITE);
		button7.setBackground(Color.BLACK);
		button7.setForeground(Color.WHITE);
		button8.setBackground(Color.BLACK);
		button8.setForeground(Color.WHITE);
		buttonNull.setBackground(Color.BLACK);
		buttonNull.setForeground(Color.WHITE);
		
		buttonNull.setEnabled(false);
		

		
		this.add(button8);
		this.add(button1);
		this.add(button2);
		this.add(button7);
		this.add(buttonNull);
		this.add(button3);
		this.add(button6);
		this.add(button5);
		this.add(button4);

		

	}
	
	public void setConnections(){
		if(state.getMapSectionSelected()!=null)
			this.connections = state.getMapSectionSelected().getConections();
	}
	
	public void createActions (){
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connections[0]){
					connections[0]=false;
					button1.setBackground(Color.BLACK);
					button1.setForeground(Color.WHITE);
				}
				else{
					connections[0]=true;
					button1.setBackground(Color.WHITE);
					button1.setForeground(Color.BLACK);
				}
			}
		});
		button2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(connections[1]){
							connections[1]=false;
							button2.setBackground(Color.BLACK);
							button2.setForeground(Color.WHITE);
						}
						else{
							connections[1]=true;
							button2.setBackground(Color.WHITE);
							button2.setForeground(Color.BLACK);
						}
					}
				});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connections[2]){
					connections[2]=false;
					button3.setBackground(Color.BLACK);
					button3.setForeground(Color.WHITE);
				}
				else{
					connections[2]=true;
					button3.setBackground(Color.WHITE);
					button3.setForeground(Color.BLACK);
				}
			}
		});
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connections[3]){
					connections[3]=false;
					button4.setBackground(Color.BLACK);
					button4.setForeground(Color.WHITE);
				}
				else{
					connections[3]=true;
					button4.setBackground(Color.WHITE);
					button4.setForeground(Color.BLACK);
				}
			}
		});
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connections[4]){
					connections[4]=false;
					button5.setBackground(Color.BLACK);
					button5.setForeground(Color.WHITE);
				}
				else{
					connections[4]=true;
					button5.setBackground(Color.WHITE);
					button5.setForeground(Color.BLACK);
				}
			}
		});
		button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connections[5]){
					connections[5]=false;
					button6.setBackground(Color.BLACK);
					button6.setForeground(Color.WHITE);
				}
				else{
					connections[5]=true;
					button6.setBackground(Color.WHITE);
					button6.setForeground(Color.BLACK);
				}
			}
		});
		button7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connections[6]){
					connections[6]=false;
					button7.setBackground(Color.BLACK);
					button7.setForeground(Color.WHITE);
				}
				else{
					connections[6]=true;
					button7.setBackground(Color.WHITE);
					button7.setForeground(Color.BLACK);
				}
			}
		});
		button8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connections[7]){
					connections[7]=false;
					button8.setBackground(Color.BLACK);
					button8.setForeground(Color.WHITE);
				}
				else{
					connections[7]=true;
					button8.setBackground(Color.WHITE);
					button8.setForeground(Color.BLACK);
				}
			}
		});
	}

	public void paint() {
		
		if(connections[0]){
			button1.setBackground(Color.WHITE);
			button1.setForeground(Color.BLACK);
		}else{
			button1.setBackground(Color.BLACK);
			button1.setForeground(Color.WHITE);
		}
		if(connections[1]){
			button2.setBackground(Color.WHITE);
			button2.setForeground(Color.BLACK);
		}else{
			button2.setBackground(Color.BLACK);
			button2.setForeground(Color.WHITE);
		}
		if(connections[2]){
			button3.setBackground(Color.WHITE);
			button3.setForeground(Color.BLACK);
		}else{
			button3.setBackground(Color.BLACK);
			button3.setForeground(Color.WHITE);
		}
		if(connections[3]){
			button4.setBackground(Color.WHITE);
			button4.setForeground(Color.BLACK);
		}else{
			button4.setBackground(Color.BLACK);
			button4.setForeground(Color.WHITE);
		}
		if(connections[4]){
			button5.setBackground(Color.WHITE);
			button5.setForeground(Color.BLACK);
		}else{
			button5.setBackground(Color.BLACK);
			button5.setForeground(Color.WHITE);
		}
		if(connections[5]){
			button6.setBackground(Color.WHITE);
			button6.setForeground(Color.BLACK);
		}else{
			button6.setBackground(Color.BLACK);
			button6.setForeground(Color.WHITE);
		}
		if(connections[6]){
			button7.setBackground(Color.WHITE);
			button7.setForeground(Color.BLACK);
		}else{
			button7.setBackground(Color.BLACK);
			button7.setForeground(Color.WHITE);
		}
		if(connections[7]){
			button8.setBackground(Color.WHITE);
			button8.setForeground(Color.BLACK);
		}else{
			button8.setBackground(Color.BLACK);
			button8.setForeground(Color.WHITE);
		}
	}
	
	public void setDirecctions(Boolean[] direcctions) {
		// TODO Auto-generated method stub
		
	}

	public Boolean[] getDirecctions() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
 
