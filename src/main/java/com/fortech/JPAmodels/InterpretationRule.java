package com.fortech.JPAmodels;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "InterpretationRule" database table.
 * 
 */
@Entity
@Table(name="\"InterpretationRule\"")
@NamedQuery(name="InterpretationRule.findAll", query="SELECT i FROM InterpretationRule i")
public class InterpretationRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"id\"")
	private int id;

	//bi-directional many-to-one association to InterpretationInnerRule
	@OneToMany(mappedBy="interpretationRule")
	private List<InterpretationInnerRule> interpretationInnerRules;

	//bi-directional many-to-one association to TargetVehicle
	@OneToMany(mappedBy="interpretationRule")
	private List<TargetVehicle> targetVehicles;

	public InterpretationRule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<InterpretationInnerRule> getInterpretationInnerRules() {
		return this.interpretationInnerRules;
	}

	public void setInterpretationInnerRules(List<InterpretationInnerRule> interpretationInnerRules) {
		this.interpretationInnerRules = interpretationInnerRules;
	}

	public InterpretationInnerRule addInterpretationInnerRule(InterpretationInnerRule interpretationInnerRule) {
		getInterpretationInnerRules().add(interpretationInnerRule);
		interpretationInnerRule.setInterpretationRule(this);

		return interpretationInnerRule;
	}

	public InterpretationInnerRule removeInterpretationInnerRule(InterpretationInnerRule interpretationInnerRule) {
		getInterpretationInnerRules().remove(interpretationInnerRule);
		interpretationInnerRule.setInterpretationRule(null);

		return interpretationInnerRule;
	}

	public List<TargetVehicle> getTargetVehicles() {
		return this.targetVehicles;
	}

	public void setTargetVehicles(List<TargetVehicle> targetVehicles) {
		this.targetVehicles = targetVehicles;
	}

	public TargetVehicle addTargetVehicle(TargetVehicle targetVehicle) {
		getTargetVehicles().add(targetVehicle);
		targetVehicle.setInterpretationRule(this);

		return targetVehicle;
	}

	public TargetVehicle removeTargetVehicle(TargetVehicle targetVehicle) {
		getTargetVehicles().remove(targetVehicle);
		targetVehicle.setInterpretationRule(null);

		return targetVehicle;
	}

}