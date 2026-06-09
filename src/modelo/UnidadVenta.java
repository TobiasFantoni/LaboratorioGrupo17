package modelo;

import java.util.List;

public class UnidadVenta {
	protected int id;
	protected String nombreComercial;
	protected Persona responsable;
	protected double superficie;
	protected List<Persona> lstStaff;
	protected List<Plato> lstPlatos;
	protected String codigoUnico;
	
	
	public UnidadVenta(int id, String nombreComercial, Persona responsable, double superficie, List<Persona> lstStaff,
			List<Plato> lstPlatos, String codigoUnico) {
		this.id = id;
		this.nombreComercial = nombreComercial;
		this.responsable = responsable;
		this.superficie = superficie;
		this.lstStaff = lstStaff;
		this.lstPlatos = lstPlatos;
		this.codigoUnico = codigoUnico;
	}
	
	
	
	
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public Persona getResponsable() {
		return responsable;
	}
	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public List<Persona> getLstStaff() {
		return lstStaff;
	}
	public void setLstStaff(List<Persona> lstStaff) {
		this.lstStaff = lstStaff;
	}
	public List<Plato> getLstPlatos() {
		return lstPlatos;
	}
	public void setLstPlatos(List<Plato> lstPlatos) {
		this.lstPlatos = lstPlatos;
	}
	public String getCodigoUnico() {
		return codigoUnico;
	}
	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}
	

	
}
