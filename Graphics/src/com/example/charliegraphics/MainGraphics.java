package com.example.charliegraphics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

public class MainGraphics extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(new GameView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_graphics, menu);
		return true;
	}

}
