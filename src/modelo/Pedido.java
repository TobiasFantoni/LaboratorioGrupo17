package modelo;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	
	private int id;
	private LocalDate fecha;
	private UnidadVenta unidadVenta;
	private Festival festival;
	private List<ItemPedido> lstItemsPedido;
	private boolean estado;
	
	//constructor
	public Pedido(int id, LocalDate fecha,UnidadVenta unidadVenta, Festival festival, List<ItemPedido> detalle,boolean estado) {
		this.id = id;
		this.fecha = fecha;
		this.unidadVenta = unidadVenta;
		this.festival = festival;
		this.lstItemsPedido = detalle;
		this.estado = estado;
	}
	
	public boolean agregarItemPedido(Plato plato, int cant) {
		
		ItemPedido nuevoItem = null;
		
		nuevoItem = new ItemPedido(plato, cant);
		
		return this.lstItemsPedido.add(nuevoItem);
	}
	
	public double calcularTotalPedido() {
		
		double total = 0;
		for(ItemPedido i : this.getLstItemsPedido()) {
			
			Plato platoItem = i.getPlato();
			
			total += platoItem.getPrecio()*i.getCantidad();
			
		}
		return total;
	}

	
	private double calcularCostoPedido() {
		
		double costoTotal=0;
		
		for(ItemPedido i : this.getLstItemsPedido()) {
			
			Plato platoItem = i.getPlato();
			
			costoTotal += platoItem.getCosto()*i.getCantidad();
			
		}
		
		return costoTotal;
	}
	
	public double calcularGananciaNeta() {
		return this.calcularTotalPedido()-this.calcularCostoPedido();
	}
	
	//getters y setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}
	
	
	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public List<ItemPedido> getLstItemsPedido() {
		return lstItemsPedido;
	}

	public void setLstItemsPedido(List<ItemPedido> lstItemsPedido) {
		this.lstItemsPedido = lstItemsPedido;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

	
}	
