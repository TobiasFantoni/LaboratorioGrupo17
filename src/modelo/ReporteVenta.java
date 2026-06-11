package modelo;

import java.util.ArrayList;
import java.util.List;

public class ReporteVenta {
	private double recaudacionTotal;
	private UnidadVenta unidad;
	
	public ReporteVenta(double recaudacionTotal, UnidadVenta rankingUnidad) {
		super();
		this.recaudacionTotal = recaudacionTotal;
		this.unidad = rankingUnidad;
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

	public void setRankingUnidad(UnidadVenta rankingUnidad) {
		this.unidad = rankingUnidad;
	}

	@Override
	public String toString() {
		return "\n\nUNIDAD: "+this.unidad.getNombreComercial()+"\nCODIGO: " +this.unidad.getCodigoUnico()+ "\nRecaudacion total: "+this.recaudacionTotal;
	}
	
	
	
}