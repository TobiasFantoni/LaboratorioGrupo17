package modelo;

import java.util.List;
import java.util.ArrayList;
//Hola DAni
public class Sistema {
	
	private List<Festival> lstFestivales;
	private List<UnidadVenta> lstUnidadesVenta;
	private List<Persona> lstPersonalGlobal;
	private List<Pedido> lstPedidos;
	//private List<ReportesVenta> lstReportes;
	
	//DanielTest
	
	//Constructor
	public Sistema() {
		
		this.lstFestivales = new ArrayList<Festival>();
		this.lstUnidadesVenta = new ArrayList<UnidadVenta>();
		this.lstPersonalGlobal = new ArrayList<Persona>();
		this.lstPedidos = new ArrayList<Pedido>();
		//this.lstFestivales = new ArrayList<Festival>;
		
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
		
		return this.lstPedidos.add(nuevoPedido);
	}
	
	public List<ReporteVenta> obtenerRecaudacionFestival(Festival festival){
		
		List<ReporteVenta> recaudacion = new ArrayList<ReporteVenta>();
		
		return recaudacion;
	}
	
	public List<UnidadVenta> rankingUnidades(){
		
		List<UnidadVenta> ranking = new ArrayList<UnidadVenta>();
	}
	
	
	
	//getters y setters
	
	
	
}
