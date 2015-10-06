package com.fortech.rulejaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MappingRuleJAXB {

	@XmlElement(required = true)
	private Long id;
	@XmlElement(required = true)
	private String vehicleAttribute;
	@XmlElement(required = true)
	private String sourceValue;
	@XmlElement(required = true)
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
