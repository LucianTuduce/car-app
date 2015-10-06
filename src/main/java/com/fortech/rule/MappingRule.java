package com.fortech.rule;


public class MappingRule {


	private Long id;
	private String vehicleAttribute;
	private String sourceValue;
	private String targetValue;
	
	
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
	public String getSourceValue() {
		return sourceValue;
	}
	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}
	public String getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}
	
	public String toString(){
		return "[ "+id+" "+vehicleAttribute+" "+sourceValue+" "+targetValue+" ]";
	}
	
}
