package com.maeocs.juego;
import java.util.Random;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class Game extends MIDlet {


	private JuegoGameCanvas juegoCanvas;
	private JuegoGameTiles juegoTiles;
	private Command quit;
	private Command redraw;
	
	
	public Game(){
		super();
		
		quit = new Command("Quit", Command.EXIT, 1);
		redraw = new Command("Redraw", Command.OK, 2);
	}


	protected void destroyApp(){
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() {
		juegoCanvas = new JuegoGameCanvas(true);
		juegoTiles = new JuegoGameTiles(true);
		Thread t = new Thread (juegoTiles);
		Display.getDisplay(this).setCurrent(juegoTiles);
		//juegoCanvas.setCommandListener(this);
		t.start();
	}

	protected void destroyApp(boolean unconditional){
		
	}

}
