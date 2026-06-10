package modelo;

import java.util.ArrayList;
import java.util.List;

public class ReporteVenta {
	private double recaudacionTotal;
	private UnidadVenta rankingUnidad;
	
	public ReporteVenta(double recaudacionTotal, UnidadVenta rankingUnidad) {
		super();
		this.recaudacionTotal = recaudacionTotal;
		this.rankingUnidad = rankingUnidad;
	}

	public double getRecaudacionTotal() {
		return recaudacionTotal;
	}

	public void setRecaudacionTotal(double recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}

	public UnidadVenta getRankingUnidad() {
		return rankingUnidad;
	}

	public void setRankingUnidad(UnidadVenta rankingUnidad) {
		this.rankingUnidad = rankingUnidad;
	}

	@Override
	public String toString() {
		return "ReporteVenta [recaudacionTotal=" + recaudacionTotal + ", rankingUnidad=" + rankingUnidad + "]";
	}
	
	
	
}
