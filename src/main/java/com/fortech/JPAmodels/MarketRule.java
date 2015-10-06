package com.fortech.JPAmodels;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "MarketRule" database table.
 * 
 */
@Entity
@Table(name="\"MarketRule\"")
@NamedQuery(name="MarketRule.findAll", query="SELECT m FROM MarketRule m")
public class MarketRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MarketRulePK id;

	@Column(name="\"active\"")
	private short active;

	@Column(name="\"rule\"")
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