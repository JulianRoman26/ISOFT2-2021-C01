package Dominio;

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
	protected int id_empleado;
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
	
}
