package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
//Hola DAni
public class Sistema {
	
	private List<Festival> lstFestivales;
	private List<UnidadVenta> lstUnidadesVenta;
	private List<Persona> lstPersonalGlobal;
	private List<Pedido> lstPedidos;
	private List<ReporteVenta> lstReportes;
	
	//Constructor
	public Sistema() {
		
		this.lstFestivales = new ArrayList<Festival>();
		this.lstUnidadesVenta = new ArrayList<UnidadVenta>();
		this.lstPersonalGlobal = new ArrayList<Persona>();
		this.lstPedidos = new ArrayList<Pedido>();
		this.lstReportes = new ArrayList<ReporteVenta>();
		
	}
	
	//HASDIUQHWIEQWEasdasdasd
	//metodos
	
	public boolean agregarFestival(Festival festival) {
		
		
		return this.lstFestivales.add(null);
	}
	
	public boolean eliminarFestival(Festival festival) {
		
		
		return this.lstFestivales.remove(festival);
	}
	
	public boolean agregarPersonal(Persona personal) {
		
		
		return this.lstPersonalGlobal.add(null);
	}
	
	public boolean eliminarPersonal(Persona persona) {
		
		
		return this.lstPersonalGlobal.remove(persona);
	}
	
	public boolean agregarUnidadVentaPuestoDesmotable(String nombreComercial, Persona persona, double superficie, List<Persona> staff, List<Plato> platos, String codigoUnico, int cantidad, int tiempoMontaje) throws Exception {
		if(buscarUnidadVentaPorCodigoUnico(codigoUnico) != null)throw new Exception("La unidad ya existe");
		
		int id = 1;
		
		if(this.lstUnidadesVenta.isEmpty() != true) {
			id = this.lstUnidadesVenta.getLast().getId() + 1;
		}
		
	
		return this.lstUnidadesVenta.add(new PuestoDesarmable(id,nombreComercial,persona,superficie,staff,platos,codigoUnico, cantidad, tiempoMontaje));
	}
	
	public boolean agregarUnidadVentaFoodTruck(String nombreComercial, Persona persona, double superficie, List<Persona> staff, List<Plato> platos, String codigoUnico,  String patente, boolean usaLuz) throws Exception {
		if(buscarUnidadVentaPorCodigoUnico(codigoUnico) != null)throw new Exception("La unidad ya existe");
		
		int id = 1;
		
		if(this.lstUnidadesVenta.isEmpty() != true) {
			id = this.lstUnidadesVenta.getLast().getId() + 1;
		}
		
	
		return this.lstUnidadesVenta.add(new Foodtruck(id,nombreComercial,persona,superficie,staff,platos,codigoUnico, patente, usaLuz));
	}
	
	public boolean eliminarUnidadVenta(String codigoUnico) throws Exception{
		if(buscarUnidadVentaPorCodigoUnico(codigoUnico) == null)throw new Exception("No se encontro la Unidadad de Venta");
		
		
		return this.lstUnidadesVenta.remove(buscarUnidadVentaPorCodigoUnico(codigoUnico));
	}
	
	public Persona buscarPersonalPorDni(long dni) {
		
		Persona personaEncontrada = null;
		
		return personaEncontrada;
	}
	
	public UnidadVenta buscarUnidadVentaPorCodigoUnico(String codigoUnico) {
		
		UnidadVenta unidadVentaEncontrada = null;
		boolean encontrado = false;
		int contador = 0;
		
		while(contador < this.lstUnidadesVenta.size() && encontrado == false) {
			if(lstUnidadesVenta.get(contador).equals(codigoUnico)) {
				unidadVentaEncontrada = this.lstUnidadesVenta.get(contador);
				encontrado = true;
			}
			contador++;
		}
		
		return unidadVentaEncontrada;
	}
	
	public boolean registrarPedido(LocalDate fecha, UnidadVenta unidadVenta, List<ItemPedido> lstItemsPedido, boolean estado) {
		
		int id = 1;
		
		if(this.lstUnidadesVenta.isEmpty() != true) {
			id = this.lstUnidadesVenta.getLast().getId() + 1;
		}
		
		return this.lstPedidos.add(new Pedido(id, fecha, unidadVenta, lstItemsPedido, estado));
	}
	
	public Pedido buscarPedidoPorId(int id) {
		
		Pedido pedidoEncontrado = null;
		boolean encontrado = false;
		int contador = 0;
		
		while(contador < this.lstPedidos.size() && encontrado == false) {
			if(lstPedidos.get(contador).equals(id)) {
				pedidoEncontrado = this.lstPedidos.get(contador);
				encontrado = true;
			}
			contador++;
		}
		
		return pedidoEncontrado;
	}
	  	
	public List<ReporteVenta> obtenerRecaudacionFestival(Festival festival){

	    List<ReporteVenta> reporte = new ArrayList<>();
	    
	    for(int i = 0; i < festival.getLstUnidadVentas().size(); i++) {
	    	 double recaudacionFestival = 0;
	    	 recaudacionFestival = recaudacionFestival + this.calcularRentabilidadNeta(festival.getLstUnidadVentas().get(i));
	    	 reporte.add(new ReporteVenta(recaudacionFestival, festival.getLstUnidadVentas().get(i)));
	    }

	    return reporte;
	}
	
	 public List<ReporteVenta> rankingUnidades(Festival festival) {

		    List<ReporteVenta> ranking = new ArrayList<>();
		    
		    ranking = this.obtenerRecaudacionFestival(festival);
	
		    this.ordenarPorUnidadesVendidas(ranking);
		    

		    return ranking;
		}
	 
	 private List<ReporteVenta> ordenarPorUnidadesVendidas(List<ReporteVenta> reporteVentas) {

		    for (int i = 0; i < reporteVentas.size() - 1; i++) {

		        for (int j = 0; j < reporteVentas.size()- 1 - i; j++) {
		            if (reporteVentas.get(j).getRecaudacionTotal() < reporteVentas.get(j+1).getRecaudacionTotal()) {
		            	ReporteVenta aux = reporteVentas.get(j);
		            	reporteVentas.set(j, reporteVentas.get(j + 1));
		            	reporteVentas.set(j + 1, aux);
		            }
		        }
		    }
		    return reporteVentas;
		}
	
	public List<Canon> canonsPorFestival(Festival f) {
		
		List<Canon> canons = new ArrayList<Canon>();
		
		for(UnidadVenta u : f.getLstUnidadVentas()) {
			
			Canon nuevoCanon = new Canon(u.getCodigoUnico(), u.getNombreComercial(), u.calcularCanon());
			canons.add(nuevoCanon);
		}
		
		return canons;
	}
	
	public List<Canon> canonTop3(Festival f) {
		
		List<Canon> canonList = new ArrayList<Canon>();
		List<Canon> top3 = new ArrayList<>();
		canonList = this.canonsPorFestival(f);
		
		Canon primero = null;
		Canon segundo = null;
		Canon tercero = null;

	    for (Canon c : canonList ) {

	        if (primero == null || c.getCanon() > primero.getCanon()) {
	            tercero = segundo;
	            segundo = primero;
	            primero = c;
	        }
	        else if (segundo == null || c.getCanon() > segundo.getCanon()) {
	            tercero = segundo;
	            segundo = c;
	        }
	        else if (tercero == null || c.getCanon() > tercero.getCanon()) {
	            tercero = c;
	        }
	    }

	    if (primero != null) {
	    	top3.add(primero);
	    }
	    if (segundo != null) {
	    	top3.add(segundo);
	    }
	    if (tercero != null) {
	    	top3.add(tercero);
	    }

	    return top3;
	}
	
	private double calcularGananciaNetaDePedidosPorUnidad(UnidadVenta u) {
		
		double gananciaPedidos = 0;
		
		for(Pedido p : this.filtrarPedidosPorUnidad(u)) {
				gananciaPedidos += p.calcularGananciaNeta();
		}
		
		return gananciaPedidos;
		
	}
	
	private double calcularSueldosPorUnidad(UnidadVenta u) {
		
		double total = 0;
		
		for(Persona p : u.getLstStaff()) {
			
			total += p.calcularSueldo(); 
		}
		
		return total;
	}
	
	private List<Pedido> filtrarPedidosEntreFechas(List<Pedido> pedidos,LocalDate desde, LocalDate hasta){
		
		List<Pedido> pedidosFiltrados = new ArrayList<Pedido>();
		
		for(Pedido p : pedidos) {
			if((p.getFecha().equals(desde)||p.getFecha().isAfter(desde)) && (p.getFecha().equals(hasta) || p.getFecha().isBefore(hasta))) {
				
				pedidosFiltrados.add(p);
				
			}
		}
		
		return pedidosFiltrados;
		
	}
	
	
	public double calcularRentabilidadNeta(UnidadVenta u) {
		
		double totalSueldos = this.calcularSueldosPorUnidad(u);
		double gananciaPedidos = this.calcularGananciaNetaDePedidosPorUnidad(u);

		return gananciaPedidos-totalSueldos-u.calcularCanon();
		
	}
	
	private List<Pedido> filtrarPedidosPorUnidad(UnidadVenta u) {
		
		List<Pedido> pedidosFiltrados = new ArrayList<Pedido>();
		
		for(Pedido p : this.lstPedidos) {
			if(p.getUnidadVenta().equals(u)) {
				pedidosFiltrados.add(p);
			}
		}
		
		return pedidosFiltrados;
	}
	
}
