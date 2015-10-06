package com.fortech.service;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MarketRuleService {
	
	@PersistenceContext(unitName="car-application")
	private EntityManager entityManager;
	
	public String printCeva(){
		System.out.println("INJECT ceva dsdaawew");
		return "INJECT ceva dsdaa";
	}
}
