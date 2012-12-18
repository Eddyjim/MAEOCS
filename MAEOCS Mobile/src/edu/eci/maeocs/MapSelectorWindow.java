package edu.eci.maeocs;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MapSelectorWindow extends Activity implements OnClickListener{

	Button mapLoader;
	Spinner mapSelector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_map_selector_window);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.maeocs_window_title);
		mapLoader = new Button(this);
		mapLoader = (Button)findViewById(R.id.bt_SelectorCargarMapa);
		mapLoader.setOnClickListener(this);
		mapSelector = new Spinner(this);
		mapSelector = (Spinner)findViewById(R.id.sp_SelectorSpinnerMap);
		List<String> list = new ArrayList<String>();
		list.add("Mapa ECI");
		list.add("Mapa Santa Fe");
		list.add("Mapa U Nacional");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		mapSelector.setAdapter(dataAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_map_selector_window, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v == mapLoader){
            Intent intentHelp = new Intent(this , 
                    MapConsultingWindow.class);
			this.startActivity(intentHelp);
			
		}
	}

}
