package com.fortech.JPAmodels;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the "MarketRule" database table.
 * 
 */
@Entity
@Table(name="\"MarketRule\"", schema="DARIAD")
@NamedQuery(name="MarketRule.findAll", query="SELECT m FROM MarketRule m")
public class MarketRule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String MARKETRULE_FIND_ALL = "MarketRule.findAll";

	@EmbeddedId
	private MarketRulePK id;

	@Column(name="\"active\"", nullable=false)
	private short active;

	@Column(name="\"rule\"", length=45)
	private String rule;

	public MarketRule() {
	}

	public MarketRulePK getId() {
		return this.id;
	}

	public void setId(MarketRulePK id) {
		this.id = id;
	}

	public short getActive() {
		return this.active;
	}

	public void setActive(short active) {
		this.active = active;
	}

	public String getRule() {
		return this.rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

}