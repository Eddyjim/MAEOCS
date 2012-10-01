package com.example.charliegraphics;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class TempSprite {
	private float x;
	private float y;
	private Bitmap bmp;
	private int life = 15;
	private List<TempSprite> temps;

	public TempSprite(List<TempSprite> temps, GameView gameView, float x,
			float y, Bitmap bitmap) {
		this.bmp = bitmap;
		this.temps = temps;
		this.x = Math.min(Math.max(x - bmp.getWidth() / 2, 0),
				gameView.getWidth() - bmp.getWidth());
		this.y = Math.min(Math.max(y - bmp.getHeight() / 2, 0),
				gameView.getHeight() - bmp.getHeight());
	}

	public void onDraw(Canvas canvas) {
		update();
		canvas.drawBitmap(bmp, x, y, null);
	}

	private void update() {
		if (--life < 1) {
			temps.remove(this);
		}
	}

}
