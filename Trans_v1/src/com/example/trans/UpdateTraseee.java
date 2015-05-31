//package com.example.trans;
//
//import android.content.Context;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//
//public class UpdateTraseee {
//	private SQLiteDatabase database;
//	private DBHelper dbhelper;
//	private String[] allColumns = { DBHelper.TRASEU_NRTRASEU,
//			DBHelper.TRASEU_DURATA };
//	
//	
//	public UpdateTraseee(Context context) {
//		dbhelper = new DBHelper(context);
//	}
//	
//	public void open() throws SQLException {
//		database = dbhelper.getWritableDatabase();
//	}
//	
//	public void close() {
//		dbhelper.close();
//	}
//	
//	
//	
//	
//	
//	
//
//}
