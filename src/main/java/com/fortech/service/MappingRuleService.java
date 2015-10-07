package com.fortech.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.fortech.JPAmodels.MappingRule;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MappingRuleService {

	@PersistenceContext(name = "car-application", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void insertInDB(MappingRule mappingRule){
		entityManager.getTransaction().begin();
		entityManager.persist(mappingRule);
		entityManager.getTransaction().commit();
	}
}
