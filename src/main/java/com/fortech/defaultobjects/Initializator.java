package com.fortech.defaultobjects;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

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
	
}
