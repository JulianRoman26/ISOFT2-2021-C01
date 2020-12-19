package Dominio;

import java.util.ArrayList;
import java.util.Iterator;

import Persistencia.Agente;
import Presentacion.IU_Camarero;

// JULIAN
public class Cocinero implements Carta{
	
	public Cocinero() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param comanda
	 */
	public int avisarCamarero_Mesa_PlatosListos() {
		String mensaje= "LOS PLATOS DE LA COMANDA X YA ESTAN LISTOS PARA SER SERVIDOS ";
		IU_Camarero.getNotificaciones().add(mensaje);
		throw new UnsupportedOperationException();
	}
	
	public static void cocinarPlatos(Comanda comanda) {
		Plato p=new Plato("");
		
		ArrayList<Ingrediente> ingredientes=new ArrayList<Ingrediente>();


		ArrayList<Plato> entrantes= comanda.getEntrantes();
		ArrayList<Plato> primeros= comanda.getPrimer_plato();
		ArrayList<Plato> segundos= comanda.getSegundo_plato();
		ArrayList<Plato> postres= comanda.getPostre();

		for(int i = 0;i<entrantes.size();i++) {
			p.setNombre(entrantes.get(i).getNombre());
			p=Carta.getEntrantes(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {

				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE id_producto="+ ingredientes.get(0).getId());
			}

		}

		for(int i = 0;i<primeros.size();i++) {

			p.setNombre(primeros.get(i).getNombre());		
			p=Carta.getPrimerPlato(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE id_producto="+ ingredientes.get(0).getId());
			}

		}

		for(int i = 0;i<segundos.size();i++) {

			p.setNombre(segundos.get(i).getNombre());		
			p=Carta.getSegundoPlato(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE id_producto="+ ingredientes.get(0).getId());
			}

		}

		for(int i = 0;i<postres.size();i++) {

			p.setNombre(postres.get(i).getNombre());	
			p=Carta.getPostre(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE id_producto="+ ingredientes.get(0).getId());
			}

		}

	}

	public static void reponerAlmacen() {
		Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=50 WHERE cantidad_disponible<10;");
	}

}
