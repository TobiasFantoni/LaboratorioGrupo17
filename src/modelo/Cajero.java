package modelo;

import java.time.LocalDate;

public class Cajero extends Persona {
	
	private String turno;

	public Cajero(long dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase, String turno) {
		super(dni, nombre, apellido, fechaNacimiento, sueldoBase);
		this.turno = turno;
	}
	
	@Override
	public double calcularSueldo() {
		
		return this.sueldoBase + (this.calcularAntiguedad()*5000);
		
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	
}