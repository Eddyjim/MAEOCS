package com.maeocs.handler;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Menu extends ListActivity /*
										 * implements OnMenuItemClickListener,
										 * OnCreateContextMenuListener
										 */{

	TextView selection;
	String[] items = { "Lorem", "ipsum", "dolor", "sit" };

	public Menu() {
		super();
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * Intent i = new Intent(); String valor = ""; setResult(RESULT_OK, i);
		 * Bundle b = new Bundle(); b.putString("etiqueta", valor);
		 * i.putExtras(b); startActivityForResult(i, 0); finish();
		 */
		setContentView(R.layout.activity_menu);
		/*
		 * ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		 * android.R.layout.simple_list_item_1, android.R.id.list, items);
		 */

	}
	/*
	 * 
	 * @Override public void onCreateContextMenu(ContextMenu menu, View v,
	 * ContextMenuInfo menuInfo) { // TODO Auto-generated method stub
	 * super.onCreateContextMenu(menu, v, menuInfo);
	 * menu.setHeaderTitle("MENU DE PRUEBA"); menu.add("action 1");
	 * menu.add("action 2"); menu.add("action 3"); }
	 * 
	 * @Override public boolean onContextItemSelected(MenuItem item) { if
	 * (item.getTitle() == "action 1") { System.out.println("accion 1"); } else
	 * if (item.getTitle() == "action 2") { System.out.println("accion 1"); }
	 * else { return false; } return true; }
	 * 
	 * @Override public boolean onCreateOptionsMenu(android.view.Menu menu) {
	 * menu.add(1, 1, 1, "Opcion 1"); return true; }
	 * 
	 * @Override public boolean onMenuItemClick(MenuItem item) { // TODO
	 * Auto-generated method stub return false; }
	 */
}
