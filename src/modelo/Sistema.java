package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

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
			id = this.lstFestivales.getLast().getId() + 1;		
		}
		
		Festival nuevoFestival = new Festival(id, nombre, temporada, costeSuperficie, fechaIni, fechaFin);
		return this.lstFestivales.add(nuevoFestival);
	}
	
	public boolean eliminarFestival(Festival festival) {
		return this.lstFestivales.remove(festival);
	}
	
	public boolean agregarUnidadVentaParaFestival(Festival f, UnidadVenta u) throws Exception {
		
		if(buscarUnidadDeVentaEnFestival(u.getCodigoUnico(), f) == true)throw new Exception("La unidad ya existe en el festival");

		
		return f.getLstUnidadVentas().add(u);
	}
	
	public boolean buscarUnidadDeVentaEnFestival(String codigoUnico,Festival f) throws Exception {
		boolean repetido = false;
		
		for(int i = 0; i < f.getLstUnidadVentas().size(); i++) {
			if(f.getLstUnidadVentas().get(i).getCodigoUnico().equals(codigoUnico)) {
				repetido = true;
			}
		}
		return repetido;
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
	
	public boolean agregarUnidadVentaPuestoDesmotable(String nombreComercial, Persona persona, double superficie, List<Persona> staff, String codigoUnico, int cantidad, int tiempoMontaje) throws Exception {
		if(buscarUnidadVentaPorCodigoUnico(codigoUnico) != null)throw new Exception("La unidad ya existe");
		
		int id = 1;
		
		if(this.lstUnidadesVenta.isEmpty() != true) {
			id = this.lstUnidadesVenta.getLast().getId() + 1;
		}
		
	
		return this.lstUnidadesVenta.add(new PuestoDesarmable(id,nombreComercial,persona,superficie,staff,codigoUnico, cantidad, tiempoMontaje));
	}
	
	public boolean agregarUnidadVentaFoodTruck(String nombreComercial, Persona persona, double superficie, List<Persona> staff, String codigoUnico,  String patente, boolean usaLuz) throws Exception {
		if(buscarUnidadVentaPorCodigoUnico(codigoUnico) != null)throw new Exception("La unidad ya existe");
		
		int id = 1;
		
		if(this.lstUnidadesVenta.isEmpty() != true) {
			id = this.lstUnidadesVenta.getLast().getId() + 1;
		}
		
	
		return this.lstUnidadesVenta.add(new Foodtruck(id,nombreComercial,persona,superficie,staff,codigoUnico, patente, usaLuz));
	}
	
	public boolean eliminarUnidadVenta(String codigoUnico) throws Exception{
		if(buscarUnidadVentaPorCodigoUnico(codigoUnico) == null)throw new Exception("No se encontro la Unidadad de Venta");
		
		
		return this.lstUnidadesVenta.remove(buscarUnidadVentaPorCodigoUnico(codigoUnico));
	}
	

	
	public UnidadVenta buscarUnidadVentaPorCodigoUnico(String codigoUnico) {
		
		UnidadVenta unidadVentaEncontrada = null;
		boolean encontrado = false;
		int contador = 0;
		
		while(contador < this.lstUnidadesVenta.size() && encontrado == false) {
			if(lstUnidadesVenta.get(contador).getCodigoUnico().equals(codigoUnico)) {
				unidadVentaEncontrada = this.lstUnidadesVenta.get(contador);
				encontrado = true;
			}
			contador++;
		}
		
		return unidadVentaEncontrada;
	}
	
	public boolean agregarPersonal(UnidadVenta unidadVenta, int dni){
		Persona personaAux;
	
		personaAux = this.buscarPersonaPorDni(dni);
		
		return unidadVenta.getLstStaff().add(personaAux);
		
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
	
		    ranking = this.ordenarPorUnidadesVendidas(ranking);
		    
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
	
	
	
	private double calcularGananciaNetaDePedidosPorUnidad(UnidadVenta u) {
		
		double gananciaPedidos = 0;
		
		//Este for que hace?
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

	public Festival buscarFestivalId(int id) {
		Festival f = null;
		int i = 0;
		while (i < lstFestivales.size() && f == null) {
			if (this.lstFestivales.get(i).getId() == id) {
				f = this.getLstFestivales().get(i);
			}
			i++;
		}
		return f;
	}
	 

	    // Plato Estrella: Dado una unidad, devolver el objeto Plato que registró mayor 
	    //cantidad de Pedidos en un festival particular. 

	    public Plato obtenerPlatoEstrella(UnidadVenta u) {
	        Plato platoEstrella=null;
	        int mayorCantidad=0;

	        for (Pedido p : this.filtrarPedidosPorUnidad(u)) {


	                for(ItemPedido item : p.getLstItemsPedido()) {
	                    if(item.getCantidad() > mayorCantidad) {

	                        mayorCantidad = item.getCantidad();
	                        platoEstrella = item.getPlato();
	                }
	            }
	        }

	        return platoEstrella;
	    }


	    public List<Persona> auditoriaFestivalPersonal(Festival f){
	        List<Persona> autoria=new ArrayList<Persona>();

	        for (UnidadVenta u: f.getLstUnidadVentas()) {
	            for (Persona p : u.getLstStaff()) {
	                autoria.add(p);
	            }
	        }
	        return autoria;

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
	
	calcularCanonEntreFechas
	
	public List<Festival> getLstFestivales() {
		return lstFestivales;
	}

	public void setLstFestivales(List<Festival> lstFestivales) {
		this.lstFestivales = lstFestivales;
	}

	public List<UnidadVenta> getLstUnidadesVenta() {
		return lstUnidadesVenta;
	}

	public void setLstUnidadesVenta(List<UnidadVenta> lstUnidadesVenta) {
		this.lstUnidadesVenta = lstUnidadesVenta;
	}

	public List<Persona> getLstPersonalGlobal() {
		return lstPersonalGlobal;
	}

	public void setLstPersonalGlobal(List<Persona> lstPersonalGlobal) {
		this.lstPersonalGlobal = lstPersonalGlobal;
	}

	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}

	public void setLstPedidos(List<Pedido> lstPedidos) {
		this.lstPedidos = lstPedidos;
	}

	public List<ReporteVenta> getLstReportes() {
		return lstReportes;
	}

	public void setLstReportes(List<ReporteVenta> lstReportes) {
		this.lstReportes = lstReportes;
	}

	@Override
	public String toString() {
		return "Sistema [lstFestivales=" + lstFestivales + ", lstUnidadesVenta=" + lstUnidadesVenta
				+ ", lstPersonalGlobal=" + lstPersonalGlobal + ", lstPedidos=" + lstPedidos + ", lstReportes="
				+ lstReportes + "]";
	}
	
	
}
