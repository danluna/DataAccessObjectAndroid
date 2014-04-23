package com.example.daotesting;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FridgeDBHandler extends SQLiteOpenHelper {
	
	// Database Version
	private static final int DATABASE_VERSION = 1;
	
	// Database Name
	private static final String DATABASE_NAME = "refrigeratorsManager";
	
	// Table Name
	private static final String TABLE_NAME = "refrigerators";
	
	// Column names
	private static final String UNIQUE_ID = "UniqueID";
	private static final String MODEL_ID = "ModelID";
	private static final String EQUIPMENT_TRACKING_ID ="EquipmentTrackingID";
	
	
	public FridgeDBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + UNIQUE_ID + " INTEGER PRIMARY KEY," + MODEL_ID + " TEXT,"
                + EQUIPMENT_TRACKING_ID + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	// Add new refrigerator
	public void addRefrigerator(Refrigerator fridge) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		
		values.put(UNIQUE_ID, fridge.getUniqueID());
		values.put(MODEL_ID, fridge.getModelID());
		values.put(EQUIPMENT_TRACKING_ID, fridge.getEquipmentTrackingID());
		
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	
	// Get a single refrigerator
	public Refrigerator getRefrigerator(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_NAME, new String[] { UNIQUE_ID, MODEL_ID, EQUIPMENT_TRACKING_ID },
	            UNIQUE_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
		
		// Check for null Cursor
		if (cursor != null) {
			// Move cursor to the first row of the table
			cursor.moveToFirst();
		}
		
		// Create the Refrigerator to be passed back
		Refrigerator fridge = new Refrigerator(Integer.parseInt(
											   cursor.getString(0)),
	            			  				   cursor.getString(1), 
	            			  				   cursor.getString(2));
		
		return fridge;
	}
	
	// Get all of the Refrigerators
	public List<Refrigerator> getAllRefrigerators() {
		return new ArrayList<Refrigerator>();
		
	}
	
	// Update a Refrigerator and return the number of rows affected
	public int updateRefrigerator(Refrigerator fridge) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(UNIQUE_ID, fridge.getUniqueID());
		values.put(MODEL_ID, fridge.getModelID());
		values.put(EQUIPMENT_TRACKING_ID, fridge.getEquipmentTrackingID());
	    
		// Update the specified row(s) specified by the Refrigerator instance
		int rowsAffected = db.update(TABLE_NAME, values, UNIQUE_ID + " = ?",
									 new String[] { String.valueOf(fridge.getUniqueID())} );
		db.close();
		
		return rowsAffected;
	}
	
	// Delete a Refrigerator
	public void deleteRefrigerator(Refrigerator fridge) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		// Delete the specified Refrigerator
	    db.delete(TABLE_NAME, UNIQUE_ID + " = ?",
	    		new String[] { String.valueOf(fridge.getUniqueID())} );
	    db.close();
	}
}
