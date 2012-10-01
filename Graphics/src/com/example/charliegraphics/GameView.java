package com.example.charliegraphics;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

	Bitmap bmp;
	SurfaceHolder holder;
	private GameLoopThread gameLoopThread;
	private boolean dir = true;
	private List<Sprite> sprites = new ArrayList<Sprite>();
	Bitmap bmpBlood;
	private List<TempSprite> temps = new ArrayList<TempSprite>();
	private long lastClick;

	private Paint paint;

	private long startTime;
	private int maxTime;
	private float divTime;

	private SoundPool sounds;
	private int sExplosion;

	private static final int EXPLOSION_SIZE = 50;
	private Explosion[] explosions;

	private Vibrator vib;

	private Sprite hero;

	public GameView(Context context) {
		super(context);

		paint = new Paint();

		paint.setColor(Color.BLUE);

		vib = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

		startTime = System.currentTimeMillis();
		maxTime = 20;
		divTime = 1000F;

		sounds = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		sExplosion = sounds.load(context, R.raw.explosion, 1);

		gameLoopThread = new GameLoopThread(this);

		holder = getHolder();
		holder.addCallback(this);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		bmpBlood = BitmapFactory.decodeResource(getResources(),
				R.drawable.blood1);

		if (System.currentTimeMillis() - lastClick > 50)
			lastClick = System.currentTimeMillis();

		float x = event.getX();
		float y = event.getY();

		synchronized (getHolder()) {
			for (int i = sprites.size() - 1; i >= 0; i--) {
				Sprite sprite = sprites.get(i);
				if (sprite.isCollition(x, y) && sprite != hero) {
					sprites.remove(sprite);
					explode((int) x, (int) y);
					temps.add(new TempSprite(temps, this, x, y, bmpBlood));
					sounds.play(sExplosion, 1.0f, 1.0f, 0, 0, 1.5f);
					vib.vibrate(500);
					break;
				}

			}
		}
		/*
		 * synchronized (getHolder()) { for (int i = sprites.size() - 1; i >= 0;
		 * i--) { Sprite sprite = sprites.get(i); if
		 * (sprite.isCollition(event.getX(), event.getY())) {
		 * sprites.remove(sprite); } } }
		 */
		return true;
	}

	private void explode(int x, int y) {
		int currentExplosion = 0;
		Explosion explosion = explosions[currentExplosion];

		while (explosion != null && explosion.isAlive()
				&& currentExplosion < explosions.length) {
			currentExplosion++;
			explosion = explosions[currentExplosion];
		}

		if (explosion == null || explosion.isDead()) {
			explosion = new Explosion(200, x, y);
			explosions[currentExplosion] = explosion;
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		/*
		 * bmp = BitmapFactory.decodeResource(getResources(),
		 * R.drawable.ic_launcher); canvas.drawColor(Color.BLACK);
		 * canvas.drawBitmap(bmp, 10, 10, null); super.onDraw(canvas);
		 */
		/*
		 * canvas.drawColor(Color.BLACK); canvas.drawBitmap(bmp, 10, 10, null);
		 */
		canvas.drawColor(Color.BLACK);
		/*
		 * 
		 * if (dir) { x += bmp.getWidth(); if (!(x < getWidth() -
		 * bmp.getWidth())) dir = false; } if (!dir) { x -= bmp.getWidth(); if
		 * (!(x > 0)) dir = true; }
		 */
		// canvas.drawBitmap(bmp, x, 10, null);

		float elapsed = ((System.currentTimeMillis() - startTime) / divTime);

		int pendingTime = maxTime - (int) elapsed;

		if (pendingTime <= 0) {
			pendingTime = 0;
			gameLoopThread.setRunning(false);
		}

		canvas.drawText("Tiempo restante: " + pendingTime, 0, 120, paint);

		for (int i = temps.size() - 1; i >= 0; i--) {
			temps.get(i).onDraw(canvas);
		}

		for (int i = 0; i < explosions.length; i++) {
			if (explosions[i] != null) {
				explosions[i].update(getHolder().getSurfaceFrame());
				explosions[i].draw(canvas);
			}
		}

		for (Sprite sprite : sprites) {
			sprite.onDraw(canvas);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		createSprites();
		createExplosions();
		gameLoopThread.setRunning(true);
		gameLoopThread.start();
	}

	private void createExplosions() {
		explosions = new Explosion[12];
		for (int i = 0; i < explosions.length; i++) {
			explosions[i] = null;
		}

	}

	private void createSprites() {
		sprites.add(createSprite(R.drawable.sprite_ka1));
		sprites.add(createSprite(R.drawable.sprite_ka2));
		sprites.add(createSprite(R.drawable.sprite_ka3));
		sprites.add(createSprite(R.drawable.sprite_ka4));
		sprites.add(createSprite(R.drawable.sprite_ka5));
		hero = createSprite(R.drawable.sprite_pa1);
	}

	private Sprite createSprite(int resource) {
		return new Sprite(this, BitmapFactory.decodeResource(getResources(),
				resource));
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;

		gameLoopThread.setRunning(false);
		while (retry) {
			try {
				gameLoopThread.join();
				retry = false;
			} catch (Exception e) {
			}
		}
		retry = false;

	}

}
