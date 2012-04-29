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
	
	private Boolean pressed;

	private SectionType type;
	
	public TypeCreatorGraphicsPanel(MaeocsMappingApplication map){
		super();
		buttonsSection();
		pressed = false;
	}

	public void buttonsSection (){
		final JButton nulo = new JButton("nulo");
		final JButton road = new JButton("road");
		final JButton io = new JButton("io");
		
		nulo.setBackground(Color.white);
		road.setBackground(Color.white);
		io.setBackground(Color.white);
		directions.setBackground(Color.white);

		nulo.setBounds(3, 0, 210, 94);
		road.setBounds(3, 215, 210, 94);
		io.setBounds(3, 430, 210, 94);
		directions.setBounds(3, 645, 210, 94);
		
	}
}
 
