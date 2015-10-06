package com.fortech.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InterpreterRuleService {

	@PersistenceContext
	private EntityManager entityManager;
	
}
