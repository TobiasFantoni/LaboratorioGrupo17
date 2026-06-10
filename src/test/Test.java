package test;

import java.time.LocalDate;

import modelo.Sistema;
import modelo.UnidadVenta;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			sistema.agregarCocinero(30123456, "Juan", "Pérez", LocalDate.of(1988, 5, 12), 950000f, "Parrilla", 3);
			sistema.agregarCocinero(27894561, "Carla", "Sánchez", LocalDate.of(1985, 11, 3), 980000f, "Comida Mexicana", 4);
			sistema.agregarCajero(35678912, "Martín", "Gómez", LocalDate.of(1992, 8, 15), 780000f, "Tarde");
			sistema.agregarCajero(28987654, "Sofía", "Martínez", LocalDate.of(1990, 4, 8), 850000f, "Noche");
			sistema.agregarCajero(33456789, "Diego", "Rodríguez", LocalDate.of(1987, 9, 22), 900000f, "Mañana");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			sistema.agregarUnidadVentaPuestoDesmotable("Burger House", sistema.buscarPersonaPorDni(35678912), 25.0, sistema.getLstPersonalGlobal(), "PD001", 3, 120);
			sistema.agregarUnidadVentaPuestoDesmotable("Taco Express", sistema.buscarPersonaPorDni(33456789), 18.0, sistema.getLstPersonalGlobal(), "PD002", 2, 90);
			sistema.agregarUnidadVentaPuestoDesmotable("Parrilla Criolla", sistema.buscarPersonaPorDni(27894561), 35.0, sistema.getLstPersonalGlobal(), "PD005", 5, 180);
			sistema.agregarUnidadVentaFoodTruck("Chori Móvil", sistema.buscarPersonaPorDni(28987654), 20.0, sistema.getLstPersonalGlobal(), "FT001", "AE123BC", true);
			sistema.agregarUnidadVentaFoodTruck("Burger Wheels", sistema.buscarPersonaPorDni(27894561), 22.0, sistema.getLstPersonalGlobal(), "FT002", "AF456CD", false);
			sistema.agregarUnidadVentaFoodTruck("Tacos Sobre Ruedas", sistema.buscarPersonaPorDni(32145678), 19.5, sistema.getLstPersonalGlobal(), "FT003", "AG789EF", true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Hamburguesa Completa", 12000, 4500);
		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Pizza Muzzarella", 15000, 6000);
		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Lomito Completo", 18000, 7500);
		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Tacos Mexicanos", 14000, 5500);

		sistema.registrarPedido(sistema.buscarUnidadVentaPorCodigoUnico("PD001"), sistema.buscarUnidadVentaPorCodigoUnico("PD001").buscarPlatoPorNombre("Hamburguesa Completa"), LocalDate.of(2026, 9, 18), true);
		sistema.registrarPedido(sistema.buscarUnidadVentaPorCodigoUnico("FT001"), sistema.buscarUnidadVentaPorCodigoUnico("PD001").buscarPlatoPorNombre("Pizza Muzzarella"), LocalDate.of(2026, 9, 18), false);
		sistema.registrarPedido(sistema.buscarUnidadVentaPorCodigoUnico("FT002"), sistema.buscarPlatoPorNombre("Tacos Mexicanos"), LocalDate.of(2026, 9, 19), true);
		
		try {
			sistema.agregarFestival("Cosquín Rock", "Verano 2026", 1500.0, LocalDate.of(2026, 2, 14), LocalDate.of(2026, 2, 16));
			sistema.agregarFestival("Food Truck Fest", "Primavera 2026", 1800.0, LocalDate.of(2026, 9, 18), LocalDate.of(2026, 9, 20));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026", LocalDate.of(2026, 2, 14)), sistema.buscarUnidadVentaPorCodigoUnico("PD001"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026", LocalDate.of(2026, 2, 14)), sistema.buscarUnidadVentaPorCodigoUnico("PD002"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026", LocalDate.of(2026, 2, 14)), sistema.buscarUnidadVentaPorCodigoUnico("PD005"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Food Truck Fest", "Primavera 2026", LocalDate.of(2026, 9, 18)), sistema.buscarUnidadVentaPorCodigoUnico("FT001"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("PD001").calcularCanon());
		//System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("FT001").calcularCanon());
		
		//System.out.println(sistema.obtenerRecaudacionFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026",LocalDate.of(2026, 2, 14))));
		
		//System.out.println(sistema.filtrarPersonalPorEdad(LocalDate.of(1985, 11, 3), LocalDate.of(1987, 9, 22)));
		
		
		
		System.out.println("La recaudacion de la unidad de venta es de: "+sistema.calcularRentabilidadNeta(sistema.buscarUnidadVentaPorCodigoUnico("FT001")));
		
		System.out.println("El ranking de unidades del festival es: "+sistema.rankingUnidades(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026",LocalDate.of(2026, 2, 14))));
	}
}
