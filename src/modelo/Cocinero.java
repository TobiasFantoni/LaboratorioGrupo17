package modelo;

import java.time.LocalDate;

public abstract class Cocinero extends Persona{
	
	private String especialidad;
	private int plusCategoria;
	
	
	public Cocinero(int dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase,
			String especialidad, int plusCategoria) {
		super(dni, nombre, apellido, fechaNacimiento, sueldoBase);
		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public int getPlusCategoria() {
		return plusCategoria;
	}


	public void setPlusCategoria(int plusCategoria) {
		this.plusCategoria = plusCategoria;
	}
	
	
	
}
