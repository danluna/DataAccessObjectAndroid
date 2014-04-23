package com.example.daotesting;

// Interface which all Refrigerator Data Access Objects must support
public interface DataAccessObjectRefrigerator {
	
	public void insertRefrigerator(Refrigerator r);
	public void deleteRefrigerator(Refrigerator r);
	public int updateRefrigerator(Refrigerator r);
	public Refrigerator getRefrigerator(int id);
}
