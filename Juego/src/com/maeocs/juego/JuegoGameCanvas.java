package com.maeocs.juego;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;


public class JuegoGameCanvas extends GameCanvas implements Runnable {

	int width;
	int height;
	int coordXSprite;
	int coordYSprite;
	
	Image sprited = null;
	
	Graphics g;
	
	LayerManager lm;
	
	Sprite sprite;
	
	public JuegoGameCanvas (boolean b){
		super(b);
		width = getWidth();
		height = getHeight();
		lm = new LayerManager();
		
		
		try{
			sprited = Image.createImage("/imgSprite.png");
		}catch(java.io.IOException e){
			e.printStackTrace();			
		}
		
		sprite = new Sprite(sprited, 15, 25);
		int[] sequence = {0,1,2,3};
		
		coordXSprite= width/2;
		coordYSprite= height/2;
		sprite.setFrameSequence(sequence);
		sprite.defineReferencePixel(0, 25);
		sprite.setRefPixelPosition(coordXSprite, coordYSprite);
		sprite.setTransform(sprite.TRANS_MIRROR);
		sprite.setVisible(true);
		lm.append(sprite);
		lm.paint(g, 0, 0);
		flushGraphics();
	}

	public void run() {
		while(true){
			try{
			
				sprite.nextFrame();
				g.setColor(255, 255, 255);
				g.fillRect(0, 0, width, height);
				
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
	}
}
