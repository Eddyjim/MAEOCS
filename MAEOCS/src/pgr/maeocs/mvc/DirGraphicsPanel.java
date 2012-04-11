package pgr.maeocs.mvc;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class DirGraphicsPanel extends JPanel{
	
	private SectionSelectedState state;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button buttonNull;
	
	private Boolean[] connections = new Boolean[8];
	
	public DirGraphicsPanel (SectionSelectedState stateI){
		super();
		this.setLayout(new GridLayout (3,3));
		this.state = stateI;
		this.buttonMatrixCreator();
		for (int i = 0; i < connections.length; i++) {
			connections[i]=false;
		}
	}
	
	private void buttonMatrixCreator(){
		button1 = new Button("N");
		button2 = new Button("NE");
		button3 = new Button("E");
		button4 = new Button("SE");
		button5 = new Button("S");
		button6 = new Button("SW");
		button7 = new Button("W");
		button8 = new Button("NW");
		buttonNull = new Button("X");
		
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

	public void rePaintArrows(Boolean[] connections2) {
		
		connections = connections2;
		System.out.println(connections2[0]);
		if(connections2[0]){
			button1.setBackground(Color.WHITE);
			button1.setForeground(Color.BLACK);
		}else{
			button1.setBackground(Color.BLACK);
			button1.setForeground(Color.WHITE);
		}
		if(connections2[1]){
			button2.setBackground(Color.WHITE);
			button2.setForeground(Color.BLACK);
		}else{
			button2.setBackground(Color.BLACK);
			button2.setForeground(Color.WHITE);
		}
		if(connections2[2]){
			button3.setBackground(Color.WHITE);
			button3.setForeground(Color.BLACK);
		}else{
			button3.setBackground(Color.BLACK);
			button3.setForeground(Color.WHITE);
		}
		if(connections2[3]){
			button4.setBackground(Color.WHITE);
			button4.setForeground(Color.BLACK);
		}else{
			button4.setBackground(Color.BLACK);
			button4.setForeground(Color.WHITE);
		}
		if(connections2[4]){
			button5.setBackground(Color.WHITE);
			button5.setForeground(Color.BLACK);
		}else{
			button5.setBackground(Color.BLACK);
			button5.setForeground(Color.WHITE);
		}
		if(connections2[5]){
			button6.setBackground(Color.WHITE);
			button6.setForeground(Color.BLACK);
		}else{
			button6.setBackground(Color.BLACK);
			button6.setForeground(Color.WHITE);
		}
		if(connections2[6]){
			button7.setBackground(Color.WHITE);
			button7.setForeground(Color.BLACK);
		}else{
			button7.setBackground(Color.BLACK);
			button7.setForeground(Color.WHITE);
		}
		if(connections2[7]){
			button8.setBackground(Color.WHITE);
			button8.setForeground(Color.BLACK);
		}else{
			button8.setBackground(Color.BLACK);
			button8.setForeground(Color.WHITE);
		}
	}

	public void paintArrows() {
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
	}

}
