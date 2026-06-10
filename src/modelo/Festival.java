package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Festival {
		private int id;
		private String nombre;
		private String temporada;
		private double costeSuperficie;
		private LocalDate fechaIni;
		private LocalDate fechaFin;
		private List<UnidadVenta> lstUnidadVentas;
		
		public Festival(int id, String nombre, String temporada, double costeSuperficie, LocalDate fechaIni,
				LocalDate fechaFin) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.temporada = temporada;
			this.costeSuperficie = costeSuperficie;
			this.fechaIni = fechaIni;
			this.fechaFin = fechaFin;
			this.lstUnidadVentas = new ArrayList<UnidadVenta>();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTemporada() {
			return temporada;
		}

		public void setTemporada(String temporada) {
			this.temporada = temporada;
		}

		public double getCosteSuperficie() {
			return costeSuperficie;
		}

		public void setCosteSuperficie(double costeSuperficie) {
			this.costeSuperficie = costeSuperficie;
		}

		public LocalDate getFechaIni() {
			return fechaIni;
		}

		public void setFechaIni(LocalDate fechaIni) {
			this.fechaIni = fechaIni;
		}

		public LocalDate getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(LocalDate fechaFin) {
			this.fechaFin = fechaFin;
		}

		public List<UnidadVenta> getLstUnidadVentas() {
			return lstUnidadVentas;
		}

		public void setLstUnidadVentas(List<UnidadVenta> lstUnidadVentas) {
			this.lstUnidadVentas = lstUnidadVentas;
		}

		@Override
		public int hashCode() {
			return Objects.hash(fechaFin, fechaIni, nombre);
		}

		
		public boolean equals(Festival f) {
			return this.nombre.equalsIgnoreCase(f.nombre) && this.temporada.equalsIgnoreCase(f.temporada) && this.fechaIni.isEqual(fechaIni);
		}
		
		
		
}