package modelo;

import java.util.ArrayList;
import java.util.List;

public class ReporteVenta {
	private double recaudacionTotal;
	private UnidadVenta unidad;
	
	public ReporteVenta(double recaudacionTotal, UnidadVenta unidad) {
		super();
		this.recaudacionTotal = recaudacionTotal;
		this.unidad = unidad;
	}

	public double getRecaudacionTotal() {
		return recaudacionTotal;
	}

	public void setRecaudacionTotal(double recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}

	public UnidadVenta getRankingUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "\n\nUNIDAD: "+this.unidad.getNombreComercial()+"\nCODIGO: " +this.unidad.getCodigoUnico()+ "\nRecaudacion total: "+this.recaudacionTotal;
	}
	
	
	
}