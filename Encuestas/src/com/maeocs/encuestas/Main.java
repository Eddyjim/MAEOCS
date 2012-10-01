package com.maeocs.encuestas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ParserError")
public class Main extends Activity implements OnClickListener, Runnable {

	Button ok;
	Button cancel;
	EditText mUser;
	EditText mPass;
	TextView connectionState;
	Activity main = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ok = (Button) findViewById(R.id.ok_BT);
		cancel = (Button) findViewById(R.id.cancel_BT);
		ok.setOnClickListener(this);
		cancel.setOnClickListener(this);
		mUser = (EditText) findViewById(R.id.editText_Name);
		mPass = (EditText) findViewById(R.id.editText_Pass);
		connectionState = (TextView) findViewById(R.id.connectionStateText);
		/*
		 * if (savedInstanceState != null) {
		 * mUser.setText(savedInstanceState.getString("editName"));
		 * mPass.setText(savedInstanceState.getString("editPass")); }
		 */

	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			if (msg.arg1 == 0) {
				connectionState.setText("Connection Failed");
			} else {
				connectionState.setText("Connection Granted");
				Intent i = new Intent(main, MenuPreg.class);
				main.startActivity(i);
				main.finish();
			}
		}
	};

	@Override
	public void onClick(View v) {
		if (v == ok) {
			Thread t = new Thread(this);
			t.start();
		} else if (v == cancel) {
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle c = data.getExtras();
			System.out.println(c.getString("etiqueta"));

		} else {
			System.out.println("");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(menu.NONE, 0, 0, "Change current settings");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			startActivity(new Intent(this, PreferencesConnection.class));
			return true;
		}
		return false;
	}

	@Override
	public void run() {

		String strUser = mUser.getText().toString();
		String strPass = mPass.getText().toString();
		String strDir;
		String strFile;

		CommHttpGet comm = new CommHttpGet();

		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		strDir = sharedPrefs.getString("connectingDir", "NULL");
		strFile = sharedPrefs.getString("connectingFile", "NULL");

		try {
			Message msgResult = new Message();
			// String msg = "http://www.mevolucion.com.co/encuesta/result.php";
			String msg = "http://" + "www.mevolucion.com.c" + strDir
					+ "/encuesta/" + "result.ph" + strFile;
			msg += "?vector%5B%5D=0801";
			msg += "&vector%5B%5D=" + strUser;
			msg += "&vector%5B%5D=" + strPass;
			String result = comm.execCommHttpGet(msg);
			result = result.trim();
			if (result.compareTo("false") == 0) {
				msgResult.arg1 = 0;
				handler.sendMessage(msgResult);

			} else {
				msgResult.arg1 = 1;
				handler.sendMessage(msgResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
		} else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
		}
	}

	/*
	 * 
	 * @Override protected void onSaveInstanceState(Bundle outState) { // TODO
	 * Auto-generated method stub outState.putString("editName",
	 * mUser.getText().toString()); outState.putString("editPass",
	 * mPass.getText().toString()); super.onSaveInstanceState(outState); }
	 */
}
