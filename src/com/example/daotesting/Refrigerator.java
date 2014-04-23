package com.example.daotesting;

public class Refrigerator {
	//private variables
    private int unique_id;
    private String model_id;
    private String equipment_tracking_id;
    
     
    // Constructor
    public Refrigerator(int _unique_id, String _model_id, String _equipment_tracking_id){
        this.unique_id = _unique_id;
        this.model_id = _model_id;
        this.equipment_tracking_id = _equipment_tracking_id;
    }
     
    // get unique id
    public int getUniqueID(){
        return this.unique_id;
    }
     
    // set unique id
    public void setUniqueID(int id){
        this.unique_id = id;
    }
     
    // get model id
    public String getModelID(){
        return this.model_id;
    }
     
    // set model id
    public void setName(String modelID){
        this.model_id = modelID;
    }
     
    // get equipment tracking id
    public String getEquipmentTrackingID(){
        return this.equipment_tracking_id;
    }
     
    // set equipment tracking id
    public void setEquipmentTrackingID(String equipmentTrackingID){
        this.equipment_tracking_id = equipmentTrackingID;
    }
}
