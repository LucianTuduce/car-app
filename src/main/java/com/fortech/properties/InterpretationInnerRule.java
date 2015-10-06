package com.fortech.properties;

import java.util.List;

public class InterpretationInnerRule {

	private Long id;
	private String vehicleAttribute;
	private List<String> vehicleAttributeValues;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVehicleAttribute() {
		return vehicleAttribute;
	}
	public void setVehicleAttribute(String vehicleAttribute) {
		this.vehicleAttribute = vehicleAttribute;
	}
	public List<String> getVehicleAttributeValues() {
		return vehicleAttributeValues;
	}
	public void setVehicleAttributeValues(List<String> vehicleAttributeValues) {
		this.vehicleAttributeValues = vehicleAttributeValues;
	}
	
}
