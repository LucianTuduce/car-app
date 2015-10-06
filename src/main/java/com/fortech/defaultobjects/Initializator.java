package com.fortech.defaultobjects;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.fortech.daria.transform.MarketRuleTrsFromToJson;
import com.fortech.daria.transform.MarketRuleTrsFromToXML;
import com.fortech.rulejaxb.MarketRuleJAXB;
import com.fortech.ruletype.RuleType;
import com.fortech.wrapper.WrapperRuleJAXB;

public class Initializator {

	public static WrapperRuleJAXB createJSONWrapperRuleForMarketRule()
			throws IOException, JsonGenerationException, JsonMappingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String rule = ow.writeValueAsString(DefaultInitialization.createDefaultMarketRuleJSON());
		WrapperRuleJAXB wrapperRuleJAXB = DefaultInitialization.createWrapperRuleForMarketRulaJAXB(rule);
		return wrapperRuleJAXB;
	}

	public static WrapperRuleJAXB createJSONWrapperRuleForMappingRule() throws IOException, JsonGenerationException, JsonMappingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String rule = ow.writeValueAsString(DefaultInitialization.createDeafultMappingRuleJSON());
		WrapperRuleJAXB wrapperRuleJAXB = DefaultInitialization.createWrapperRuleForMappingRuleJAXB(rule);
		return wrapperRuleJAXB;
	}

	public static WrapperRuleJAXB createXMLWapperRuleForMappingRuleJAXB() throws JAXBException {
		String rule = DefaultInitialization.createDefaultMarshallMappingRuleJAXB();
		WrapperRuleJAXB wrapperRuleJAXB = DefaultInitialization.createWrapperRuleForMappingRuleJAXB(rule);
		return wrapperRuleJAXB;
	}
		
	public static WrapperRuleJAXB createXMLWrapperRuleForMarketRuleJAXB()
			throws JAXBException {
		String rule = DefaultInitialization.createDefaultMarshallMarketRuleJAXB();
		WrapperRuleJAXB wrapperRuleJAXB = DefaultInitialization.createWrapperRuleForMarketRulaJAXB(rule);
		return wrapperRuleJAXB;
	}
	
	/*
	 * The method creates an object WrapperRule(with the String jsonORxml in the
	 * format xml that it's asked) from a marketRuleJAXB
	 */
	public static WrapperRuleJAXB createXMLWrapperRuleForMarketRuleJAXB(
			MarketRuleJAXB marketRuleJaxB) {

		WrapperRuleJAXB wrapperRule = new WrapperRuleJAXB();

		String jsonORxml = new String();

		try {
			jsonORxml = MarketRuleTrsFromToXML.transToXML(marketRuleJaxB);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		wrapperRule.setRuleType(RuleType.MARKET);
		wrapperRule.setJsonORxml(jsonORxml);

		return wrapperRule;
	}

	/*
	 * The method creates an object WrapperRule(with the String jsonORxml in the
	 * format json that it's asked) from a marketRuleJAXB
	 */
	public static WrapperRuleJAXB createJSONWrapperRuleForMarketRule(
			MarketRuleJAXB marketRuleJaxB) {

		WrapperRuleJAXB wrapperRule = new WrapperRuleJAXB();

		String jsonORxml = new String();

		jsonORxml = MarketRuleTrsFromToJson.transToJson(marketRuleJaxB);

		wrapperRule.setRuleType(RuleType.MARKET);
		wrapperRule.setJsonORxml(jsonORxml);

		return wrapperRule;
	}
	
}
