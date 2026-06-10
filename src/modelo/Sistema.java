package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	
	private List<Festival> lstFestivales;
	private List<UnidadVenta> lstUnidadesVenta;
	private List<Persona> lstPersonalGlobal;
	private List<Pedido> lstPedidos;

	

	//Constructor
	public Sistema() {
		
		this.lstFestivales = new ArrayList<Festival>();
		this.lstUnidadesVenta = new ArrayList<UnidadVenta>();
		this.lstPersonalGlobal = new ArrayList<Persona>();
		this.lstPedidos = new ArrayList<Pedido>();

	}
	
	//metodos
	
	
	public Festival buscarFestivalPorDatos(String nombre, String temporada, LocalDate fechaIni) {
		Festival festivalEncontrado = null;
		int i = 0;
		boolean encontrado= false;
		
		while(i<this.lstFestivales.size() && !encontrado) {
			
			Festival f = this.lstFestivales.get(i);
			
			if(f.getNombre().equalsIgnoreCase(nombre) && f.getTemporada().equalsIgnoreCase(temporada) && f.getFechaIni().isEqual(fechaIni)) {
				festivalEncontrado = f;
				encontrado = true;
			}
			
			i++;
		}
		
		return festivalEncontrado;
	}
	
	public boolean agregarFestival(String nombre, String temporada, double costeSuperficie, LocalDate fechaIni,
			LocalDate fechaFin) throws Exception {
		
		if (fechaFin.isBefore(fechaIni)) {
			throw new Exception("La fecha de fin no puede ser anterior a la fecha de inicio");
		}
		else if (this.buscarFestivalPorDatos(nombre, temporada, fechaIni) != null) {
			throw new Exception("Ya existe un festival '" + nombre + "' para la temporada '" + temporada + "' en la fecha: " + fechaIni);
		}
		
		int id = 1;
		
		if (!this.lstFestivales.isEmpty()) {
			id = this.lstFestivales.getLast().getId();		
		}
		
		Festival nuevoFestival = new Festival(id, nombre, temporada, costeSuperficie, fechaIni, fechaFin);
		return this.lstFestivales.add(nuevoFestival);
	}
	
	public boolean eliminarFestival(Festival festival) {
		return this.lstFestivales.remove(festival);
	}
	
	
	public Persona buscarPersonaPorDni(long dni) {
		
		Persona personaEncontrada = null;
		int i = 0;
		boolean encontrada = false;
		
		while(i<this.lstPersonalGlobal.size() && !encontrada) {
			
			Persona p = this.lstPersonalGlobal.get(i);
			
			if(p.getDni() == dni) {
				personaEncontrada = p;
				encontrada = true;
			}
			
			i++;
		}
		
		return personaEncontrada;
	}
	
	public List<Persona> filtrarPersonalPorEdad(LocalDate desde, LocalDate hasta){
		
		List<Persona> personas = new ArrayList<Persona>();
		
		for(Persona p : this.lstPersonalGlobal) {
			
			if((p.getFechaNacimiento().isAfter(desde)
					||p.getFechaNacimiento().equals(desde)) 
					&& 
					(p.getFechaNacimiento().isBefore(hasta)
							||p.getFechaNacimiento().equals(hasta))) {
				
				personas.add(p);
			}
		}
		
		return personas;
	}
	
	public boolean agregarCocinero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase, String especialidad, int plusCategoria) throws Exception {
		
		LocalDate edadLimite = LocalDate.now().minusYears(18);
		
		if(this.buscarPersonaPorDni(dni) != null) {
			throw new Exception("Ya existe una persona con el DNI: "+ dni);
		}else if(fechaNacimiento.isAfter(edadLimite)){
			throw new Exception("La persona que intenta agregar, es menor de 18 años.");
		}
		
		Cocinero nuevoCocinero = new Cocinero(dni, nombre, apellido, fechaNacimiento, sueldoBase, especialidad ,plusCategoria);
		
		
		return this.lstPersonalGlobal.add(nuevoCocinero);
	} 
	
	public boolean agregarCajero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase, String turno) throws Exception {
		
		LocalDate edadLimite = LocalDate.now().minusYears(18);
		
		if(this.buscarPersonaPorDni(dni) != null) {
			throw new Exception("Ya existe una persona con el DNI: "+ dni);
		}else if(fechaNacimiento.isAfter(edadLimite)){
			throw new Exception("La persona que intenta agregar, es menor de 18 años.");
		}
		
		Cajero nuevoCajero = new Cajero(dni, nombre, apellido, fechaNacimiento, sueldoBase, turno);
		
		
		return this.lstPersonalGlobal.add(nuevoCajero);
	}
	
	public boolean eliminarPersona(long dni) {
		return this.lstPersonalGlobal.remove(buscarPersonaPorDni(dni));
	}
	
	public double calcularTotalDeImporteDeSueldosPorUnidadVenta(UnidadVenta u) {
		
		double total = 0;
			
			for(Persona p : u.getLstStaff()) {
				total += p.calcularSueldo();
			}
		
		return total;
	}
	
	
	public double calcularTotalDeImporteDeSueldosPorFestival(Festival f) {
		
		double total = 0;
		
		for(UnidadVenta u : f.getLstUnidadVentas()) {
			
			total += this.calcularTotalDeImporteDeSueldosPorUnidadVenta(u);
			
		}
		
		return total;
	}
	
	

	public List<Canon> canonsPorFestival(Festival f) {
		
		List<Canon> canons = new ArrayList<Canon>();
		
		for(UnidadVenta u : f.getLstUnidadVentas()) {
			
			Canon nuevoCanon = new Canon(u.getCodigoUnico(), u.getNombreComercial(), u.calcularCanon());
			canons.add(nuevoCanon);
		}
		
		return canons;
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
	
	public double calcularRentabilidadNetaEntreFechas(UnidadVenta u,LocalDate desde, LocalDate hasta) {
		
		List<Pedido> pedidos = this.filtrarPedidosEntreFechas(this.filtrarPedidosPorUnidad(u), desde, hasta);
		double totalSueldos = 0;
		double gananciaPedidos = 0;
		
		
		for(Pedido p : pedidos) {
			gananciaPedidos += p.calcularGananciaNeta();
		}
		
	}
	
	public boolean agregarUnidadVenta(UnidadVenta unidadVenta) {
		
		
		return this.lstUnidadesVenta.add(null);
	}
	
	public boolean eliminarUnidadVenta(UnidadVenta unidadVenta) {
		
		
		return this.lstFestivales.remove(unidadVenta);
	}
	
	
	public UnidadVenta buscarUnidadVentaPorId(int id) {
		
		UnidadVenta unidadVentaEncontrada = null;
		
		return unidadVentaEncontrada;
	}
	
	public boolean registrarPedido() {
		
		Pedido nuevoPedido = null; 
		
		return this.lstPedidos.add(nuevoPedido);
	}
	
	
	
	//getters y setters
	
	
	
}
