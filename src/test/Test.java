package test;

import java.time.LocalDate;

import modelo.Sistema;
import modelo.UnidadVenta;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			sistema.agregarFestival("Cosquín Rock", "Verano 2026", 1500.0, LocalDate.of(2026, 2, 14), LocalDate.of(2026, 2, 16));
			sistema.agregarFestival("Food Truck Fest", "Primavera 2026", 1800.0, LocalDate.of(2026, 9, 18), LocalDate.of(2026, 9, 20));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sistema.agregarCocinero(30123456, "Juan", "Pérez", LocalDate.of(1988, 5, 12), 950000f, "Parrilla", 3);
			sistema.agregarCocinero(27894561, "Carla", "Sánchez", LocalDate.of(1985, 11, 3), 980000f, "Comida Mexicana", 4);
			sistema.agregarCajero(35678912, "Martín", "Gómez", LocalDate.of(1992, 8, 15), 780000f, "Tarde");
			sistema.agregarCajero(28987654, "Sofía", "Martínez", LocalDate.of(1990, 4, 8), 850000f, "Noche");
			sistema.agregarCajero(33456789, "Diego", "Rodríguez", LocalDate.of(1987, 9, 22), 900000f, "Mañana");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sistema.agregarUnidadVentaPuestoDesmotable("Burger House", sistema.buscarPersonalPorDni(35678912), 25.0, sistema.getLstPersonalGlobal(), "PD001", 3, 120);
			sistema.agregarUnidadVentaFoodTruck("Chori Móvil", sistema.buscarPersonalPorDni(28987654), 20.0, sistema.getLstPersonalGlobal(), "FT001", "AE123BC", true);
			sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Hamburguesa Completa", 12000.0f, 4500.0f);
			System.out.println(sistema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("PD001").calcularCanon());
		System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("FT001").calcularCanon());
		
		System.out.println(sistema.obtenerRecaudacionFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026",LocalDate.of(2026, 2, 14))));
		
		
	}
}
