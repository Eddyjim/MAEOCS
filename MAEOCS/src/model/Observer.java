package model;

import view.DirectionGraphicsPanel;
import view.ToolsGraphicsPanel;

public interface Observer {
 
	public void update(ToolsGraphicsPanel M);
	
	public void update(MapSection M);
	
	public void update(DirectionGraphicsPanel M);
	
}