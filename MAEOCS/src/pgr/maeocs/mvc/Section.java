package pgr.maeocs.mvc;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Section {
 
	protected JLabel label;
	 
	private SectionType type;
	
	public Section (){
		this.label = new JLabel("", SwingConstants.CENTER);
		this.label.setFont(new Font("Helvetica", Font.BOLD, 18));
	}
	
	public void setType(SectionType type){
		this.type = type;
	}
	
	public SectionType getType() {
		return type;
	}
	
	public JLabel getLabel() {
		return label;
	}
}
 
