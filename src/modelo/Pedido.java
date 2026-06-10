package modelo;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	
	private int id;
	private LocalDate fecha;
	private UnidadVenta unidadVenta;
	private List<ItemPedido> lstItemsPedido;
	private boolean terminado;
	
	//constructor
	public Pedido(int id, LocalDate fecha, UnidadVenta unidadVenta, List<ItemPedido> lstItemsPedido, boolean terminado) {
		this.id = id;
		this.fecha = fecha;
		this.unidadVenta = unidadVenta;
		this.lstItemsPedido = lstItemsPedido;
		this.terminado = terminado;
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

	public List<ItemPedido> getLstItemsPedido() {
		return lstItemsPedido;
	}

	public void setLstItemsPedido(List<ItemPedido> lstItemsPedido) {
		this.lstItemsPedido = lstItemsPedido;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	
	

	
}	