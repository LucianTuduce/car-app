package com.fortech.JPAmodels;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "InterpretationInnerRule" database table.
 * 
 */
@Entity
@Table(name="\"InterpretationInnerRule\"")
@NamedQuery(name="InterpretationInnerRule.findAll", query="SELECT i FROM InterpretationInnerRule i")
public class InterpretationInnerRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"id\"")
	private int id;

	@Column(name="\"ruleId\"")
	private int ruleId;

	@Column(name="\"vehicleAttribute\"")
	private String vehicleAttribute;

	@Column(name="\"vehicleAttributeValues\"")
	private String vehicleAttributeValues;

	//bi-directional many-to-one association to InterpretationRule
	@ManyToOne
	@JoinColumn(name="\"id\"")
	private InterpretationRule interpretationRule;

	public InterpretationInnerRule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRuleId() {
		return this.ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public String getVehicleAttribute() {
		return this.vehicleAttribute;
	}

	public void setVehicleAttribute(String vehicleAttribute) {
		this.vehicleAttribute = vehicleAttribute;
	}

	public String getVehicleAttributeValues() {
		return this.vehicleAttributeValues;
	}

	public void setVehicleAttributeValues(String vehicleAttributeValues) {
		this.vehicleAttributeValues = vehicleAttributeValues;
	}

	public InterpretationRule getInterpretationRule() {
		return this.interpretationRule;
	}

	public void setInterpretationRule(InterpretationRule interpretationRule) {
		this.interpretationRule = interpretationRule;
	}

}