package com.fortech.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.fortech.defaultobjects.Initializator;
import com.fortech.service.MarketRuleService;
import com.fortech.wrapper.WrapperRuleJAXB;

@Path("/rule")
@Stateless
public class RuleRESTfulService {
	
	@EJB
	private MarketRuleService marketRuleService;
	
	@GET
	@Path("/get")
	public Response getResponse(){
		return Response.status(200).entity(marketRuleService.printCeva()).build();
	}
	
	@GET
	@Path("/as")
	public String getResponse1(){
		return "sadfasdfsad";
	}
	
	@GET
	@Path("/{ruleType}/{xmlORjson}/{idRule}")
	@Produces({ "application/json", "application/xml" })
	public List<WrapperRuleJAXB> getRule(
			@PathParam("xmlORjson") String xmlORjson,
			@PathParam("ruleType") String ruleType,
			@PathParam("idRule") Long idRule) throws JAXBException,
			JsonGenerationException, JsonMappingException, IOException {
		
		List<WrapperRuleJAXB> rules = new ArrayList<WrapperRuleJAXB>();
		if (xmlORjson.equals("xml")) {
			if (ruleType.equals("mapping")) {
				rules.add(Initializator.createXMLWapperRuleForMappingRuleJAXB());
			}
		} else if (xmlORjson.equals("json")) {
			if (ruleType.equals("mapping")) {
				rules.add(Initializator.createJSONWrapperRuleForMappingRule());
			}
		}
		if (xmlORjson.equals("xml")) {
			if (ruleType.equals("market")) {
				rules.add(Initializator.createXMLWrapperRuleForMarketRuleJAXB());
			}
		} else if (xmlORjson.equals("json")) {
			if (ruleType.equals("market")) {
				rules.add(Initializator.createJSONWrapperRuleForMarketRule());
			}
		}
		marketRuleService.printCeva();
		return rules;
	}

	@GET
	@Path("/{xmlORjson}/{ruleType}")
	@Produces({ "application/xml", "application/json" })
	public List<WrapperRuleJAXB> getRules(
			@PathParam("xmlORjson") String xmlORjson,
			@PathParam("ruleType") String ruleType) throws JAXBException,
			JsonGenerationException, JsonMappingException, IOException {
		
		List<WrapperRuleJAXB> rules = new ArrayList<WrapperRuleJAXB>();
		if (xmlORjson.equals("xml")) {
			if (ruleType.equals("mapping")) {
				rules.add(Initializator.createXMLWapperRuleForMappingRuleJAXB());
				rules.add(Initializator.createXMLWapperRuleForMappingRuleJAXB());
			}
		} else if (xmlORjson.equals("json")) {
			if (ruleType.equals("mapping")) {
				rules.add(Initializator.createJSONWrapperRuleForMappingRule());
				rules.add(Initializator.createJSONWrapperRuleForMappingRule());
			}
		}
		if (xmlORjson.equals("xml")) {
			if (ruleType.equals("market")) {
				rules.add(Initializator.createXMLWrapperRuleForMarketRuleJAXB());
				rules.add(Initializator.createXMLWrapperRuleForMarketRuleJAXB());
			}
		} else if (xmlORjson.equals("json")) {
			if (ruleType.equals("market")) {
				rules.add(Initializator.createJSONWrapperRuleForMarketRule());
				rules.add(Initializator.createJSONWrapperRuleForMarketRule());
			}
		}
		return rules;
	}
	
	@DELETE
	@Path("/{ruleType}/{id}")
	public Response deleteRuleFromDatavaseThatHasId(@PathParam("ruleType") String ruleType, @PathParam("id") Long id){
		if(ruleType.equals("mapping")){
			return Response.status(200).entity("Deleted mapping rule with id: "+ id).build();
		}else if(ruleType.equals("market")){
			return Response.status(200).entity("Deleted market rule with id: "+ id).build();
		}else if(ruleType.equals("interpretation")){
			return Response.status(200).entity("Deleted interpretation rule with id: "+ id).build();
		}
		return Response.status(500).entity("FAILED to delete rule").build();
	}
	
	@PUT
	@Path("/{ruleType}/{id}")
	@Consumes({ "application/xml", "application/json" })
	public Response updateRuleInDatabase(@PathParam("ruleType") String ruleType, @PathParam("id") Long id, WrapperRuleJAXB wrapperRuleJAXB){
		if(ruleType.equals("mapping")){
			return Response.status(200).entity("Updated mapping rule with id: "+id+" and data "+ wrapperRuleJAXB.toString()).build();
		}else if(ruleType.equals("market")){
			return Response.status(200).entity("Updated market rule with id: "+id+" and data "+ wrapperRuleJAXB.toString()).build();
		}else if(ruleType.equals("interpretation")){
			return Response.status(200).entity("Updated interpreter rule with id: "+id+" and data "+ wrapperRuleJAXB.toString()).build();
		}
		return Response.status(500).entity("FAILED to update rule").build();
	}
	
	@POST
	@Path("/{ruleType}")
	@Consumes({ "application/xml", "application/json" })
	public Response addNewRuleInDatabase(@PathParam("ruleType") String ruleType, WrapperRuleJAXB wrapperRuleJAXB){
		if(ruleType.equals("mapping")){
			return Response.status(200).entity("Added mapping rule with the following data "+ wrapperRuleJAXB.toString()).build();
		}else if(ruleType.equals("market")){
			return Response.status(200).entity("Added market rule with following data data "+ wrapperRuleJAXB.toString()).build();
		}else if(ruleType.equals("interpretation")){
			return Response.status(200).entity("Added interpreter rule with following data "+ wrapperRuleJAXB.toString()).build();
		}
		return Response.status(500).entity("FAILED to add new rule").build();
	}
	
}
