package view;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWindow extends JFrame{
	
	private MapPanel map;
	private Dimension mapDimension;
	private DimensionsWindow dimensionWindow;
	private String imgFile;
	
	public MapWindow(State state) {
		 setLocation(10, 100);
	     getContentPane().setBackground(Theme.background);
	     setForeground(Theme.foreground);
	     setBackground(Theme.background);
	     getContentPane().setBackground(Theme.black);
	     map = new MapPanel(state);
	     this.add(map);
	     setEnabled(true);
	     setVisible(true);
	}
	
	public void newSize(int width, int height, int gridSize){
		 
	    map.resize(width,height, gridSize);
	    
	    mapDimension = new Dimension (width+8,height+32);
	    setSize(mapDimension);
	    setResizable(false);
	    setEnabled(true);
	}
	
	public void setDimensionWindow(DimensionsWindow dimensionWindow){
		this.dimensionWindow = dimensionWindow;
	}
	
	public void resize(){
		dimensionWindow.beVisible();
	}

	public void setBackgroundImage(String imgFile2) {
		this.imgFile = imgFile2;
		
		map.setBackground(imgFile2);
		
	}
}
