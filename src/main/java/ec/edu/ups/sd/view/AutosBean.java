package ec.edu.ups.sd.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import ec.edu.ups.sd.bussines.AutosOn;
import ec.edu.ups.sd.modelo.*;

public class AutosBean {
	@Inject
	private AutosOn autON;
	
	private Autos newAuto;
	private List<Autos> autosGuardados;
	
	
	@PostConstruct
	public void init() {
		newAuto = new Autos();
		autosGuardados = autON.getAutos();
	}
	
	public void guardar() {
		if (newAuto != null) {
			autON.guardarAuto(newAuto);
			System.out.println("auto: " + newAuto);
			newAuto = new Autos();
			this.autosGuardados = autON.getAutos();
		}
	}

	public Autos getNewAuto() {
		return newAuto;
	}

	public void setNewAuto(Autos newAuto) {
		this.newAuto = newAuto;
	}

	public List<Autos> getAutosGuardados() {
		return autosGuardados;
	}

}
