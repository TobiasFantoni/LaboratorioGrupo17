package modelo;

import java.util.List;

public class PuestoDesarmable extends UnidadVenta{
	
	private int cantidad;
	private int tiempoMontaje;
	
	
	
	//constructor
	public PuestoDesarmable(int id, String nombreComercial, Persona responsable, double superficie,
			String codigoUnico, int cantidad, int tiempoMontaje) throws Exception {
		super(id, nombreComercial, responsable, superficie, codigoUnico);
		this.cantidad = cantidad;
		this.tiempoMontaje = tiempoMontaje;
	}
	
	//getters y setters
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getTiempoMontaje() {
		return tiempoMontaje;
	}
	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}
	
	public double calcularCanon(){
		
		double canon = 0;
		
		canon = (superficie * 500) - (this.tiempoMontaje * 10);
			
		return canon;
	}

	@Override
	public String toString() {
		return super.toString()+ "PuestoDesarmable [cantidad=" + cantidad + ", tiempoMontaje=" + tiempoMontaje + "]";
	}
	
	
}