package com.fortech.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fortech.rule.InterpretationRule;
import com.fortech.rulejaxb.InterpretationRuleJAXB;
import com.fortech.wrapper.WrapperRuleJAXB;

@Path("/service/interpretation")
public class InterpretationRuleRestService {

	@GET
	@Path("/allxml")
	@Produces("application/xml")
	public List<InterpretationRuleJAXB> getAllXMLInterpretationRuleJAXB(){
		return null;
	}
	
	@GET
	@Path("/alljson")
	@Produces("application/json")
	public List<InterpretationRule> getAllJSONInterpretationRule(){
		return null;
	}
		
	@GET
	@Path("/onexml/{idWrapperRule}")
	@Produces("application/xml")
	public InterpretationRuleJAXB getOneXMLInterpretationRuleJAXB(@PathParam("idWrapperRule") int idWrapperRule){
		return null;
	}
	
	@GET
	@Path("/onejson/{idWrapperRule}")
	@Produces("application/json")
	public InterpretationRule getOneJSONInterpretationRule(@PathParam("idWrapperRule") int idWrapperRule){
		return null;
	}
	
	@DELETE
	@Path("/delete/{idWrapperRule}")
	public Response deleteOneInterpretationRuleJAXBorInterpretationRule(@PathParam("idWrapperRule") int idWrapperRule){
		return Response.status(200).entity("The object with the id: "+ idWrapperRule+" has been deleted").build();
	}
	
	@PUT
	@Path("/update/interpretationjson")
	@Consumes("application/json")
	public Response updateJSONWrapperRuleForInterpretationRule(final WrapperRuleJAXB wrapperRuleJAXB){
		return Response.status(200).entity("Updated object data: "+wrapperRuleJAXB.toString()).build();
	}
	
	@PUT
	@Path("/update/interpretationxml")
	@Consumes("application/xml")
	public Response updateXMLWrapperRuleForInterpretationRuleJAXB(final WrapperRuleJAXB wrapperRuleJAXB){
		return Response.status(200).entity("Updated object data: "+wrapperRuleJAXB.toString()).build();
	}
	
	@POST
	@Path("/add/interpretationjson")
	@Consumes("application/json")
	public Response addJSONWrapperRuleJAXBInDatabaseForInterpretationRule(final WrapperRuleJAXB wrapperRuleJAXB){
		return Response.status(200).entity("Added object has the data: "+ wrapperRuleJAXB.toString()).build();
	}
	
	@POST
	@Path("/add/interpretationxml")
	@Consumes("application/xml")
	public Response addXMLWrapperRuleJAXBInDatabaseForInterpretationRuleJAXB(final WrapperRuleJAXB wrapperRuleJAXB){
		return Response.status(200).entity("Added object has the data: "+ wrapperRuleJAXB.toString()).build();
	}
	
}