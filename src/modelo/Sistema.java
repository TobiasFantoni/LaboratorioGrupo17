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
	
	//Putaaa
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
	
	public boolean agregarUnidadVenta(String nombreComercial, Persona persona, double superficie, List<Persona> staff, List<Plato> platos, String codigoUnico) throws Exception {
		if(buscarUnidadVentaPorCodigoUnico(codigoUnico) != null)throw new Exception("La unidad ya existe");
		
		int id = 1;
		
		if(this.lstUnidadesVenta.isEmpty() != true) {
			id = this.lstUnidadesVenta.getLast().getId() + 1;
		}
		
		
		return this.lstUnidadesVenta.add(new UnidadVenta(id,nombreComercial,persona,superficie,staff,platos,codigoUnico));
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
	
	
	public List<ReporteVenta> obtenerRecaudacionFestival(Festival festival) {

		List<ReporteVenta> lstRecaudacion = new ArrayList<ReporteVenta>();

		return lstRecaudacion;
	}

	public List<UnidadVenta> rankingUnidades(List UnidadVenta){
	  
	  List<UnidadVenta> ranking = new ArrayList<UnidadVenta>(); UnidadVenta
	  unidadVentaAux = null;
	  
	  for(int i = 0; i < lstUnidadesVenta.size(); i++) { 
		  if() {
		  
		  } 
	  }
	  
	  return ranking;
	}
	
	public double obtenerRecaudacionFestival(Festival festival){
		  
		  double recaudacionFestival = 0;
		  
		  for(int i = 0; i < festival.getLstUnidadVentas().size(); i++) { 
			  recaudacionFestival = recaudacionFestival + festival.getLstUnidadVentas().get(i).calcularRentabilidad();
		  }
		  
		  return recaudacionFestival;
		}
	
	
	//getters y setters
	
	
	
}
