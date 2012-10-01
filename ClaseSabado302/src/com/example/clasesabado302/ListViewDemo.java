package com.example.clasesabado302;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewDemo extends ListActivity {

	TextView selection;
	String[] items = { "Lorem", "ipsum", "dolor", "sit" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_demo);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1));
		selection = (TextView) findViewById(R.id.selection);

	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		selection.setText(items[position]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_list_view_demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return true;

	}

}
