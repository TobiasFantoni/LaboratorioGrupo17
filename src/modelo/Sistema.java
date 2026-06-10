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
	
	
	public List<ReporteVenta> obtenerRecaudacionFestival(Festival festival) {

		List<ReporteVenta> lstRecaudacion = new ArrayList<ReporteVenta>();

		return lstRecaudacion;
	}
	  
	  public List<ReporteVenta> rankingUnidades() {

		    List<ReporteVenta> ranking = new ArrayList<>();

		    ranking = this.lstReportes;
		    
		    for(int i = 0; i < ranking.size() - 1; i++) {

		        int posMayor = i;

		        for(int j = i + 1; j < ranking.size(); j++) {

		            if(ranking.get(j).getRecaudacionTotal() >
		               ranking.get(posMayor).getRecaudacionTotal()) {

		                posMayor = j;
		            }
		        }

		        ReporteVenta aux = ranking.get(i);
		        ranking.set(i, ranking.get(posMayor));
		        ranking.set(posMayor, aux);
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
	
	public double obtenerRecaudacionFestival(Festival festival){
		  
		  double recaudacionFestival = 0;
		  
		  for(int i = 0; i < festival.getLstUnidadVentas().size(); i++) { 
			  recaudacionFestival = recaudacionFestival + festival.getLstUnidadVentas().get(i).calcularRentabilidad();
		  }
		  
		  return recaudacionFestival;
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

	    List<Canon> top3 = new ArrayList<>();

	    if (primero != null) top3.add(primero);
	    if (segundo != null) top3.add(segundo);
	    if (tercero != null) top3.add(tercero);

	    return top3;
	}
	
}
