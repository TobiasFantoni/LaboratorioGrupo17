package modelo;

public class Plato {
	
	private int id;
	private String nombre;
	private float precio;
	private float costo;


	//constructor
	public Plato(int id, String nombre, float precio, float costo) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.costo = costo;
	}
	
	
	//Metodos
	
	
	//getters y setters
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}


	@Override
	public String toString() {
		return "\nPlato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", costo=" + costo + "]";
	}
	
	
}
