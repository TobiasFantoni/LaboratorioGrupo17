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
			sistema.agregarCocinero(30123456, "Juan", "Pérez", LocalDate.of(1988, 5, 12), LocalDate.of(2025, 03, 05), 95000f, "Parrilla", 3);
			sistema.agregarCocinero(27894561, "Carla", "Sánchez", LocalDate.of(1985, 11, 3) ,98000f, "Comida Mexicana", 4);
			sistema.agregarCajero(35678912, "Martín", "Gómez", LocalDate.of(1992, 8, 15), LocalDate.of(2021, 02, 03),78000f, "Tarde");
			sistema.agregarCajero(28987654, "Sofía", "Martínez", LocalDate.of(1990, 4, 8), LocalDate.of(2024, 12, 05),85000f, "Noche");
			sistema.agregarCajero(33456789, "Diego", "Rodríguez", LocalDate.of(1987, 9, 22), LocalDate.of(2023, 11, 02),90000f, "Mañana");
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
		
		System.out.println("\n\nBUSCAR CAJERO CON DNI: 28987654");
		System.out.println(sistema.buscarPersonaPorDni(28987654));
		System.out.println("\n\nBUSCAR UNIDAD POR CODIGO: PD00000001");
		System.out.println(sistema.buscarUnidadVentaPorCodigoUnico("PD00000001"));
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 3(Cálculo de Canon):");
		
		System.out.println("El puesto de venta "+ sistema.buscarUnidadVentaPorCodigoUnico("PD00000001").getNombreComercial() + 
				" sale:"+sistema.buscarUnidadVentaPorCodigoUnico("PD00000001").calcularCanon());
		System.out.println("El puesto de venta "+ sistema.buscarUnidadVentaPorCodigoUnico("FT00000003").getNombreComercial() + 
				" sale:"+sistema.buscarUnidadVentaPorCodigoUnico("FT00000003").calcularCanon());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 4(Liquidación de Haberes):");
		
		System.out.println(sistema.buscarPersonaPorDni(35678912).toString());
		System.out.println("SUELDO CON PLUS POR ANTIGUEDAD: "+sistema.buscarPersonaPorDni(35678912).calcularSueldo());
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Caso de uso 5:");
		
		try {
			System.out.println("Agregando platos a las unidades de venta:");
			unidad1F1.agregarPlato("Hamburguesa", 1000000, 5000);
			unidad1F1.agregarPlato("Papas", 500000, 2000);
			unidad2F1.agregarPlato("Ensalada", 1000000, 15000);
			unidad2F1.agregarPlato("Aderezo", 500000, 2000);
			unidad3F1.agregarPlato("Balde nuggets", 3000000, 20000);
			unidad3F1.agregarPlato("Gaseosa", 1600000, 8000);
			unidad1F2.agregarPlato("Pancho", 1000000, 5000);
			unidad1F2.agregarPlato("Sprite", 500000, 2000);
			unidad2F2.agregarPlato("Sundae", 1000000, 7000);
			unidad2F2.agregarPlato("Torta", 1500000, 10000);
			unidad3F2.agregarPlato("Wrap de pollo", 2000000, 10000);
			unidad3F2.agregarPlato("Mayonesa", 500000, 2000);
			System.out.println("Platos agregados");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Registro de pedidos:");
		
		try {
			
			System.out.println("TOMANDO DETALLE DE PEDIDOS...");
			
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
			detallePedido2U1F2.add(new ItemPedido(unidad1F2.buscarPlatoPorNombre("Sprite"), 6));
			detallePedido1U2F2.add(new ItemPedido(unidad2F2.buscarPlatoPorNombre("Sundae"), 2));
			detallePedido2U2F2.add(new ItemPedido(unidad2F2.buscarPlatoPorNombre("Torta"), 4));
			detallePedido1U3F2.add(new ItemPedido(unidad3F2.buscarPlatoPorNombre("Wrap de pollo"), 2));
			detallePedido2U3F2.add(new ItemPedido(unidad3F2.buscarPlatoPorNombre("Mayonesa"), 3));
			
			System.out.println("REGISTRANDO PEDIDOS..");
			
			sistema.registrarPedido("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14), "PD00000001", detallePedido1U1F1);
			sistema.registrarPedido("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14), "PD00000001", detallePedido2U1F1);
			sistema.registrarPedido("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14), "PD00000002", detallePedido1U2F1);
			sistema.registrarPedido("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14), "PD00000002", detallePedido2U2F1);
			sistema.registrarPedido("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14), "PD00000005", detallePedido1U3F1);
			sistema.registrarPedido("Cosquín Rock", "Verano", LocalDate.of(2026, 2, 14), "PD00000005", detallePedido2U3F1);
			sistema.registrarPedido("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18), "FT00000001", detallePedido1U1F2);
			sistema.registrarPedido("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18), "FT00000001", detallePedido2U1F2);
			sistema.registrarPedido("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18), "FT00000002", detallePedido1U2F2);
			sistema.registrarPedido("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18), "FT00000002", detallePedido2U2F2);
			sistema.registrarPedido("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18), "FT00000003", detallePedido1U3F2);
			sistema.registrarPedido("Food Truck Fest", "Primavera", LocalDate.of(2026, 9, 18), "FT00000003", detallePedido2U3F2);
			
			System.out.println("PEDIDOS REGISTRADOS:");
			
			for(Pedido p : sistema.getlstPedidos()) {
				System.out.println(p.toString());
			}
			
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
		
		sistema.rankingUnidades(festival1);
		
	}
}