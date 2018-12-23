package cr.dnc.ns.broom.controller;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import cr.dnc.ns.broom.business.PairingLogic;
import cr.dnc.ns.broom.domain.Pair;
import cr.dnc.ns.broom.dto.PairingInputParam;
import cr.dnc.ns.broom.dto.PairingResponse;

@Path("/pair")
public class PairingController {
	private final PairingLogic pairingLogic = new PairingLogic();
	
	//@GET @Path("/pair")	@Produces("application/json") public String process() {
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String process(final String pairs) {
		Gson gson = new Gson();
		
		//PairingInputParam requestParam = gson.fromJson("{\"pairs\":[{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Bob Jones\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Washington\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mary\"},{\"category\":{\"name\":\"COMPUTER\"},\"subCategory\":\"Mac\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Bob Jones\"},{\"category\":{\"name\":\"OTHER\"},\"subCategory\":\"Tree\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Dog\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Texas\"},{\"category\":{\"name\":\"FOOD\"},\"subCategory\":\"Steak\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Cat\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mac\"}]}", PairingInputParam.class);
		PairingInputParam requestParam = gson.fromJson(pairs, PairingInputParam.class);
		final Set<Pair> processedList = pairingLogic.process(requestParam.getPairs());
		PairingResponse pr = new PairingResponse(processedList);
		
		return gson.toJson(pr);
	}
}