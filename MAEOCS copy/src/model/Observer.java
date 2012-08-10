package model;

import view.ToolsGraphicsPanel;
import view.TypeCreatorGraphicsPanel;

public interface Observer {
 
	public void update(TypeCreatorGraphicsPanel M);
	
	public void update(MapSection M);
	
	public void update(ToolsGraphicsPanel M);
	
}