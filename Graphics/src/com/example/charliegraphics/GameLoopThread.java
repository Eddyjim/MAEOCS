package com.example.charliegraphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GameLoopThread extends Thread {
	private GameView view;
	private boolean running = false;
	Bitmap bmp;

	public GameLoopThread(GameView view) {
		this.view = view;
	}

	public void setRunning(boolean run) {
		running = run;
	}

	public void run() {
		while (running) {
			Canvas c = null;
			try {
				c = view.getHolder().lockCanvas();
				synchronized (view.getHolder()) {
					view.onDraw(c);
				}
			} catch (Exception e) {
			} finally {
				if (c != null) {
					view.getHolder().unlockCanvasAndPost(c);
				}
			}
		}
	}

}
