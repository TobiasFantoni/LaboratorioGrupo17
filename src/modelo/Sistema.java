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
	
	public boolean agregarCocinero(int dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase, int plusCategoria) throws Exception {
		
		if(buscarPersonaPorDni != null) {
			throw new Exception("Ya existe una persona con el DNI: "+ dni);
		}else if((LocalDate.now().getYear() - fechaNacimiento.getYear() ) < 18){
			
			
		}
		
	} 
	
	public boolean eliminarPersona(Persona persona) {
		
		
		return this.lstPersonalGlobal.remove(persona);
	}
	
	public boolean agregarUnidadVenta(UnidadVenta unidadVenta) {
		
		
		return this.lstUnidadesVenta.add(null);
	}
	
	public boolean eliminarUnidadVenta(UnidadVenta unidadVenta) {
		
		
		return this.lstFestivales.remove(unidadVenta);
	}
	
	public Persona buscarPersonalPorDni(long dni) {
		
		Persona personaEncontrada = null;
		
		return personaEncontrada;
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
