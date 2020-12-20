package Dominio;

import java.util.ArrayList;
import java.util.Iterator;

import Persistencia.Agente;

// JULIAN
public class Cocinero extends Empleado implements Carta {

	
	public Cocinero(int i,String n,String t) {
		super(i,n,t);
		// TODO Auto-generated constructor stub
	}
	
	public Cocinero(int id) {
		super(id);
	}

	/**
	 * 
	 * @param comanda
	 */
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
						") WHERE id_producto="+ ingredientes.get(0).getNombre());
			}

		}

		for(int i = 0;i<primeros.size();i++) {

			p.setNombre(primeros.get(i).getNombre());		
			p=Carta.getPrimerPlato(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE id_producto="+ ingredientes.get(0).getNombre());
			}

		}

		for(int i = 0;i<segundos.size();i++) {

			p.setNombre(segundos.get(i).getNombre());		
			p=Carta.getSegundoPlato(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE id_producto="+ ingredientes.get(0).getNombre());
			}

		}

		for(int i = 0;i<postres.size();i++) {

			p.setNombre(postres.get(i).getNombre());	
			p=Carta.getPostre(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE id_producto="+ ingredientes.get(0).getNombre());
			}

		}

	}

	public static void reponerAlmacen() {
		Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=50 WHERE cantidad_disponible<10;");
	}

	public void mandarNotificacion(String notificacion,Comanda comanda) {
		Agente.insertar("INSERT INTO notificaciones VALUES (origen, destino, mensaje) VALUES ("+ id_empleado +","+comanda.getId_camarero()+","+notificacion +")");
		// TODO Auto-generated method stub
		
	}

	public boolean Autenticar() {
		boolean correcto=true;
        int resultado=Integer.parseInt(Agente.get("SELECT id_empleado FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Cocinero')"));
        if(resultado==0) {
        	correcto=false;
        }
        else {
        	correcto= true;
        	setId_empleado(resultado);
        	setNombre(Agente.get("SELECT nombre FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Cocinero')"));
        	setTelefono(Agente.get("SELECT telefono FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Cocinero')"));
        }
		return correcto;
	}
}

