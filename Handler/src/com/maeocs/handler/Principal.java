package com.maeocs.handler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Principal extends Activity implements Runnable {

	ProgressBar bar;
	TextView loadingTXT;
	boolean isRunning;
	int progress;
	ProgressDialog pDialog;
	EditText mUser;
	EditText mPass;
	Button btOK;
	Principal principal = this;

	Handler hdlr = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			// super.handleMessage(msg);
			bar.incrementProgressBy(5);
			progress += 5;
			loadingTXT.setText("Loading: " + progress + "%");
		}
	};

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			// super.handleMessage(msg);
			pDialog.dismiss();
			if (msg.arg1 == 0) {
				loadingTXT.setText("Failed Connection");
			} else {
				loadingTXT.setText("Connection Granted");
				Intent i = new Intent(principal, MenuPreg.class);
				principal.startActivity(i);
				principal.finish();
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		bar = (ProgressBar) findViewById(R.id.progressBarbar);
		loadingTXT = (TextView) findViewById(R.id.TV_Loading);
		mUser = (EditText) findViewById(R.id.editText_Name);
		mPass = (EditText) findViewById(R.id.editText_Pass);
		btOK = (Button) findViewById(R.id.buttonOK);
		btOK.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pDialog = ProgressDialog.show(v.getContext(), "Conectando...",
						"Ingresando...", true);
				Thread t = new Thread(principal);
				t.start();
			}
		});
	}

	@SuppressLint("ParserError")
	@Override
	protected void onStart() {
		super.onStart();
		bar.setProgress(0);
		progress = 0;
		loadingTXT.setText("Loading: " + progress + "%");
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 20; i++) {
						Thread.sleep(1000);
						hdlr.sendMessage(hdlr.obtainMessage());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		isRunning = true;
		t.start();
	}

	@Override
	protected void onStop() {
		super.onStop();
		isRunning = false;
	}

	@SuppressLint({ "ParserError", "ParserError" })
	@Override
	public void run() {

		String strUser = mUser.getText().toString();
		String strPass = mPass.getText().toString();
		CommHttpGet comm = new CommHttpGet();

		try {
			Message msgResult = new Message();
			String msg = "http://www.mevolucion.com.co/encuesta/result.php";
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
}
