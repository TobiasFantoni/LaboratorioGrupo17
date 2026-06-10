package modelo;

public class Plato {
	
	private int id;
	private String nombre;
	private float precio;
	private float costo;


	//constructor
	public Plato(int id, String nombre, float precio, float costo) throws Exception {
		this.id = id;
		this.nombre = nombre;
		this.setPrecio(precio);
		this.setCosto(costo);
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

	public void setPrecio(float precio) throws Exception{
		if(precio <= 0)throw new Exception("El precio debe ser de un valor positivo");
		this.precio = precio;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo)throws Exception {
		if(costo <= 0)throw new Exception("El costo debe ser de un valor positivo");
		this.costo = costo;
	}


	@Override
	public String toString() {
		return "\nPlato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", costo=" + costo + "]";
	}
	
	
}
