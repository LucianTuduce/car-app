package com.fortech.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fortech.defaultobjects.DefaultInitialization;
import com.fortech.rule.MappingRule;
import com.fortech.rule.MarketRule;
import com.fortech.rulejaxb.MappingRuleJAXB;
import com.fortech.rulejaxb.MarketRuleJAXB;
import com.fortech.wrapper.WrapperRuleJAXB;

@Path("/rule")
public class RuleRestService {	

	@GET
	@Path("/mapping/xml/{idMapppingRule}")
	@Produces("application/xml")
	public MappingRuleJAXB getXMLMappingRule(
			@PathParam("idMapppingRule") int idMapppingRule) {
		return DefaultInitialization.createDeafultMappingRuleJAXB();
	}

	@GET
	@Path("/market/xml/{idMarketRule}")
	@Produces("application/xml")
	public MarketRuleJAXB getXMLMarketRule(
			@PathParam("idMarketRule") int idMarketRule) {
		return DefaultInitialization.creteaDeafultMarketRuleJAXB();
	}

	@GET
	@Path("/mapping/json/{idMapppingRule}")
	@Produces("application/json")
	public MappingRule getJSONMappingRule(
			@PathParam("idMapppingRule") int idMapppingRule) {
		return DefaultInitialization.createDeafultMappingRuleJSON();
	}

	@GET
	@Path("/market/json/{idMarketRule}")
	@Produces("application/json")
	public MarketRule getJSONMarketRule(
			@PathParam("idMarketRule") int idMarketRule) {
		return DefaultInitialization.createDefaultMarketRuleJSON();
	}
	
	@POST
	@Path("/addjson")
	@Consumes("application/json")
	public Response insertInDatabaseNewRulesJSON(final List<WrapperRuleJAXB> wrappers){
		String data = "";
		for(WrapperRuleJAXB wrap: wrappers){
			data = data + " " +wrap.toString();
		}
		return Response.status(200).entity(data).build();
	}
	
	
	@POST
	@Path("/addxml")
	@Consumes("application/xml")
	public Response insertInDatabaseNewRulesXML(final List<WrapperRuleJAXB> wrappers){
		String data = "";
		for(WrapperRuleJAXB wrap: wrappers){
			data = data + " " +wrap.toString();
		}
		return Response.status(200).entity(data).build();
	}
	
}
