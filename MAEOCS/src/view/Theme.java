package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


/**
 * This class allows to control globally all interface values
 * 
 * @author Carlos Gaitán Mora & Edward Jiménez Martínez
 *
 */
public class Theme {
	
	/**
	 * This are the basic colors ready to be used
	 */
	public static final Color black = new Color(0, 0, 0);
	public static final Color grayblack = new Color(50, 50, 50);
	public static final Color white = new Color(255, 255, 255);
	public static final Color blue = new Color(114, 159, 207);
	public static final Color green = new Color(138, 226, 52);
	public static final Color orange = new Color(252, 175, 62);
	public static final Color purple = new Color(173, 127, 168);
	public static final Color yellow = new Color(252, 233, 79);
	public static final Color red = new Color(255, 0, 0);
	
	/**
	 * Windows' positions
	 */
	public static final Point menuBarLocation = new Point(190, 0);
	public static final Point toolBarLocation = new Point(50, 70);
	public static final Point atributesPanelLocation = new Point(1000,70);
	public static final Point mapWindowLocation = new Point(190,70);
	public static final Point simulationFrameLocation = new Point(190,70);
	public static final Point choicesLocation = new Point(1000,120);

	
	/**
	 * This are the color values on the interface
	 */
	public static Color foreground = black;
	public static Color background = white;
	public static Color blockedForeground = white;
	public static Color blockedBackground = white;
	public static Color selectedButton = grayblack;
	
	
	public static Color roadColor = red;
	public static Color localColor = blue;
	public static Color stairsColor = yellow;
	public static Color exitColor = orange;
	
	public static Color simulationRoadColor = green;
	
	/**
	 * This are the dimensions of all windows and panels
	 */
	public static Dimension toolBarDimension = new Dimension(15,300);
	public static Dimension toolIconDimension = new Dimension(20,10);
	public static Dimension atributesPanelDimension = new Dimension(300,150);
	
	
	
	
	
	
	
}
