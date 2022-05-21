package ec.edu.ups.sd.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.sd.bussines.AutosOn;
import ec.edu.ups.sd.modelo.Autos;

@Path("auto")
public class AutoRest {

	@Inject
	private AutosOn autoON;
	
	
	@POST
	@Path("agregar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String agregar(@QueryParam("marca") String marca,
			@QueryParam("placa") String placa, @QueryParam("color") String color, 
			@QueryParam("puesto") int puesto) {
		Autos au = new Autos(autoON.calcularID(), marca, placa, color, puesto);		
		autoON.guardarAuto(au);
		System.out.println("agregado>3 " + autoON.getAutos().toString());
		return au.toString();
	}
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Autos> listar(){
		return autoON.getAutos();
	}
	
}
