package Dominio;

public class Bebida {
public String nombre;
public int cantidad;
public Bebida(String nombre, int cantidad) {
	super();
	this.nombre = nombre;
	this.cantidad = cantidad;
}
public Bebida(String nombre) {
	this.nombre=nombre;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
@Override
public String toString() {
	return "Bebida [nombre=" + nombre + ", cantidad=" + cantidad + "]";
}

}