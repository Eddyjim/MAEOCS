package com.maeocs.encuestas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class EncuestasSQLiteHelper extends SQLiteOpenHelper {

	String sqlCreate = "CREATE TABLE usuarios (codigo INTEGER, nombre TEXT)";

	public EncuestasSQLiteHelper(Context contexto, String nombre,
			CursorFactory factory, int version) {
		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreate);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXIST usuarios");
		db.execSQL(sqlCreate);

	}

}
