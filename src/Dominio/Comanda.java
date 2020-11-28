package Dominio;

import java.util.ArrayList;
//RAFA
public class Comanda {

	private ArrayList<String> bebidas;
	private ArrayList<String> entrantes;
	private ArrayList<String> primer_plato;
	private ArrayList<String> segundo_plato;
	private ArrayList<String> postre;
	private Mesa mesa_asociada;
	public ArrayList<String> getBebidas() {
		return bebidas;
	}
	public ArrayList<String> getEntrantes() {
		return entrantes;
	}
	public ArrayList<String> getPrimer_plato() {
		return primer_plato;
	}
	public ArrayList<String> getSegundo_plato() {
		return segundo_plato;
	}
	public ArrayList<String> getPostre() {
		return postre;
	}
	public Mesa getMesa_asociada() {
		return mesa_asociada;
	}

}