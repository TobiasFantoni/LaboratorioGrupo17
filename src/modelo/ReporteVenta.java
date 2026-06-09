package modelo;

import java.util.ArrayList;
import java.util.List;

public class ReporteVenta {
	private double recaudacionTotal;
	private List<UnidadVenta> rankingUnidad;
	
	public ReporteVenta(double recaudacionTotal) {
		super();
		this.recaudacionTotal = recaudacionTotal;
		this.rankingUnidad = new ArrayList<UnidadVenta>();
	}

	public double getRecaudacionTotal() {
		return recaudacionTotal;
	}

	public void setRecaudacionTotal(double recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}

	public List<UnidadVenta> getRankingUnidad() {
		return rankingUnidad;
	}

	public void setRankingUnidad(List<UnidadVenta> rankingUnidad) {
		this.rankingUnidad = rankingUnidad;
	}
	
	
	
	
}
