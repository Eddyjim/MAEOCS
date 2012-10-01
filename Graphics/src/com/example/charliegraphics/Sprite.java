package com.example.charliegraphics;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
	private int x = 0;
	private int y = 0;
	private int currentFrame = 0;
	private int width = 0;
	private int height = 0;
	private int xSpeed = 5;
	private int ySpeed = 5;
	private GameView gameView;
	private Bitmap bmps;
	private static final int BMP_ROWS = 4;
	private static final int BMP_COLUMNS = 3;
	private int[] DIRECTION_TO_ANIMATION_MAP = { 3, 1, 0, 2 };

	public Sprite(GameView gameView, Bitmap bmpr) {

		this.gameView = gameView;
		this.bmps = bmpr;
		this.width = bmps.getWidth() / BMP_COLUMNS;
		this.height = bmps.getHeight() / BMP_ROWS;
		Random rnd = new Random(System.currentTimeMillis());
		xSpeed = rnd.nextInt(50) - 5;
		ySpeed = rnd.nextInt(50) - 5;

	}

	public boolean isCollition(float x2, float y2) {

		return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
	}

	private void update() {
		if (x >= gameView.getWidth() - width - xSpeed || x + xSpeed <= 0) {
			xSpeed = -xSpeed;
		}
		x = x + xSpeed;
		if (y >= gameView.getHeight() - height - ySpeed || y + ySpeed <= 0) {
			ySpeed = -ySpeed;
		}
		y = y + ySpeed;

		currentFrame = ++currentFrame % BMP_COLUMNS;

	}

	public void onDraw(Canvas canvas) {
		update();
		int srcX = currentFrame * width;
		int srcY = getAnimationRow() * height;

		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dst = new Rect(x, y, x + width, y + height);
		canvas.drawBitmap(bmps, src, dst, null);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int getAnimationRow() {
		double dirDouble = (Math.atan2(xSpeed, ySpeed) / (Math.PI / 2) + 2);
		int direction = (int) Math.round(dirDouble) % BMP_ROWS;
		return DIRECTION_TO_ANIMATION_MAP[direction];
	}

}
