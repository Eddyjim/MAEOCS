package edu.eci.maeocs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

import org.openintents.intents.FileManagerIntents;

import edu.eci.model.Exportable;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SDMapWindow extends Activity implements OnClickListener{
	
	protected static final int REQUEST_CODE_PICK_FILE_OR_DIRECTORY = 1;
	
	private Button guardar;
	private Button cargar;
	private EditText direccion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_bluetooth_map_window);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.maeocs_window_title);
		cargar = (Button) findViewById(R.id.bt_BluetoothBuscarMapa);
		guardar = (Button) findViewById(R.id.bt_BluetoothGuardarMapa);
		direccion = (EditText) findViewById(R.id.et_BluetoothDireccionMapa);
		guardar.setOnClickListener(this);
	}
	
    public void openFile() {
		String fileName = direccion.getText().toString();
		
		Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
		
		// Construct URI from file name.
		File file = new File(fileName);
		intent.setData(Uri.fromFile(file));
		
		try {
			startActivityForResult(intent, REQUEST_CODE_PICK_FILE_OR_DIRECTORY);
		} catch (ActivityNotFoundException e) {
			// No compatible file manager was found.
			Toast.makeText(this, "no_filemanager_installed", 
					Toast.LENGTH_SHORT).show();
		}
		
	}
    
    public void saveFile(String dir){
		Exportable load = null;
		File file = new File(dir);
		System.out.println(file.getAbsolutePath());
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
			load = (Exportable) new ObjectInputStream(is).readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (OptionalDataException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				//is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (load!= null){
			Intent intent = new Intent(this , MapConsultingWindow.class);
			intent.putExtra("exportable", load);
			this.startActivity(intent);
		}else{
			System.out.println("Paila");
		}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_bluetooth_map_window, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		if(view == guardar){
			System.out.println(direccion.getText().toString());
			saveFile(direccion.getText().toString());
		}
		
	}


}
