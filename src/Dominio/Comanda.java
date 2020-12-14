package Dominio;

import java.util.ArrayList;
//RAFA
public class Comanda {

	private ArrayList<String> bebidas;
	private ArrayList<Plato> entrantes;
	private ArrayList<Plato> primer_plato;
	private ArrayList<Plato> segundo_plato;
	private ArrayList<Plato> postre;
	private Mesa mesa_asociada;
	/*private int id;

	//public void setId(int id) {
		this.id = id;
	}*/
	public void setBebidas(ArrayList<String> bebidas) {
		this.bebidas = bebidas;
	}
	public void setEntrantes(ArrayList<Plato> entrantes) {
		this.entrantes = entrantes;
	}
	public void setPrimer_plato(ArrayList<Plato> primer_plato) {
		this.primer_plato = primer_plato;
	}
	public void setSegundo_plato(ArrayList<Plato> segundo_plato) {
		this.segundo_plato = segundo_plato;
	}
	public void setPostre(ArrayList<Plato> postre) {
		this.postre = postre;
	}
	public void setMesa_asociada(Mesa mesa_asociada) {
		this.mesa_asociada = mesa_asociada;
	}
	/*public int getId() {
		return id;
	}*/
	public ArrayList<String> getBebidas() {
		return bebidas;
	}
	public ArrayList<Plato> getEntrantes() {
		return entrantes;
	}
	public ArrayList<Plato> getPrimer_plato() {
		return primer_plato;
	}
	public ArrayList<Plato> getSegundo_plato() {
		return segundo_plato;
	}
	public ArrayList<Plato> getPostre() {
		return postre;
	}
	public Mesa getMesa_asociada() {
		return mesa_asociada;
	}

}