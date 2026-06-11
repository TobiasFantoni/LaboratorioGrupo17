package test;

import java.time.LocalDate;

import modelo.*;
import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Caso de uso 1(Altas y Bajas):");
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
			sistema.agregarUnidadVentaPuestoDesmotable("Burger House", sistema.buscarPersonaPorDni(35678912), 25.0, sistema.getLstPersonalGlobal(), "PD00000001", 3, 120);
			sistema.agregarUnidadVentaPuestoDesmotable("Taco Express", sistema.buscarPersonaPorDni(33456789), 18.0, sistema.getLstPersonalGlobal(), "PD00000002", 2, 90);
			sistema.agregarUnidadVentaPuestoDesmotable("Parrilla Criolla", sistema.buscarPersonaPorDni(27894561), 35.0, sistema.getLstPersonalGlobal(), "PD00000005", 5, 180);
			sistema.agregarUnidadVentaFoodTruck("Chori Móvil", sistema.buscarPersonaPorDni(28987654), 20.0, sistema.getLstPersonalGlobal(), "FT00000001", "AE123BC", true);
			sistema.agregarUnidadVentaFoodTruck("Burger Wheels", sistema.buscarPersonaPorDni(27894561), 22.0, sistema.getLstPersonalGlobal(), "FT00000002", "AF456CD", false);
			sistema.agregarUnidadVentaFoodTruck("Tacos Sobre Ruedas", sistema.buscarPersonaPorDni(32145678), 19.5, sistema.getLstPersonalGlobal(), "FT00000003", "AG789EF", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		UnidadVenta unidad1F1 = sistema.buscarUnidadVentaPorCodigoUnico("PD00000001");
		UnidadVenta unidad2F1 = sistema.buscarUnidadVentaPorCodigoUnico("PD00000002");
		UnidadVenta unidad3F1 = sistema.buscarUnidadVentaPorCodigoUnico("PD00000005");
		UnidadVenta unidad1F2 = sistema.buscarUnidadVentaPorCodigoUnico("FT00000001");
		UnidadVenta unidad2F2 = sistema.buscarUnidadVentaPorCodigoUnico("FT00000002");
		UnidadVenta unidad3F2 = sistema.buscarUnidadVentaPorCodigoUnico("FT00000003");
		
		try {
			//Generamos los festivales
			sistema.agregarFestival("Cosquín Rock", "Verano", 1500.0, LocalDate.of(2026, 2, 14), LocalDate.of(2026, 2, 16));
			sistema.agregarFestival("Food Truck Fest", "Primavera", 1800.0, LocalDate.of(2026, 9, 18), LocalDate.of(2026, 9, 20));
			//Agregamos Unidades a los festivales
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14)), 
					sistema.buscarUnidadVentaPorCodigoUnico("PD00000001"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14)), 
					sistema.buscarUnidadVentaPorCodigoUnico("PD00000002"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14)), 
					sistema.buscarUnidadVentaPorCodigoUnico("PD00000005"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18)), 
					sistema.buscarUnidadVentaPorCodigoUnico("FT00000001"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18)), 
					sistema.buscarUnidadVentaPorCodigoUnico("FT00000002"));
			sistema.agregarUnidadVentaParaFestival(sistema.buscarFestivalPorDatos("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18)), 
					sistema.buscarUnidadVentaPorCodigoUnico("FT00000003"));
			System.out.println(sistema.getLstFestivales());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Festival festival1 = sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14));
		Festival festival2 = sistema.buscarFestivalPorDatos("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18));
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 2(Búsqueda por Atributo Único):");
		
		System.out.println(sistema.buscarPersonaPorDni(28987654));
		System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("PD00000001"));
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 3(Cálculo de Canon):");
		
		System.out.println("El puesto de venta "+ sistema.buscarUnidadVentaPorCodigoUnico("PD00000001").getNombreComercial() + 
				" sale:"+sistema.buscarUnidadVentaPorCodigoUnico("PD00000001").calcularCanon());
		System.out.println("El puesto de venta "+ sistema.buscarUnidadVentaPorCodigoUnico("FT00000003").getNombreComercial() + 
				" sale:"+sistema.buscarUnidadVentaPorCodigoUnico("FT00000003").calcularCanon());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 4(Liquidación de Haberes):");

		System.out.println(sistema.buscarPersonaPorDni(35678912).calcularSueldo());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 5:");
		
		try {
			System.out.println("Agregando platos a las unidades de venta:");
			unidad1F1.agregarPlato("Hamburguesa", 10, 5);
			unidad1F1.agregarPlato("Papas", 5, 2);
			unidad2F1.agregarPlato("Ensalada", 10, 15);
			unidad2F1.agregarPlato("Aderezo", 5, 2);
			unidad3F1.agregarPlato("Balde nuggets", 30, 20);
			unidad3F1.agregarPlato("Gaseosa", 16, 8);
			unidad1F2.agregarPlato("Pancho", 10, 5);
			unidad1F2.agregarPlato("Sprite", 5, 2);
			unidad2F2.agregarPlato("Sundae", 10, 7);
			unidad2F2.agregarPlato("Torta", 15, 10);
			unidad3F2.agregarPlato("Wrap de pollo", 20, 10);
			unidad3F2.agregarPlato("Mayonesa", 5, 2);
			System.out.println("Platos agregados");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Registro de pedidos:");
		
		try {
			
			ArrayList<ItemPedido> detallePedido1U1F1 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido2U1F1 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido1U2F1 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido2U2F1 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido1U3F1 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido2U3F1 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido1U1F2 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido2U1F2 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido1U2F2 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido2U2F2 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido1U3F2 = new ArrayList<>();
			ArrayList<ItemPedido> detallePedido2U3F2 = new ArrayList<>();
			
			detallePedido1U1F1.add(new ItemPedido(unidad1F1.buscarPlatoPorNombre("Hamburguesa"), 2));
			detallePedido2U1F1.add(new ItemPedido(unidad1F1.buscarPlatoPorNombre("Papas"), 2));
			detallePedido1U2F1.add(new ItemPedido(unidad2F1.buscarPlatoPorNombre("Ensalada"), 1));
			detallePedido2U2F1.add(new ItemPedido(unidad2F1.buscarPlatoPorNombre("Aderezo"), 1));
			detallePedido1U3F1.add(new ItemPedido(unidad3F1.buscarPlatoPorNombre("Balde nuggets"), 1));
			detallePedido2U3F1.add(new ItemPedido(unidad3F1.buscarPlatoPorNombre("Gaseosa"), 2));
			detallePedido1U1F2.add(new ItemPedido(unidad1F2.buscarPlatoPorNombre("Pancho"), 2));
			detallePedido2U1F2.add(new ItemPedido(unidad1F2.buscarPlatoPorNombre("Sprite"), 1));
			detallePedido1U2F2.add(new ItemPedido(unidad1F2.buscarPlatoPorNombre("Sprite"), 1));
			detallePedido2U2F2.add(new ItemPedido(unidad1F2.buscarPlatoPorNombre("Sprite"), 1));
			detallePedido1U3F2.add(new ItemPedido(unidad1F2.buscarPlatoPorNombre("Sprite"), 1));
			detallePedido2U3F2.add(new ItemPedido(unidad1F2.buscarPlatoPorNombre("Sprite"), 1));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 6(Reporte de Recaudación):");
		
		System.out.println(sistema.obtenerRecaudacionFestival(festival1));
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 7(Filtro de Personal por Edad):");
		System.out.println("Filtro al personal entre las fechas "+ LocalDate.of(1985, 11, 3)+" y "+ LocalDate.of(1990, 11, 22)+sistema.filtrarPersonalPorEdad(LocalDate.of(1985, 11, 3), LocalDate.of(1990, 11, 22)));
		
		System.out.println("Caso de uso 10(Ranking de Unidades):");
		
		sistema.rankingUnidades(festival2);
		
//		
//		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Hamburguesa Completa", 12000, 4500);
//		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Pizza Muzzarella", 15000, 6000);
//		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Lomito Completo", 18000, 7500);
//		sistema.buscarUnidadVentaPorCodigoUnico("PD001").agregarPlato("Tacos Mexicanos", 14000, 5500);
//		sistema.
//		sistema.registrarPedido(LocalDate.of(2026, 9, 18), sistema.buscarUnidadVentaPorCodigoUnico("PD001"), sistema.buscarUnidadVentaPorCodigoUnico("PD001").buscarPlatoPorNombre("Hamburguesa Completa"), true);
//		sistema.registrarPedido(sistema.buscarUnidadVentaPorCodigoUnico("FT001"), sistema.buscarUnidadVentaPorCodigoUnico("PD001").buscarPlatoPorNombre("Pizza Muzzarella"), LocalDate.of(2026, 9, 18), false);
//		sistema.registrarPedido(sistema.buscarUnidadVentaPorCodigoUnico("FT002"), sistema.buscarPlatoPorNombre("Tacos Mexicanos"), LocalDate.of(2026, 9, 19), true);
		
		
		//System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("PD001").calcularCanon());
		//System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("FT001").calcularCanon());
		
		//System.out.println(sistema.obtenerRecaudacionFestival(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026",LocalDate.of(2026, 2, 14))));
		
		//System.out.println(sistema.filtrarPersonalPorEdad(LocalDate.of(1985, 11, 3), LocalDate.of(1987, 9, 22)));
		
		
		
		//System.out.println("La recaudacion de la unidad de venta es de: "+sistema.calcularRentabilidadNeta(sistema.buscarUnidadVentaPorCodigoUnico("FT001")));
		
		
		
		//System.out.println("El ranking de unidades del festival es: "+sistema.rankingUnidades(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026",LocalDate.of(2026, 2, 14))));
		
		
		
		//System.out.println(sistema.obtenerPlatoEstrella(sistema.buscarUnidadVentaPorCodigoUnico("PD001")));
		
		//System.out.println(sistema.canonTop3(sistema.buscarFestivalPorDatos("Cosquín Rock", "Verano 2026",LocalDate.of(2026, 2, 14))));
	}
}