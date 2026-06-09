package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	
	private List<Festival> lstFestivales;
	private List<UnidadVenta> lstUnidadesVenta;
	private List<Persona> lstPersonalGlobal;
	private List<Pedido> lstPedidos;
	//private List<ReportesVenta> lstReportes;
	

	//Constructor
	public Sistema() {
		
		this.lstFestivales = new ArrayList<Festival>();
		this.lstUnidadesVenta = new ArrayList<UnidadVenta>();
		this.lstPersonalGlobal = new ArrayList<Persona>();
		this.lstPedidos = new ArrayList<Pedido>();
		//this.lstFestivales = new ArrayList<Festival>;
		
	}
	
	//metodos
	
	public boolean agregarFestival(Festival festival) {
		
		
		return this.lstFestivales.add(null);
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
	
	public List<Canon> canonsPorFestival(Festival f) {
		
		List<Canon> canons = new ArrayList<Canon>();
		
		for(UnidadVenta u : f.getLstUnidadVentas()) {
			
			Canon nuevoCanon = new Canon(u.getCodigoUnico(), u.getNombreComercial(), u.calcularCanon());
			canons.add(nuevoCanon);
		}
		
		return canons;
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
	
//	public List<ReporteVenta> obtenerRecaudacionFestival(Festival festival){
//		
//		List<ReporteVenta> recaudacion = new ArrayList<ReporteVenta>();
//		
//		return recaudacion;
//	}
	
//	public List<UnidadVenta> rankingUnidades(){
//		
//		List<UnidadVenta> ranking = new ArrayList<UnidadVenta>();
//	}
	
	
	
	//getters y setters
	
	
	
}
