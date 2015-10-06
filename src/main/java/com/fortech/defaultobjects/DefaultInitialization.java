package com.fortech.defaultobjects;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import com.fortech.enumcategory.StockCategory;
import com.fortech.rule.MappingRule;
import com.fortech.rule.MarketRule;
import com.fortech.rulejaxb.MappingRuleJAXB;
import com.fortech.rulejaxb.MarketRuleJAXB;
import com.fortech.ruletype.RuleType;
import com.fortech.wrapper.WrapperRuleJAXB;

public class DefaultInitialization {

	public static MarketRule createDefaultMarketRuleJSON() {
		MarketRule marketRule = new MarketRule();
		marketRule.setActive(false);
		marketRule.setBranch(14);
		marketRule.setCountryNumber("BH-93-TUD");
		marketRule.setRule("private");
		marketRule.setStockCategory(StockCategory.USED);
		return marketRule;
	}

	public static MappingRule createDeafultMappingRuleJSON() {
		MappingRule mappingRule = new MappingRule();
		mappingRule.setId((long) 3);
		mappingRule.setSourceValue("3000");
		mappingRule.setTargetValue("4999");
		mappingRule.setVehicleAttribute("good");
		return mappingRule;
	}

	public static MarketRuleJAXB creteaDeafultMarketRuleJAXB() {
		MarketRuleJAXB marketRuleJAXB = new MarketRuleJAXB();
		marketRuleJAXB.setActive(true);
		marketRuleJAXB.setBranch(12);
		marketRuleJAXB.setCountryNumber("BH-20-ATD");
		marketRuleJAXB.setRule("work");
		marketRuleJAXB.setStockCategory(StockCategory.NEW);
		return marketRuleJAXB;
	}

	public static MappingRuleJAXB createDeafultMappingRuleJAXB() {
		MappingRuleJAXB mappingRuleJAXB = new MappingRuleJAXB();
		mappingRuleJAXB.setId((long) 1);
		mappingRuleJAXB.setSourceValue("2000");
		mappingRuleJAXB.setTargetValue("2500");
		mappingRuleJAXB.setVehicleAttribute("working");
		return mappingRuleJAXB;
	}

	public static WrapperRuleJAXB marshallMarketRule(
			final MarketRuleJAXB marketRuleJAXB) throws JAXBException,
			PropertyException {
		String xml = getXMLStringForMarketRuleJAXB(marketRuleJAXB);
		WrapperRuleJAXB marketWrapperKAXB = createWrapperRuleMarketJAXB(xml);
		return marketWrapperKAXB;
	}

	private static WrapperRuleJAXB createWrapperRuleMarketJAXB(final String xml) {
		WrapperRuleJAXB marketWrapperKAXB = new WrapperRuleJAXB();
		marketWrapperKAXB.setRuleType(RuleType.MARKET);
		marketWrapperKAXB.setJsonORxml(xml);
		return marketWrapperKAXB;
	}

	private static String getXMLStringForMarketRuleJAXB(
			final MarketRuleJAXB marketRuleJAXB) throws JAXBException,
			PropertyException {
		JAXBContext jaxbContext = JAXBContext.newInstance(MarketRuleJAXB.class);
		StringWriter stringWriter = new StringWriter();
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(marketRuleJAXB, stringWriter);
		String xml = stringWriter.toString();
		return xml;
	}

	public static WrapperRuleJAXB marshallMappingRulle(
			final MappingRuleJAXB mappingRuleJAXB) throws JAXBException,
			PropertyException {
		String xml = getXMLStringForMappingRuleJAXB(mappingRuleJAXB);
		WrapperRuleJAXB wrapperRuleJAXB = createWrapperRuleMappingJAXB(xml);
		return wrapperRuleJAXB;
	}

	private static String getXMLStringForMappingRuleJAXB(
			final MappingRuleJAXB mappingRuleJAXB) throws JAXBException,
			PropertyException {
		JAXBContext jaxbContext = JAXBContext
				.newInstance(MappingRuleJAXB.class);
		StringWriter stringWriter = new StringWriter();
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(mappingRuleJAXB, stringWriter);
		String xml = stringWriter.toString();
		return xml;
	}
	
	private static WrapperRuleJAXB createWrapperRuleMappingJAXB(final String xml) {
		WrapperRuleJAXB wrapperRuleJAXB = new WrapperRuleJAXB();
		wrapperRuleJAXB.setRuleType(RuleType.MAPPING);
		wrapperRuleJAXB.setJsonORxml(xml);
		return wrapperRuleJAXB;
	}
	
	public static String createDefaultMarshallMappingRuleJAXB() throws JAXBException{
		MappingRuleJAXB mappingRuleJAXB = createDeafultMappingRuleJAXB();
		JAXBContext jaxbContext = JAXBContext.newInstance(MappingRuleJAXB.class);
		StringWriter stringWriter = new StringWriter();
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(mappingRuleJAXB, stringWriter);
		String xml = stringWriter.toString();
		return xml;
	}
	
	public static String createDefaultMarshallMarketRuleJAXB() throws JAXBException{
		MarketRuleJAXB marketRuleJAXB = creteaDeafultMarketRuleJAXB();
		JAXBContext jaxbContext = JAXBContext.newInstance(MarketRuleJAXB.class);
		StringWriter stringWriter = new StringWriter();
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(marketRuleJAXB, stringWriter);
		String xml = stringWriter.toString();
		return xml;
	}
	
	
	public static WrapperRuleJAXB createWrapperRuleForMarketRulaJAXB(final String market) {
		WrapperRuleJAXB wrapperRuleJAXB2 = new WrapperRuleJAXB();
		wrapperRuleJAXB2.setRuleType(RuleType.MARKET);
		wrapperRuleJAXB2.setJsonORxml(market);
		return wrapperRuleJAXB2;
	}

	public static WrapperRuleJAXB createWrapperRuleForMappingRuleJAXB(final String map) {
		WrapperRuleJAXB wrapperRuleJAXB = new WrapperRuleJAXB();
		wrapperRuleJAXB.setRuleType(RuleType.MAPPING);
		wrapperRuleJAXB.setJsonORxml(map);
		return wrapperRuleJAXB;
	}

}