package modelo;

import java.time.LocalDate;

public class Cajero extends Persona {
	
	private String turno;

	public Cajero(int dni, String nombre, String apellido, LocalDate fechaNacimiento, float sueldoBase, String turno) {
		super(dni, nombre, apellido, fechaNacimiento, sueldoBase);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	
}
