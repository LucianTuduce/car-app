package com.fortech.daria.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fortech.daria.model.MarketRules;
import com.fortech.daria.transform.MarketRuleTrsFromToJson;
import com.fortech.daria.transform.MarketRuleTrsFromToXML;
import com.fortech.defaultobjects.Initializator;
import com.fortech.enumcategory.StockCategory;
import com.fortech.rulejaxb.MarketRuleJAXB;
import com.fortech.service.MarketRuleService;
import com.fortech.wrapper.WrapperRuleJAXB;


/**
 * Class that is used as a REST service class. In here the communication with
 * the web is made.
 * 
 * @author dariad
 *
 */
@Stateless
@Path("/rules")
public class RuleRESTfulServices {

	@EJB
	private MarketRuleService marketRuleService;

	/**
	 * method that return to the web all the rules with the type ruleType in the
	 * format xmlORjson asked
	 * 
	 * @param xmlORjson
	 *            The format in with the rules will be returned
	 * @param ruleType
	 *            The type of the rule
	 * @return a list of WrapperRule with all the rules got from db
	 */
	@GET
	@Path("/{xmlORjson}/{ruleType}")
	@Produces({ "application/xml", "application/json" })
	public List<WrapperRuleJAXB> getRules(
			@PathParam("xmlORjson") String xmlORjson,
			@PathParam("ruleType") String ruleType) {

		List<WrapperRuleJAXB> rules = new ArrayList<WrapperRuleJAXB>();
		List<MarketRuleJAXB> marketRuleJaxB = new ArrayList<MarketRuleJAXB>();

		if (ruleType.equals("market")) {
			marketRuleJaxB = marketRuleService.getAllMarketRule();
			if (xmlORjson.equals("xml")) {
				for (MarketRuleJAXB market : marketRuleJaxB) {
					rules.add(Initializator
							.createXMLWrapperRuleForMarketRuleJAXB(market));
				}

			} else if (xmlORjson.equals("json")) {
				for (MarketRuleJAXB market : marketRuleJaxB) {
					rules.add(Initializator
							.createJSONWrapperRuleForMarketRule(market));
				}
			}
		}
		// else if (ruleType.equals("mapping")) {
		// if (xmlORjson.equals("xml")) {
		//
		// } else if (xmlORjson.equals("json")) {
		//
		// }
		// } else if (ruleType.equals("interpretation")) {
		// if (xmlORjson.equals("xml")) {
		//
		// } else if (xmlORjson.equals("json")) {
		//
		// }

		return rules;
	}
	
	 @GET
	 @Path("/generate")
	 @Produces("application/json")
	 public MarketRules getAllMarketRules() {
	
	 MarketRules r = new MarketRules();
	 r.setActive(false);
	 r.setBranch(52);
	 r.setCountryNumber("125");
	 r.setRule("car has a missing dor");
	 r.setStockCategory(StockCategory.USED);
	
	 return r;
	
	 }

	@GET
	@Path("/generateW")
	@Produces("application/xml")
	public WrapperRuleJAXB getWrapperRule() {

		MarketRuleJAXB market = new MarketRuleJAXB();
		market.setActive(true);
		market.setBranch(120);
		market.setCountryNumber("259");
		market.setRule("car 4 dors");
		market.setStockCategory(StockCategory.USED);

		WrapperRuleJAXB r = Initializator.createXMLWrapperRuleForMarketRuleJAXB(market);
		return r;

	}

	/**
	 * Method that takes a rule from web and send it to the service to be put to
	 * DB
	 * 
	 * @param marketRules
	 */
	@POST
	@Path("/add")
	@Consumes({ "application/xml", "application/json" })
	public void postRule(WrapperRuleJAXB wrapperRuleJaxB) {

		MarketRuleJAXB marketRule = new MarketRuleJAXB();
		
		System.out.println(wrapperRuleJaxB.getRuleType());

		if (wrapperRuleJaxB.getRuleType().equals("market")) {
			if (wrapperRuleJaxB.getJsonORxml().startsWith("<")) {
				// xml format
				marketRule = MarketRuleTrsFromToXML
						.transfromXML(wrapperRuleJaxB.getJsonORxml());
				marketRuleService.insertMarketRule(marketRule);
			}

		} else {
			marketRule = MarketRuleTrsFromToJson.transfromJson(wrapperRuleJaxB
					.getJsonORxml());
			marketRuleService.insertMarketRule(marketRule);
		}
	}

}

