package com.fortech.restDynamicObjectCreate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fortech.convertXMLtoJSON.Convertor;
import com.fortech.defaultobjects.DefaultInitialization;
import com.fortech.rule.MappingRule;
import com.fortech.rule.MarketRule;
import com.fortech.rulejaxb.MappingRuleJAXB;
import com.fortech.rulejaxb.MarketRuleJAXB;
import com.fortech.ruletype.RuleType;
import com.fortech.wrapper.WrapperRuleJAXB;

@Path("/test")
public class WrapRestTemplate {

	private static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
	
	@GET
	@Path("/xml")
	@Produces("application/xml")
	public List<WrapperRuleJAXB> getDefaultXMLWrapper() throws JAXBException {
		List<WrapperRuleJAXB> jaxbs = new ArrayList<WrapperRuleJAXB>();
		MappingRuleJAXB mappingRuleJAXB = DefaultInitialization
				.createDeafultMappingRuleJAXB();
		WrapperRuleJAXB wrapperRuleJAXB = DefaultInitialization
				.marshallMappingRulle(mappingRuleJAXB);
		jaxbs.add(wrapperRuleJAXB);

		MarketRuleJAXB marketRuleJAXB = DefaultInitialization
				.creteaDeafultMarketRuleJAXB();
		WrapperRuleJAXB marketWrapperKAXB = DefaultInitialization
				.marshallMarketRule(marketRuleJAXB);
		jaxbs.add(marketWrapperKAXB);
		return jaxbs;
	}
	
	@POST
	@Path("/jsonlist/mappingrule")
	@Consumes("application/json")
	public void displayJSONMappingRuleList(final List<MappingRule> mappingRules) {
		for (MappingRule map : mappingRules) {
			System.out.println(map.toString());
		}
	}

	@POST
	@Path("/jsonlist/marketrule")
	@Consumes("application/json")
	public void displayJSONMarketRuleList(final List<MarketRule> marketRules) {
		for (MarketRule market : marketRules) {
			System.out.println(market.toString());
		}
	}
	
	@POST
	@Path("/wrapper/xml")
	@Consumes("application/xml")
	public void createMarketRuleOrMappingRuleOrInterpretationRuleFromXMLWrapper(
			final List<WrapperRuleJAXB> ruleJAXBs) throws JAXBException {
		for (WrapperRuleJAXB jaxb : ruleJAXBs) {
			if (jaxb.getRuleType().equals(RuleType.INTERPRETATION)) {

				System.out.println("Do nothing in INTERPRETER");

			} else if (jaxb.getRuleType().equals(RuleType.MAPPING)) {

				StringReader sr = new StringReader(XML_VERSION
						+ jaxb.getJsonORxml());
				JAXBContext jaxbContext = JAXBContext
						.newInstance(MappingRuleJAXB.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				MappingRuleJAXB mappingRuleJAXB = (MappingRuleJAXB) unmarshaller
						.unmarshal(sr);
				System.out.println(mappingRuleJAXB.toString());

			} else if (jaxb.getRuleType().equals(RuleType.MARKET)) {

				StringReader sr = new StringReader(XML_VERSION
						+ jaxb.getJsonORxml());
				JAXBContext jaxbContext = JAXBContext
						.newInstance(MarketRuleJAXB.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				MarketRuleJAXB marketRuleJAXB = (MarketRuleJAXB) unmarshaller
						.unmarshal(sr);
				System.out.println(marketRuleJAXB.toString());
			}
		}

	}

	@POST
	@Path("/wrapper/json")
	@Consumes("application/json")
	public void createMarketRuleOrMappingRuleOrInterpretationRuleFromJSONWrapper(
			final List<WrapperRuleJAXB> wrapperRuleJAXBs)
			throws JsonParseException, JsonMappingException, IOException {
		for (WrapperRuleJAXB wrap : wrapperRuleJAXBs) {
			if (wrap.getRuleType().equals(RuleType.INTERPRETATION)) {

				System.out.println("Do nothing for interpretation");

			} else if (wrap.getRuleType().equals(RuleType.MAPPING)) {

				MappingRule mappingRule = new ObjectMapper().readValue(
						wrap.getJsonORxml(), MappingRule.class);
				System.out.println(mappingRule.toString());

			} else if (wrap.getRuleType().equals(RuleType.MARKET)) {

				MarketRule marketRule = new ObjectMapper().readValue(
						wrap.getJsonORxml(), MarketRule.class);
				System.out.println(marketRule.toString());

			}
		}
	}

	@GET
	@Path("/wrapper/data")
	@Produces("application/json")
	public List<WrapperRuleJAXB> getWrapperdDataForInserting()
			throws PropertyException, JAXBException {
		List<WrapperRuleJAXB> wrapperList = new ArrayList<WrapperRuleJAXB>();

		String map = Convertor.convertXMLtoJSON(DefaultInitialization
				.createDefaultMarshallMappingRuleJAXB());
		wrapperList.add(DefaultInitialization.createWrapperRuleForMappingRuleJAXB(map));
		String market = Convertor.convertXMLtoJSON(DefaultInitialization
				.createDefaultMarshallMarketRuleJAXB());
		wrapperList.add(DefaultInitialization.createWrapperRuleForMarketRulaJAXB(market));
		return wrapperList;
	}

	
}
