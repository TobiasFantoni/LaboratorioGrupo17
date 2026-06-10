package modelo;

import java.util.List;

public class Foodtruck extends UnidadVenta {

	private String patente;
	private boolean usaLuz;
	
	
	//constructor
	public Foodtruck(int id, String nombreComercial, Persona responsable, double superficie, List<Persona> lstStaff, String codigoUnico, String patente, boolean usaLuz) {
		super(id, nombreComercial, responsable, superficie, lstStaff, codigoUnico);
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
	
	
	public double calcularCanon(){
		
		double canon = 0;
		
		if(this.usaLuz == true) {
			canon = (superficie * 500) + 2000;
		}else {
			canon = (superficie * 500);
		}
		
		return canon;
	}

	@Override
	public String toString() {
		return super.toString() + "Foodtruck [patente=" + patente + ", usaLuz=" + usaLuz + "]";
	}
	
	
}
