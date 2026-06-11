package modelo;

public class Canon {
	private String codigo;
	private String nombreComercial;
	private double canon;
	
	public Canon(String codigo, String nombreComercial, double canon) {
		this.codigo = codigo;
		this.nombreComercial = nombreComercial;
		this.canon = canon;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public double getCanon() {
		return canon;
	}

	public void setCanon(double canon) {
		this.canon = canon;
	}
	
	@Override
	public String toString() {
		return "\n\ncodigo=" + codigo + ", nombreComercial=" + nombreComercial + ", canon=" + canon;
	}
	
	
}
