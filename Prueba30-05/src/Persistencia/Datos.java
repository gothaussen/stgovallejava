package Persistencia;

import java.util.ArrayList;

public class Datos {
	
	public static ArrayList data = new ArrayList();
	
	String nombre, rut, apellidos, fNacimiento, direccion;
	
	public Datos(String Rut, String Nombre, String Apellidos, String Nacimiento, String Direccion) {
		this.rut = Rut;
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.fNacimiento = Nacimiento;
		this.direccion = Direccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getRut() {
		return this.rut;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public String getNacimiento() {
		return this.fNacimiento;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
}
