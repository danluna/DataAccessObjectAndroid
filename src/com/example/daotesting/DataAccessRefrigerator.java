// This is a Data Access Object class.
// This purpose of this class is to provide
// and abstraction of the data storage to
// the client. The client need worry only about
// using these simple methods to complete 
// database actions. The rest of the technical
// database work will be done between this data
// accessor and the database handler class
// FridgeDBHandler. 

package com.example.daotesting;
import android.content.Context;

public class DataAccessRefrigerator implements DataAccessObjectRefrigerator {

	private FridgeDBHandler fridgeDB;
	
	// Data Access constructor
	DataAccessRefrigerator(Context context) {
		this.fridgeDB = new FridgeDBHandler(context);
	}
	
	// Inserts a Refrigerator
	public void insertRefrigerator(Refrigerator r) {
		this.fridgeDB.addRefrigerator(r);
	}
	
	// Deletes the passed in Refrigerator
	public void deleteRefrigerator(Refrigerator r) {
		this.fridgeDB.deleteRefrigerator(r);
	}

	// Returns the number of Refrigerator rows updated
	public int updateRefrigerator(Refrigerator r) {
		return this.fridgeDB.updateRefrigerator(r);
	}
	
	// Returns the Refrigerator with identification of 'id'
	public Refrigerator getRefrigerator(int id) {
		return this.fridgeDB.getRefrigerator(id);
	}

}
