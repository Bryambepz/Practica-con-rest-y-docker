package ec.edu.ups.sd.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autos implements Serializable{
	@Id
	private int id;
	@Column(name = "Marca")
	private String marca;
	
	@Column(name = "Placa")
	private String placa;

	@Column(name = "Color")
	private String color;	

	@Column(name = "Puesto")
	private int puesto;
	
	public Autos() {
		//TODO Auto-generated constructor stub
	}

	public Autos(int id, String marca, String placa, String color, int puesto) {
		super();
		this.id = id;
		this.marca = marca;
		this.placa = placa;
		this.color = color;
		this.puesto = puesto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "Persona ====> \n"
				+ "    id=" + id + ", marca=" + marca + ", placa=" + placa + ", color=" + color + ", puesto=" + puesto
				+ "]";
	}
}
