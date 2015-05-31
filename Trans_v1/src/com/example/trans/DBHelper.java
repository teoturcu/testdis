package com.example.trans;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	
	//Database versioin 
	private static final int DATABASE_VERSION = 1;
	
	//Database name
	private static final String DATABASE_NAME = "transTest";

	//Table name
	private static final String TABLE_STATIE = "statie";
	private static final String TABLE_TRASEU = "traseu";
	private static final String TABLE_CATEGORIEAUTO = "categorieAuto";
	private static final String TABLE_OPRESTE = "opreste";
	private static final String TABLE_TIPTRRASEU = "tipTraseu";
	private static final String TABLE_ORAR = "orar";
	private static final String TABLE_CIRCULA = "circula";
	
	//Column names
	private static final String STATIE_NRSTATIE = "nrSt";
	private static final String STATIE_DENSTATIE = "denSt";
	private static final String STATIE_ADRESA = "adresa";
	private static final String STATIE_COORDONATE = "coordonate";
	
	static final String TRASEU_NRTRASEU = "nrT";
	static final String TRASEU_DURATA = "durata";
	private static final String TRASEU_NRSTATIESTART = "statieStart";
	private static final String TRASEU_NRSTATIEEND = "statieEnd";
	private static final String TRASEU_NRC = "nrc";
	
	private static final String CATEGORIEAUTO_NRC = "nrc";
	private static final String CATEGORIEAUTO_TIPAUTO = "tipAuto";
	
	private static final String OPRESTE_NROP = "nrOp";
	private static final String OPRESTE_TIPTRASEU = "tipTraseu";
	private static final String OPRESTE_NRSTATIE = "nrSt";
	private static final String OPRESTE_NRTRASEU = "nrT";
	
	private static final String TIPTRASEU_NRTIP = "nrTip";
	private static final String TIPTRASEU_TIPTRRASEU = "tipTraseu";
	
	private static final String ORAR_NRORA = "nrOr";
	private static final String ORAR_ORA = "ora";
	
	private static final String CIRCULA_NROP = "nrOp";
	private static final String CIRCULA_NROR = "nrOr";
	

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		context.deleteDatabase("transTest");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		Log.d("TAG", "test");
		final String CREATE_TABLE_STATIE = 
				"CREATE TABLE " + TABLE_STATIE + " (" +
					STATIE_NRSTATIE + 	" INTEGER PRIMARY KEY, " +
					STATIE_DENSTATIE +	" VARCHAR(200), " +
					STATIE_ADRESA + 	" VARCHAR(200), " +
					STATIE_COORDONATE +	" VARCHAR(100) " +
				"); ";
		
		final String CREATE_TABLE_CATEGORIEAUTO = 
				"CREATE TABLE " + TABLE_CATEGORIEAUTO + " (" +
					CATEGORIEAUTO_NRC + " INTEGER PRIMARY KEY, " +
					CATEGORIEAUTO_TIPAUTO + " VARCHAR(50) " +
				" );";
		
		final String CREATE_TABLE_TRASEU = 
				"CREATE TABLE " + TABLE_TRASEU + " (" +
						TRASEU_NRTRASEU + " INTEGER PRIMARY KEY, " +
						TRASEU_DURATA +	" INTEGER(4), " +
						TRASEU_NRSTATIESTART + 	" INTEGER(20), " +
						TRASEU_NRSTATIEEND +	" INTEGER(20), " +
						TRASEU_NRC + " INTEGER(20), " +
						"FOREIGN KEY(" + TRASEU_NRC + ") REFERENCES " + 
							TABLE_CATEGORIEAUTO + "(" + CATEGORIEAUTO_NRC + ")" +
					"); ";
		
		final String CREATE_TABLE_TIPTRRASEU = 
				"CREATE TABLE " + TABLE_TIPTRRASEU + " (" +
						TIPTRASEU_NRTIP + " INTEGERR PRIMARY KEY, " +
						TIPTRASEU_TIPTRRASEU + " VARCHAR(5) " +
				" );";
		
		final String CREATE_TABLE_ORAR = 
				"CREATE TABLE " + TABLE_ORAR + " (" +
						ORAR_NRORA + " INTEGER PRIMARY KEY, " +
						ORAR_ORA + " VARCHAR(10) " +
				" );";
		
		final String CREATE_TABLE_OPRESTE = 
				"CREATE TABLE " + TABLE_OPRESTE + " (" +
						OPRESTE_NROP + " INTEGER PRIMARY KEY, " +
						OPRESTE_NRSTATIE + " INTEGER, " +
						OPRESTE_NRTRASEU + " INTEGER, " +
						OPRESTE_TIPTRASEU + " INTEGER, " +
						"FOREIGN KEY(" + OPRESTE_NRSTATIE + ") REFERENCES " + 
							TABLE_STATIE + "(" + STATIE_NRSTATIE + "), " +
						"FOREIGN KEY(" + OPRESTE_NRTRASEU + ") REFERENCES " + 
							TABLE_TRASEU + "(" + TRASEU_NRTRASEU + "), " +
						"FOREIGN KEY(" + OPRESTE_TIPTRASEU + ") REFERENCES " + 
							TABLE_TIPTRRASEU + "(" + TIPTRASEU_NRTIP + ")" +
				" );";
		
		final String CREATE_TABLE_CIRCULA = 
				"CREATE TABLE " + TABLE_CIRCULA + " (" +
						CIRCULA_NROP + " INTEGER, " +
						CIRCULA_NROR + " INTEGER " +
				" );";
		
		db.execSQL(CREATE_TABLE_STATIE);
		db.execSQL(CREATE_TABLE_CATEGORIEAUTO);
		db.execSQL(CREATE_TABLE_TRASEU);
		db.execSQL(CREATE_TABLE_TIPTRRASEU);
		db.execSQL(CREATE_TABLE_ORAR);
		db.execSQL(CREATE_TABLE_CIRCULA);
		db.execSQL(CREATE_TABLE_OPRESTE);
		insertMassiveData(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
//		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRASEU);
//		onCreate(db);

	}

	private void insertMassiveData(SQLiteDatabase db) {
		ContentValues contentValues = new ContentValues();
		
		//Statie
		contentValues.put(DBHelper.STATIE_NRSTATIE, 1);
		contentValues.put(DBHelper.STATIE_DENSTATIE, "Micro 19");
		contentValues.put(DBHelper.STATIE_ADRESA, "str. Gh. Asachi");
		contentValues.put(DBHelper.STATIE_COORDONATE, "xxxxxx");
		
		db.insert(DBHelper.TABLE_STATIE, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(DBHelper.STATIE_NRSTATIE, 2);
		contentValues.put(DBHelper.STATIE_DENSTATIE, "Micro 20");
		contentValues.put(DBHelper.STATIE_ADRESA, "test");
		contentValues.put(DBHelper.STATIE_COORDONATE, "test");
		
		//Insert value into Statie table
		db.insert(DBHelper.TABLE_STATIE, null, contentValues);
		
		
		
		//Traseu
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.TRASEU_NRTRASEU, 104);
		contentValues.put(DBHelper.TRASEU_DURATA, 30);
		contentValues.put(DBHelper.TRASEU_NRSTATIESTART, 11);
		contentValues.put(DBHelper.TRASEU_NRSTATIEEND, 32);
		contentValues.put(DBHelper.TRASEU_NRC, 2);
		
		//Insert value into Traseu table
		db.insert(DBHelper.TABLE_TRASEU, null, contentValues);
		
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.TRASEU_NRTRASEU, 7);
		contentValues.put(DBHelper.TRASEU_DURATA, 5);
		contentValues.put(DBHelper.TRASEU_NRSTATIESTART, 11);
		contentValues.put(DBHelper.TRASEU_NRSTATIEEND, 32);
		contentValues.put(DBHelper.TRASEU_NRC, 1);
		
		//Insert value into Traseu table
		db.insert(DBHelper.TABLE_TRASEU, null, contentValues);
		
		
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.TRASEU_NRTRASEU, 17);
		contentValues.put(DBHelper.TRASEU_DURATA, 15);
		contentValues.put(DBHelper.TRASEU_NRSTATIESTART, 111);
		contentValues.put(DBHelper.TRASEU_NRSTATIEEND, 312);
		contentValues.put(DBHelper.TRASEU_NRC, 3);
		
		//Insert value into Traseu table
		db.insert(DBHelper.TABLE_TRASEU, null, contentValues);
		
		
		
		//Categorie auto
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.CATEGORIEAUTO_NRC, 1);
		contentValues.put(DBHelper.CATEGORIEAUTO_TIPAUTO, "tramvai");
		db.insert(DBHelper.TABLE_CATEGORIEAUTO, null, contentValues);
		
		
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.CATEGORIEAUTO_NRC, 2);
		contentValues.put(DBHelper.CATEGORIEAUTO_TIPAUTO, "troleibuz");
		db.insert(DBHelper.TABLE_CATEGORIEAUTO, null, contentValues);
		
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.CATEGORIEAUTO_NRC, 3);
		contentValues.put(DBHelper.CATEGORIEAUTO_TIPAUTO, "autobuz");
		db.insert(DBHelper.TABLE_CATEGORIEAUTO, null, contentValues);
		
		
		
		
		//Tip traseu
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.TIPTRASEU_NRTIP, 1);
		contentValues.put(DBHelper.TIPTRASEU_TIPTRRASEU, "tur");
		db.insert(DBHelper.TABLE_TIPTRRASEU, null, contentValues);
		
		
		contentValues = new ContentValues();
		
		contentValues.put(DBHelper.TIPTRASEU_NRTIP, 2);
		contentValues.put(DBHelper.TIPTRASEU_TIPTRRASEU, "retur");
		db.insert(DBHelper.TABLE_TIPTRRASEU, null, contentValues);
		
		
		//Orar
		contentValues = new ContentValues();
		contentValues.put(DBHelper.ORAR_NRORA, 1);
		contentValues.put(DBHelper.ORAR_ORA, "5:00");
		db.insert(DBHelper.TABLE_ORAR, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(DBHelper.ORAR_NRORA, 2);
		contentValues.put(DBHelper.ORAR_ORA, "6:00");
		db.insert(DBHelper.TABLE_ORAR, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(DBHelper.ORAR_NRORA, 3);
		contentValues.put(DBHelper.ORAR_ORA, "7:00");
		db.insert(DBHelper.TABLE_ORAR, null, contentValues);
		
		
		
		//Circula
		contentValues = new ContentValues();
		contentValues.put(DBHelper.CIRCULA_NROP, 1);
		contentValues.put(DBHelper.CIRCULA_NROR, 1);
		db.insert(DBHelper.TABLE_CIRCULA, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(DBHelper.CIRCULA_NROP, 2);
		contentValues.put(DBHelper.CIRCULA_NROR, 2);
		db.insert(DBHelper.TABLE_CIRCULA, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(DBHelper.CIRCULA_NROP, 3);
		contentValues.put(DBHelper.CIRCULA_NROR, 3);
		db.insert(DBHelper.TABLE_CIRCULA, null, contentValues);
		
		
		//Opreste
		contentValues = new ContentValues();
		contentValues.put(DBHelper.OPRESTE_NROP, 1);
		contentValues.put(DBHelper.OPRESTE_NRSTATIE, 1);
		contentValues.put(DBHelper.OPRESTE_NRTRASEU, 102);
		contentValues.put(DBHelper.OPRESTE_TIPTRASEU, 1);
		db.insert(DBHelper.TABLE_OPRESTE, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(DBHelper.OPRESTE_NROP, 2);
		contentValues.put(DBHelper.OPRESTE_NRSTATIE, 2);
		contentValues.put(DBHelper.OPRESTE_NRTRASEU, 102);
		contentValues.put(DBHelper.OPRESTE_TIPTRASEU, 1);
		db.insert(DBHelper.TABLE_OPRESTE, null, contentValues);
		
		System.out.println("-----udaptedDatabase");
		Log.d("TAG", "-----udaptedDatabase");
		
	}
	 //=============================================       
	
	// Read data from database - Traseu  table
	public List<Trasee> getTrasee() {
		SQLiteDatabase db = this.getReadableDatabase();
		List<Trasee> traseeList = new ArrayList<Trasee>();
		
		String selectQuery = "SELECT * FROM " + TABLE_TRASEU;
		
		System.out.println(selectQuery);
		
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		if(cursor.moveToFirst()) {
			do {
				Trasee trasee = new Trasee();
				trasee.setNrt(Integer.parseInt(cursor.getString(0)));
				trasee.setDurata(Integer.parseInt(cursor.getString(1)));
				trasee.setNrStStart(Integer.parseInt(cursor.getString(2)));
				trasee.setNrStEnd(Integer.parseInt(cursor.getString(3)));
				trasee.setNrc(Integer.parseInt(cursor.getString(4)));

				traseeList.add(trasee);
			} while (cursor.moveToNext());
		}
		return traseeList;
		
		
	}
	
	 //=============================================       

}
