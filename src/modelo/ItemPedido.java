package modelo;

public class ItemPedido {
	
	private Plato plato;
	private int cantidad;
	
	
	
	public ItemPedido(Plato plato, int cantidad) {
		this.plato = plato;
		this.cantidad = cantidad;
	}
	
	
	
	@Override
	public String toString() {
		return "Plato: " + plato.getNombre() + "|Cantidad:" + cantidad;
	}



	//getters y setters
	public Plato getPlato() {
		return plato;
	}
	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
