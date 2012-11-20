package com.example.preferencetest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class ShowSettingsActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences_test);
		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		StringBuilder builder = new StringBuilder();
		builder.append("\n" + sharedPrefs.getString("username", "NULL"));
		builder.append("\n"
				+ sharedPrefs.getBoolean("applicationUpdates", false));
		builder.append("\n" + sharedPrefs.getString("downloadType", "1"));
		TextView settingsTextView = (TextView) findViewById(R.id.settings_text_view);
		settingsTextView.setText(builder.toString());
	}
}
