package com.fortech.JPAmodels;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "TargetVehicle" database table.
 * 
 */
@Entity
@Table(name="\"TargetVehicle\"")
@NamedQuery(name="TargetVehicle.findAll", query="SELECT t FROM TargetVehicle t")
public class TargetVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"id\"")
	private int id;

	@Column(name="\"ruleId\"")
	private int ruleId;

	@Column(name="\"vehicleAttribute\"")
	private String vehicleAttribute;

	@Column(name="\"vehicleAttributeValue\"")
	private String vehicleAttributeValue;

	//bi-directional many-to-one association to InterpretationRule
	@ManyToOne
	@JoinColumn(name="\"id\"")
	private InterpretationRule interpretationRule;

	public TargetVehicle() {
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

	public String getVehicleAttributeValue() {
		return this.vehicleAttributeValue;
	}

	public void setVehicleAttributeValue(String vehicleAttributeValue) {
		this.vehicleAttributeValue = vehicleAttributeValue;
	}

	public InterpretationRule getInterpretationRule() {
		return this.interpretationRule;
	}

	public void setInterpretationRule(InterpretationRule interpretationRule) {
		this.interpretationRule = interpretationRule;
	}

}