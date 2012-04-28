package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.SectionType;
import model.State;

public class TypeCreatorGraphicsPanel extends JPanel {
 
	private State state;
	 
	private MaeocsMappingApplication maeocsMappingApplication;
	
	private Boolean pressed;

	private SectionType type;
	
	public TypeCreatorGraphicsPanel(MaeocsMappingApplication map){
		super();
		this.maeocsMappingApplication = map;
		buttonsSection();
		pressed = false;
	}

	public void buttonsSection (){
		final JButton nulo = new JButton("nulo");
		final JButton road = new JButton("road");
		final JButton io = new JButton("io");
		final JButton directions = new JButton("dir");
		
		nulo.setBackground(Color.white);
		road.setBackground(Color.white);
		io.setBackground(Color.white);
		directions.setBackground(Color.white);

		nulo.setBounds(3, 0, 210, 94);
		road.setBounds(3, 215, 210, 94);
		io.setBounds(3, 430, 210, 94);
		directions.setBounds(3, 645, 210, 94);
		
		nulo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					maeocsMappingApplication.setEnabled(false);
					maeocsMappingApplication.setEnabled(true);
					io.setEnabled(true);
					directions.setEnabled(true);
					pressed= !pressed;
				}
				else{
					maeocsMappingApplication.setEnabled(true);
					road.setEnabled(false);
					io.setEnabled(false);
					directions.setEnabled(false);
					state.setToolsState(SectionType.NULL);
					pressed= !pressed;
				}
			}
		});
		
		road.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					maeocsMappingApplication.setEnabled(false);
					maeocsMappingApplication.setMapEnabled(false);
					nulo.setEnabled(true);
					io.setEnabled(true);
					directions.setEnabled(true);
					pressed= !pressed;
				}
				else{
					maeocsMappingApplication.setEnabled(true);
					maeocsMappingApplication.setMapEnabled(true);
					nulo.setEnabled(false);
					io.setEnabled(false);
					directions.setEnabled(false);
					state.setToolsState(SectionType.ROAD);
					pressed= !pressed;
				}
			}
		});
		
		io.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					maeocsMappingApplication.setEnabled(false);
					nulo.setEnabled(true);
					road.setEnabled(true);
					directions.setEnabled(true);
					pressed= !pressed;
				}
				else{
					maeocsMappingApplication.setEnabled(true);
					nulo.setEnabled(false);
					road.setEnabled(false);
					directions.setEnabled(false);
					state.setToolsState(SectionType.IO);
					pressed= !pressed;
				}
			}
		});
		
		directions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pressed){
					maeocsMappingApplication.setEnabled(false);
					nulo.setEnabled(true);
					io.setEnabled(true);
					road.setEnabled(true);
					state.getDirecctions().setEnabled(false);
					pressed= !pressed;
				}
				else{
					maeocsMappingApplication.setEnabled(true);
					nulo.setEnabled(false);
					io.setEnabled(false);
					road.setEnabled(false);
					state.getDirecctions().setEnabled(true);
					pressed= !pressed;
				}
			}
		});
		
		this.add(nulo);
		this.add(road);
		this.add(io);
		this.add(directions);
		
	}
	
	public void setState (State state){
		this.state = state;
		state.setTools(this);
	}
	
	public void setStateType(SectionType type) {
		this.type = type;
	}

	public SectionType getStateType() {
		return type;
	}
}
 
