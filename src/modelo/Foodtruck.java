package modelo;

import java.util.List;

public class Foodtruck extends UnidadVenta {

	private String patente;
	private boolean usaLuz;
	
	
	//constructor
	public Foodtruck(int id, String nombreComercial, Persona responsable, double superficie, List<Persona> lstStaff,
			List<Plato> lstPlatos, String codigoUnico, String patente, boolean usaLuz) {
		super(id, nombreComercial, responsable, superficie, lstStaff, lstPlatos, codigoUnico);
		this.patente = patente;
		this.usaLuz = usaLuz;
	}
	
	//getters y setters
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isUsaLuz() {
		return usaLuz;
	}
	public void setUsaLuz(boolean usaLuz) {
		this.usaLuz = usaLuz;
	}
	
	
	
	
}
