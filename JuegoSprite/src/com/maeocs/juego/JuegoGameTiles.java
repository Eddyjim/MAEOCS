package com.maeocs.juego;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

public class JuegoGameTiles extends GameCanvas implements Runnable{

	int height;
	int width;
	int coordX;
	int coordY;
	int coordXSprite;
	int coordYSprite;
	int orientation;
	final static int WIDTH_VW=180;
	final static int HEIGHT_VW=177;
	
	
	Image tiled=null;
	Image sprited=null;
	
	LayerManager lm;
	TiledLayer tl;
	
	Sprite sprite;
	Sprite sprite2;
	Graphics g;
	
	
	protected JuegoGameTiles(boolean suppressKeyEvents) {
		super(suppressKeyEvents);
		
		orientation = 1;
		
		width = getWidth();
		height = getHeight();
		
		g = getGraphics();
		
		lm = new LayerManager();
		
		try{
			tiled = Image.createImage("/tiledLayer.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		tl = new TiledLayer(20, 11, tiled, 16, 16);
		
		try {
			sprited = Image.createImage("/zero.png");
		}catch (Exception e) {}
		
		int[] map = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					 1,1,6,1,1,1,1,6,6,1,1,1,1,1,1,1,1,1,1,6,
					 1,5,3,4,1,1,5,3,3,4,1,1,1,1,1,1,1,1,5,3,
					 5,3,3,3,4,5,3,3,3,3,4,1,1,1,1,1,1,5,3,3,
					 3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
					 3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
					 3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
					 3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
					 2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
					 };
		for (int i = 0; i < map.length; i++) {
			int column=i%20;
			int row=(i-column)/20;
			tl.setCell(column, row, map[i]);
		}
		tl.setVisible(true);
		sprite = new Sprite(sprited, 23, 24);
		int[] sequence ={9,8,7,6,5,4,3,2,1,0};
		coordXSprite=width/2;
		coordYSprite=128;
		sprite.setFrameSequence(sequence);
		sprite.defineReferencePixel(11, 25);
		sprite.setRefPixelPosition(coordXSprite, coordYSprite);
		sprite.setVisible(true);
		sprite2 = new Sprite(sprited, 23, 24);
		int[] sequence2 ={0,1,2,3};
		coordXSprite=width/2;
		coordYSprite=128;
		sprite2.setFrameSequence(sequence);
		sprite2.defineReferencePixel(0, 25);
		sprite2.setRefPixelPosition(coordXSprite, coordYSprite);
		sprite2.setTransform(Sprite.TRANS_MIRROR);
		sprite2.setVisible(true);
		lm.append(sprite);
		lm.append(tl);
		
		lm.setViewWindow(0, 0, WIDTH_VW, HEIGHT_VW);
		lm.paint(g, 0, 0);
		flushGraphics();
	}

	public void run() {

		
		while(true){
			try{
				int keyState = this.getKeyStates();
				if(keyState!=0){
					this.actualizarPosicion(keyState);
				}				
				lm.setViewWindow(coordX, coordY, WIDTH_VW, HEIGHT_VW);
				sprite.setRefPixelPosition(coordXSprite, coordYSprite);
				lm.paint(g, 0, 0);
				flushGraphics();
				Thread.sleep(50);
				
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
	}
	

	private void actualizarPosicion(int keyState) {
		
		//if(sprite)
		
		switch (keyState) {
		case 4:
			if (coordX>3) {
				if(orientation==1){
					sprite.setTransform(Sprite.TRANS_MIRROR);
				}
				coordX-=4;
				sprite.prevFrame();
				coordXSprite-=4;
				orientation=-1;
			}
			break;
			
		case 32:
			if (coordX<width-40) {
				if(orientation==-1){
					sprite.setTransform(Sprite.TRANS_NONE);
				}
				coordX+=4;
				sprite.prevFrame();
				coordXSprite+=4;
				orientation=1;
			}
			break;

		default:
			break;
		}
		
	}
	

}
