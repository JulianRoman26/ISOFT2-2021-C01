package Dominio;

import java.util.ArrayList;
import java.util.Iterator;

// JULIAN
public class Cocinero implements Carta{

	public int avisarCamarero_Mesa_ComidaLista() {
		System.out.println("Comanda lista.");
		return 1;
	}

	/**
	 * 
	 * @param comanda
	 */
	public void cocinarPlatos(Comanda comanda) {
		
		 int cantidadCocina=0;
		 int listo=0;
		 Plato p=new Plato();
		 String nombre="";
		 ArrayList<Ingrediente> ingredientes=new ArrayList<Ingrediente>();

		
		 ArrayList<Plato> entrantes= comanda.getEntrantes();
		 ArrayList<Plato> primeros= comanda.getPrimer_plato();
		 ArrayList<Plato> segundos= comanda.getSegundo_plato();
		 ArrayList<Plato> postres= comanda.getPostre();
		 
		 for(int i = 0;i<entrantes.size();i++) {
			 
			 nombre=entrantes.get(i).getNombre();		
			 p=Carta.getEntrantes(p);
			 
			 ingredientes=p.getIngredientes();
			 for(int j = 0;j<ingredientes.size();j++) {
				 if(ingredientes.get(j).getCantidad()<cantidadCocina) {
					 reponerAlmacen(ingredientes,j);
				 }
			 }
			  
		 }
		 
		 for(int i = 0;i<primeros.size();i++) {
			 
			 nombre=primeros.get(i).getNombre();		
			 p=Carta.getPrimerPlato(p);
			 
			 ingredientes=p.getIngredientes();
			 for(int j = 0;j<ingredientes.size();j++) {
				 if(ingredientes.get(j).getCantidad()<cantidadCocina) {
					 reponerAlmacen(ingredientes, j);
				 }
			 }
			  
		 }
		 
		 for(int i = 0;i<segundos.size();i++) {
			 
			 nombre=segundos.get(i).getNombre();		
			 p=Carta.getSegundoPlato(p);
			 
			 ingredientes=p.getIngredientes();
			 for(int j = 0;j<ingredientes.size();j++) {
				 if(ingredientes.get(j).getCantidad()<cantidadCocina) {
					 reponerAlmacen(ingredientes, j);
				 }
			 }
			  
		 }
		 
		 for(int i = 0;i<postres.size();i++) {
			 
			 nombre=postres.get(i).getNombre();		
			 p=Carta.getPostre(p);
			 
			 ingredientes=p.getIngredientes();
			 for(int j = 0;j<ingredientes.size();j++) {
				 if(ingredientes.get(j).getCantidad()<cantidadCocina) {
					 reponerAlmacen(ingredientes, j);
				 }
			 }
			  
		 }
		 
		 listo=1;
	
		if(listo==1) {
			avisarCamarero_Mesa_ComidaLista();
		}

	}

	/**
	 * 
	 * @param ingredientes
	 */
	public int reponerAlmacen(ArrayList<Ingrediente> ingredientes, int posicion) {
		
		int cantidad=ingredientes.get(posicion).getCantidad();
		return cantidad+30;
		
	}

}