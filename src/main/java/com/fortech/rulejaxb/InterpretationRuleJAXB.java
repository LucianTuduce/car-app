package com.fortech.rulejaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fortech.properties.CarAttribute;
import com.fortech.properties.InterpretationInnerRule;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InterpretationRuleJAXB {

	@XmlElement(required = true)
	private Long id;
	@XmlElement
	private List<CarAttribute> vehicleAttribute;
	@XmlElement
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
