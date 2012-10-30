package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.SectionType;

public class TypeCreatorGraphicsPanel extends JPanel {
 
	private State state;
	
	private Boolean pressed;

	private SectionType type;
	
	private JButton nulo;
	private JButton road;
	private JButton point;
	
	public TypeCreatorGraphicsPanel(){
		super();
		this.setLayout(new GridLayout (1,3));
		buttonsSection();
		pressed = false;
	}

	public void buttonsSection (){
		
		
		nulo = new JButton("Nulo");
		road = new JButton("Road");
		point = new JButton("Point");
		
		nulo.setBackground(Color.white);
		road.setBackground(Color.white);
		point.setBackground(Color.white);

		nulo.setBounds(3, 0, 210, 94);
		road.setBounds(3, 215, 210, 94);
		point.setBounds(3, 430, 210, 94);
		
		this.add(nulo);
		this.add(road);
		this.add(point);
		
	}
	
	public void setNuloActionListener(ActionListener ls){
		nulo.addActionListener(ls);	
	}
	
	public void setRoadActionListener(ActionListener ls){
		road.addActionListener(ls);
	}
	
	public void setPointActionListener(ActionListener ls){
		point.addActionListener(ls);
	}
	
}
 
