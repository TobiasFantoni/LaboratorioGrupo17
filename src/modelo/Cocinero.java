package modelo;

import java.time.LocalDate;

public class Cocinero extends Persona{
	
	private String especialidad;
	private int plusCategoria;
	
	
	public Cocinero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase,
			String especialidad, int plusCategoria) {
		super(dni, nombre, apellido, fechaNacimiento, sueldoBase);
		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}
	
	public Cocinero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate ingreso,float sueldoBase,
			String especialidad, int plusCategoria) {
		super(dni, nombre, apellido, fechaNacimiento, ingreso,sueldoBase);
		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}
	
	
	
	@Override
	public String toString() {
		return "\n\nCocinero: "+this.getNombre()+" "+this.getApellido()+"\nDNI: "+this.getDni()+"\nEspecialidad: "+this.getEspecialidad()+"\nSUELDO BASE: "+this.getSueldoBase();
	}



	@Override
	public double calcularSueldo() {
		return this.sueldoBase + this.plusCategoria;
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
