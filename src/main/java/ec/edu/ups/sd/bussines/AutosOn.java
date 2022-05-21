package ec.edu.ups.sd.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.sd.DAO.AutosDAO;
import ec.edu.ups.sd.modelo.Autos;

@Stateless
public class AutosOn {

	@Inject
	private AutosDAO autosDAO;
	
	public void guardarAuto(Autos auto) {

		Autos p = autosDAO.read(auto.getId());
		if (p == null) {
			autosDAO.insert(auto);
		} else { 
			autosDAO.update(auto);
		}
	}
	
	public List<Autos> getAutos() {
		return autosDAO.getList();
	}
	
	public Autos buscarPlaca(String placa) {
		var listaAutos= autosDAO.getList();
		for (Autos auto : listaAutos) {
			System.out.println(auto.toString());
		}
		Autos per;
		per = listaAutos.stream().filter(p -> p.getPlaca().equals(placa)).findFirst().get();
		return per;
	}
	
	public int calcularID() {
		var lista = autosDAO.getList();

		if (lista.size() == 0) {
			return 1;
		} else {
			return lista.size() + 1;
		}
	}
}
