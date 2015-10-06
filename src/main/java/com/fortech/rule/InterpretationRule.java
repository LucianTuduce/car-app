package com.fortech.rule;

import java.util.List;

import com.fortech.properties.CarAttribute;
import com.fortech.properties.InterpretationInnerRule;

public class InterpretationRule {

	private Long id;
	private List<CarAttribute> vehicleAttribute;
	private List<InterpretationInnerRule> rules;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<CarAttribute> getVehicleAttribute() {
		return vehicleAttribute;
	}
	public void setVehicleAttribute(List<CarAttribute> vehicleAttribute) {
		this.vehicleAttribute = vehicleAttribute;
	}
	public List<InterpretationInnerRule> getRules() {
		return rules;
	}
	public void setRules(List<InterpretationInnerRule> rules) {
		this.rules = rules;
	}
	
}
