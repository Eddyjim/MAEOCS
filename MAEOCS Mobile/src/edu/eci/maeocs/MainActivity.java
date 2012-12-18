package edu.eci.maeocs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	
	Button bt_MainHelp;
	Button bt_MainBluetooth;
	Button bt_MainMaps;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.maeocs_window_title);
        bt_MainHelp = new Button(this);
        bt_MainHelp = (Button)findViewById(R.id.bt_MainAyuda);
        bt_MainHelp.setOnClickListener(this);
        bt_MainBluetooth = new Button(this);
        bt_MainBluetooth = (Button)findViewById(R.id.bt_MainCargarMapa);
        bt_MainBluetooth.setOnClickListener(this);
        bt_MainMaps = new Button(this);
        bt_MainMaps = (Button)findViewById(R.id.bt_MainMisMapas);
        bt_MainMaps.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View view) {
		if(view == bt_MainHelp){
            Intent intentHelp = new Intent(this , 
                    HelpWindow.class);
			this.startActivity(intentHelp);
			
		}if(view == bt_MainBluetooth){
            Intent intentHelp = new Intent(this , 
                    SDMapWindow.class);
			this.startActivity(intentHelp);
			
		}if(view == bt_MainMaps){
            Intent intentHelp = new Intent(this , 
                    MapSelectorWindow.class);
			this.startActivity(intentHelp);
			
		}
		
	}
    
}
