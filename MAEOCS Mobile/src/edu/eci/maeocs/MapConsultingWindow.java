package edu.eci.maeocs;

import edu.eci.model.Exportable;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MapConsultingWindow extends Activity implements OnClickListener{
	
	Button orient;
	Button gps;
	TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_map_consulting_window);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.maeocs_window_title);
		Exportable exportable = (Exportable) getIntent().getSerializableExtra("exportable");
		
		orient = new Button(this);
		orient = (Button)findViewById(R.id.bt_ConsultingOrientarme);
		orient.setOnClickListener(this);
		title = new TextView(this);
		title = (TextView)findViewById(R.id.tx_ConsultingMapaSeleccionado);
		title.setOnClickListener(this);
		gps = new Button(this);
		gps = (Button)findViewById(R.id.bt_ConsultingUbicarme);
		gps.setOnClickListener(this);
		
		title.setText(exportable.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_map_consulting_window, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v == orient){
            Intent intentHelp = new Intent(this , 
                    MapWindow.class);
			this.startActivity(intentHelp);
			
		}if(v == gps){
            Intent intentHelp = new Intent(this , 
                    GPSMapWindow.class);
			this.startActivity(intentHelp);
			
		}
	}

}
