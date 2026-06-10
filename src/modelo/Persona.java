package modelo;

import java.time.LocalDate;

public abstract class Persona {
	
	protected long dni;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	protected float sueldoBase;
	
	public Persona(long dni, String nombre, String apellido, LocalDate fechaNacimiento,
			float sueldoBase) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = LocalDate.now();
		this.sueldoBase = sueldoBase;
	}
	
	public long getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public abstract double calcularSueldo();
	
	public double calcularAntiguedad() {
		long diasIngreso = this.fechaIngreso.toEpochDay();
        long diasActual = LocalDate.now().toEpochDay();
        
        return (diasActual - diasIngreso) / 365;
	}

	@Override
	public String toString() {
		return "\nPersona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase=" + sueldoBase + "]";
	}
}