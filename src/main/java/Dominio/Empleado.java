package Dominio;

import java.util.ArrayList;

import Persistencia.Agente;

public abstract class Empleado {
	public Empleado( int id_empleado,String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.id_empleado = id_empleado;
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	public Empleado( int id_empleado) {

		this.id_empleado = id_empleado;
	
	}
	protected String nombre;
	protected static int id_empleado;
	protected String telefono;
	public String getNombre() {
		return nombre;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public static int obtenerNotificaciones(int identificador_usuario) {
		int n_mensajes=0;
		n_mensajes=Integer.parseInt(Agente.get("COUNT * FROM Notificiones WHERE destino = "+ identificador_usuario +""));
		return n_mensajes;
	}

	public static ArrayList<ArrayList<String>> mostrarNotificaciones(int identificador_usuario) {
		ArrayList<ArrayList<String>> notificaciones= Agente.getMany("SELECT * FROM Notificaciones WHERE destino = "+identificador_usuario +"");
		return notificaciones;
	}
	
	public static void mandarNotificacion(String notificacion,Comanda comanda) {
		Agente.insertar("INSERT INTO notificaciones VALUES (origen, destino, mensaje) VALUES ("+ id_empleado +","+comanda.getId_camarero()+","+notificacion +")");
		// TODO Auto-generated method stub
	}
	
	public static void eliminarNotificacion(String identificador) {
		Agente.eliminar("DELETE * FROM notificaciones WHERE id= " +identificador+ "");
		// TODO Auto-generated method stub	
	}
}
