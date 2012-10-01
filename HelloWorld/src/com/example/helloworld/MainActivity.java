package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements
		CompoundButton.OnCheckedChangeListener {

	CheckBox cb;
	RadioGroup orientation;
	RadioGroup gravity;
	RadioButton rb_Rock;
	RadioButton rb_Paper;
	RadioButton rb_Scisors;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		orientation = (RadioGroup) findViewById(R.id.GAME_RPS);
		orientation.setOnCheckedChangeListener((OnCheckedChangeListener) this);
		cb = (CheckBox) findViewById(R.id.check);
		rb_Rock = (RadioButton) findViewById(R.id.Rock);
		rb_Paper = (RadioButton) findViewById(R.id.Paper);
		rb_Scisors = (RadioButton) findViewById(R.id.Scisors);
		cb.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		if (arg0.equals(cb)) {
			if (arg1) {
				cb.setText("This Button is Checked");
			} else {
				cb.setText("This Button is not Checked");
			}
		}
		if (arg0.equals(cb)) {
			if (arg1) {
				// orientation.setVerticalGravity(verticalGravity)
			} else {
				cb.setText("This Button is not Checked");
			}
		}

	}

}
