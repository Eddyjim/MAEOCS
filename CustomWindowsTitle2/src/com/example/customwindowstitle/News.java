package com.example.customwindowstitle;

import android.os.Bundle;
import android.view.Menu;

public class News extends CustomWindow {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_news, menu);
		return true;
	}

}
