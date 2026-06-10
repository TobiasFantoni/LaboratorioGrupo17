package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class UnidadVenta {
	protected int id;
	protected String nombreComercial;
	protected Persona responsable;
	protected double superficie;
	protected List<Persona> lstStaff;
	protected List<Plato> lstPlatos;
	protected String codigoUnico;

	public UnidadVenta(int id, String nombreComercial, Persona responsable, double superficie, List<Persona> lstStaff, String codigoUnico) throws Exception {
		this.id = id;
		this.nombreComercial = nombreComercial;
		this.responsable = responsable;
		this.superficie = superficie;
		this.lstStaff = lstStaff;
		this.lstPlatos = new ArrayList<Plato>();
		this.setCodigoUnico(codigoUnico);
	}

	// getters y setters
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

	public void setCodigoUnico(String codigoUnico) throws Exception{
		if(codigoUnico.length() != 10) throw new Exception("El codigo unico debe tener una longitud de 10 caracteres");
		this.codigoUnico = codigoUnico;
	}
	
	public boolean equals(UnidadVenta unidad) {

		return this.codigoUnico.equals(unidad.getCodigoUnico());
	}
	
	public Plato buscarPlatoPorNombre(String nombre) {
		
		Plato unidadVentaEncontrada = null;
		boolean encontrado = false;
		int contador = 0;
		
		while(contador < this.lstPlatos.size() && encontrado == false) {
			if(lstPlatos.get(contador).getNombre().equals(nombre)) {
				unidadVentaEncontrada = this.lstPlatos.get(contador);
				encontrado = true;
			}
			contador++;
		}
		
		return unidadVentaEncontrada;
	}
	
	public boolean agregarPlato(String nombre, float precio, float costo) throws Exception {
		if(buscarPlatoPorNombre(nombre) != null)throw new Exception("El plato ya existe");
		
		int id = 1;
		
		if(this.lstPlatos.isEmpty() != true) {
			id = this.lstPlatos.getLast().getId() + 1;
		}
		
		return this.lstPlatos.add(new Plato(id,nombre,precio,costo));
	}
	
	public abstract double calcularCanon();

	@Override
	public String toString() {
		return "\nUnidadVenta [id=" + id + ", nombreComercial=" + nombreComercial + ", responsable=" + responsable
				+ ", superficie=" + superficie + ", lstStaff=" + lstStaff + ", lstPlatos=" + lstPlatos
				+ ", codigoUnico=" + codigoUnico + "]";
	}

}
