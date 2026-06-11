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
	
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================

	//DANIEL
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
	
	public boolean eliminarFestival(Festival festival) {
		return this.lstFestivales.remove(festival);
	}
	
	
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	
	//TOBIAS
	
	
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
	
	private boolean validarEdad(LocalDate fechaNacimiento) {
		boolean valido = true;
		LocalDate edadLimite = LocalDate.now().minusYears(18);
		
		if(fechaNacimiento.isAfter(edadLimite)) {
			valido = false;
		}
		
		return valido;
	}
	
	private boolean validarAgregadoDePersonal(long dni, LocalDate fechaNacimiento) throws Exception {
		
		boolean valido = true;
		
		if(this.buscarPersonaPorDni(dni) != null) {
			throw new Exception("Ya existe una persona con el DNI: "+ dni);
		}else if(!validarEdad(fechaNacimiento)){
			throw new Exception("La persona que intenta agregar, es menor de 18 años.");
		}
		
		return valido;
	}
	
	public boolean agregarCocinero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase, String especialidad, int plusCategoria) {
		
		try {
			this.validarAgregadoDePersonal(dni, fechaNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Cocinero nuevoCocinero = new Cocinero(dni, nombre, apellido, fechaNacimiento, sueldoBase, especialidad ,plusCategoria);
		
		
		return this.lstPersonalGlobal.add(nuevoCocinero);
	} 
	
	//SOBRECARGA PARA AGREGAR FECHA DE INGRESO MANUAL
	public boolean agregarCocinero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate ingreso,float sueldoBase, String especialidad, int plusCategoria) throws Exception {
		
		try {
			this.validarAgregadoDePersonal(dni, fechaNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Cocinero nuevoCocinero = new Cocinero(dni, nombre, apellido, fechaNacimiento, ingreso, sueldoBase, especialidad ,plusCategoria);
		
		
		return this.lstPersonalGlobal.add(nuevoCocinero);
	} 
	
	
	
	public boolean agregarCajero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate ingreso,float sueldoBase, String turno) throws Exception {
		
		try {
			this.validarAgregadoDePersonal(dni, fechaNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Cajero nuevoCajero = new Cajero(dni, nombre, apellido, fechaNacimiento, ingreso ,sueldoBase, turno);
		
		
		return this.lstPersonalGlobal.add(nuevoCajero);
	}
	
	//SOBRECARGA PARA AGREGAR FECHA DE INGRESO MANUAL
	public boolean agregarCajero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase, String turno) throws Exception {
		
		try {
			this.validarAgregadoDePersonal(dni, fechaNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Cajero nuevoCajero = new Cajero(dni, nombre, apellido, fechaNacimiento, sueldoBase, turno);
		
		
		return this.lstPersonalGlobal.add(nuevoCajero);
	}
	
	public boolean eliminarPersona(long dni) throws Exception{
		if(this.buscarPersonaPorDni(dni)==null)throw new Exception("La persona con DNI: "+dni+" NO EXISTE.");
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
		
		double gananciaMenosSueldos = gananciaPedidos-totalSueldos;
		double gananciaMenosCanon = gananciaMenosSueldos - u.calcularCanon();

		return gananciaMenosCanon;
		
	}
	
	public boolean registrarPedido(String nombreFestival ,String temporadaFestival, LocalDate fechaIniFestival, String codigoUnidad, List<ItemPedido> detalle) throws Exception{

		Festival festival = this.buscarFestivalPorDatos(nombreFestival, temporadaFestival, fechaIniFestival);
		UnidadVenta unidad = this.buscarUnidadVentaPorCodigoUnico(codigoUnidad);
		
	    if ( unidad == null ||  festival == null) {
	        throw new Exception("El festival o unidad de venta no existen");
	    }

	    if (!festival.getLstUnidadVentas().contains(unidad)) {
	        throw new Exception("La unidad de venta no existe en el festival");
	    }

	    for (ItemPedido item : detalle) {
	        if (!unidad.getLstPlatos().contains(item.getPlato())) {
	            throw new Exception("El plato "+item.getPlato().getNombre()+" no existe en la unidad de venta");
	        }
	    }
	    
	    int nuevoIdPedido = 1;
	    
	    if(!this.lstPedidos.isEmpty()) {
	    	nuevoIdPedido = this.lstPedidos.getLast().getId()+1;
	    }

	    Pedido pedido = new Pedido(nuevoIdPedido, LocalDate.now(), unidad, festival, detalle, false);

	    
	    return this.lstPedidos.add(pedido);
	}
	
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	//==================================================================================================================================================================
	
	//MAXIMILIANO
	
	 public List<ReporteVenta> rankingUnidades() {

		    List<ReporteVenta> ranking = new ArrayList<>();
		    
		    for(UnidadVenta u : this.lstUnidadesVenta) {
		    	ReporteVenta reporte = new ReporteVenta(this.calcularRentabilidadNeta(u), u);
		    	ranking.add(reporte);
		    }
		    
		    return this.ordenarPorUnidadesVendidas(ranking);
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
	
	public List<ReporteVenta> obtenerRecaudacionFestival(Festival festival){
		
		
	    List<ReporteVenta> reporte = new ArrayList<>();
	    
	    for(int i = 0; i < festival.getLstUnidadVentas().size(); i++) {
	    	 double recaudacionFestival = 0;
	    	 recaudacionFestival = recaudacionFestival + this.calcularRentabilidadNeta(festival.getLstUnidadVentas().get(i));
	    	 reporte.add(new ReporteVenta(recaudacionFestival, festival.getLstUnidadVentas().get(i)));
	    }
	    
	   

	    return reporte;
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
	
	public boolean buscarUnidadDeVentaEnFestival(String codigoUnico,Festival f) throws Exception {
		boolean repetido = false;
		
		for(int i = 0; i < f.getLstUnidadVentas().size(); i++) {
			if(f.getLstUnidadVentas().get(i).getCodigoUnico().equals(codigoUnico)) {
				repetido = true;
			}
		}
		return repetido;
	}
	
	public boolean agregarUnidadVentaParaFestival(Festival f, UnidadVenta u) throws Exception {
		
		if(buscarUnidadDeVentaEnFestival(u.getCodigoUnico(), f) == true)throw new Exception("La unidad ya existe en el festival");

		
		return f.getLstUnidadVentas().add(u);
	}
	
	
	
	
	
	//getters y setters
	public List<Persona> getLstPersonalGlobal() {
		return lstPersonalGlobal;
	}
	
	public List<Festival> getLstFestivales() {
		return lstFestivales;
	}
	
	public List<Pedido> getlstPedidos() {
		return lstPedidos;
	}
	
	
}
