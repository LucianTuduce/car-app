package com.fortech.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.fortech.JPAmodels.MarketRule;
import com.fortech.JPAmodels.MarketRulePK;
import com.fortech.daria.utils.MarketRuleConvertor;
import com.fortech.rulejaxb.MarketRuleJAXB;


/**
 * Class that makes the connection between RESTful service and the entities
 * 
 * @author dariad
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MarketRuleService {

	@PersistenceContext(name = "car-application", type = PersistenceContextType.TRANSACTION)
	public EntityManager entity;

	/*
	 * Getting all the marketRule from the DB
	 */
	public List<MarketRuleJAXB> getAllMarketRule() {

		@SuppressWarnings("unchecked")
		TypedQuery<MarketRule> query = (TypedQuery<MarketRule>) entity.createQuery(
				MarketRule.MARKETRULE_FIND_ALL);
		List<MarketRule> marketRules = new ArrayList<MarketRule>(
				query.getResultList());

		List<MarketRuleJAXB> marketRulesC = new ArrayList<MarketRuleJAXB>();
		MarketRulePK markPK = new MarketRulePK();

		MarketRuleConvertor chg = new MarketRuleConvertor();

		for (MarketRule i : marketRules) {
			markPK = i.getId();
			MarketRuleJAXB j = new MarketRuleJAXB();
			j.setCountryNumber(markPK.getCountryNumber());
			j.setBranch(markPK.getBranch());
			j.setStockCategory(chg.changeShortToEnum(markPK.getStockCategory()));
			j.setActive(chg.changeShortToBoolean(i.getActive()));
			j.setRule(i.getRule());

			marketRulesC.add(j);

		}

		return marketRulesC;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void insertMarketRule(MarketRuleJAXB marketRule) {

		MarketRule rule = new MarketRule();
		MarketRulePK rulePK = new MarketRulePK();
		MarketRuleConvertor convertor = new MarketRuleConvertor();

		rulePK.setCountryNumber(marketRule.getCountryNumber());
		rulePK.setBranch(marketRule.getBranch());
		rulePK.setStockCategory(convertor.changeEnumToShort(marketRule.getStockCategory()));

		rule.setId(rulePK);
		rule.setActive(convertor.changeBooleanToShort(marketRule.isActive()));
		rule.setRule(marketRule.getRule());

		entity.getTransaction().begin();
		entity.persist(rule);
		entity.getTransaction().commit();

	}

}