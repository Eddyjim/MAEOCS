package model;

import view.DirectionGraphicsPanel;
import view.TypeCreatorGraphicsPanel;

public interface Observer {
 
	public void update(TypeCreatorGraphicsPanel M);
	
	public void update(MapSection M);
	
	public void update(DirectionGraphicsPanel M);
	
}