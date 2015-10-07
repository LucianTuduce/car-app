package com.fortech.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fortech.JPAmodels.MappingRule;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MappingRuleService {

	@PersistenceContext(unitName="car-application")
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void insertInDB(MappingRule mappingRule){
		entityManager.persist(mappingRule);
	}
}
