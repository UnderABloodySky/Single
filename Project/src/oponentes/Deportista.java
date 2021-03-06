package oponentes;

import java.sql.Date;

import identificables.*;

public class Deportista implements Oponente, Identificable{
	String nombre;
	String apellido;
	Date fechaNacimiento;
	String lugarDeNacimiento;
	
	public Deportista(String nombre,String apellido,Date fechaNacimiento,String  lugarDeNacimiento) {
		
		this.nombre=nombre;
		this.apellido = apellido;
		this.fechaNacimiento=fechaNacimiento;
		this.lugarDeNacimiento=lugarDeNacimiento;
		
	}

	@Override
	public String nombre() {
		return this.getNombre() + " " + this.getApellido();
	}

	private String getNombre() {
		return nombre;
	}
	
	private String getApellido() {
		return apellido;
	}

	@Override
	public Boolean es(Object _object) {
		return this.hashCode() == _object.hashCode();
	}
	
}


