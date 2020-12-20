package Dominio;

import java.util.ArrayList;

public class Plato {
	
	String nombre;
	ArrayList <Ingrediente> ingredientes= new ArrayList<Ingrediente>();
	
	public Plato(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Plato(ArrayList<Ingrediente> ingredientes) {
		super();
		this.ingredientes = ingredientes;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
