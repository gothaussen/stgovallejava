package Aplicacion;

import Persistencia.Datos;

public class Buscar {

	public Buscar() {
		
	}
	
	public boolean buscador(String Rut) {
		boolean res = false;
		for(int i=0; i<Datos.data.size(); i++) {
			if (((Datos) Datos.data.get(i)).getRut().equals(Rut)) {
				res = true;
			}
		}
		return res;
	}
	
	public int BuscarIndex(String Rut) {
		int res = 0;
		for(int i=0; i<Datos.data.size(); i++) {
			if (((Datos) Datos.data.get(i)).getRut().equals(Rut)) {
				res = i;
			}
		}
		
		return res;
		
	}
	
	public String  rut(String Rut) {
		String res = ((Datos) Datos.data.get(this.BuscarIndex(Rut))).getRut();
		return res;
	}
	
	public String nombre(String Rut) {		
		String res = ((Datos) Datos.data.get(this.BuscarIndex(Rut))).getNombre();
		return res;
	}
	
	public String apellidos(String Rut) {
		String res = ((Datos) Datos.data.get(this.BuscarIndex(Rut))).getApellidos();
		return res;
	}
	
	public String fNacimiento(String Rut) {
		String res = ((Datos) Datos.data.get(this.BuscarIndex(Rut))).getNacimiento();
		return res;
	}
	
	public String direccion(String Rut) {
		String res = ((Datos) Datos.data.get(this.BuscarIndex(Rut))).getDireccion();
		return res;
	}
		
}
