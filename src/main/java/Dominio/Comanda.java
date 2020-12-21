package Dominio;

import java.util.ArrayList;
import java.util.Iterator;
//RAFA
public class Comanda {

	private ArrayList<Bebida> bebidas;
	private ArrayList<Plato> entrantes;
	private ArrayList<Plato> primer_plato;
	private ArrayList<Plato> segundo_plato;
	private ArrayList<Plato> postre;
	private int mesa_asociada;
	private int id_camarero; 

	public Comanda(int id_camarero, int mesa) {
		this.id_camarero=id_camarero;
		this.mesa_asociada=mesa;
	}
	public Comanda(int mesa) {
		this.mesa_asociada=mesa;
	}
	
	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	public int getId_camarero() {
		return id_camarero;
	}

	public void setId_camarero(int id_camarero) {
		this.id_camarero = id_camarero;
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
	public int getMesa_asociada() {
		return mesa_asociada;
	}
	public void setMesa_asociada(int mesa_asociada) {
		this.mesa_asociada = mesa_asociada;
	}

	public ArrayList<Bebida> getBebidas() {
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
	public void AnadirBebidas(Bebida bebida) {
		int posicion=0;
		Iterator<Bebida>iter = bebidas.iterator();
		while (iter.hasNext()) {
			Bebida b= iter.next();
			if (b.getNombre()== bebida.getNombre()) {
				posicion=bebidas.indexOf(b);
				bebidas.get(posicion).setCantidad(bebidas.get(posicion).getCantidad()+bebida.getCantidad());
			}else {
				bebidas.add(bebida);
			}
		}
	}


}