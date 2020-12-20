
package Dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Persistencia.Agente;

// SERGIO
public class Camarero_Mesa extends Empleado{
	private static Mesa[] mesas;
	
	
	public Camarero_Mesa(int i,String n,String t) {
		super(i,n,t);
		// TODO Auto-generated constructor stub
	}
	
	public Camarero_Mesa(int id) {
		super(id);
	}

	// la forma en la que organizaremos las mesas es con 
	public static void secuenciarEstado_Mesa(int num_mesa) {  // Terminado
		mesas[num_mesa].setEstado(Agente.get("GET estado FROM mesa WHERE num_mesa = "+ num_mesa+""));
		mesas[num_mesa].secuenciarEstado();
		Agente.modificar("UPDATE mesa SET estados=("+mesas[num_mesa].getEstado()+") WHERE num ="+ num_mesa);
		throw new UnsupportedOperationException();
	}



	public static boolean validarComanda(Comanda comandaAnotada) {  // Terminado
		ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
		ArrayList<Plato> platos = new ArrayList<Plato>();
		Plato p;
		
		platos.addAll(comandaAnotada.getEntrantes());
		platos.addAll(comandaAnotada.getPrimer_plato());
		platos.addAll(comandaAnotada.getSegundo_plato());
		platos.addAll(comandaAnotada.getPostre());
		Iterator<Plato> iter_platos = platos.iterator();
		
		while (iter_platos.hasNext()) {
			p= iter_platos.next();
			Iterator<Ingrediente> iter_ingredientes= p.getIngredientes().iterator();
			
			while (iter_ingredientes.hasNext()){
				Ingrediente i=iter_ingredientes.next();
				if (!comprobarIngrediente(ingredientes,i)) {
					ingredientes.add(i);	
				}else {
					int num=ingredientes.indexOf(i);
					ingredientes.get(num).setCantidad(ingredientes.get(num).getCantidad()+i.getCantidad());
				}
			}
		}
		Iterator<Ingrediente> iter_total = ingredientes.iterator();
		while (iter_total.hasNext()) {
			// quiza se pueda usar una coleccion para almacenar todo lo que reciba Collection coleccion;
			Ingrediente ing_actual= iter_total.next();
			int componente =Integer.parseInt(Agente.get("SELECT cantidad FROM Ingredientes WHERE nombre = "+ ing_actual.getNombre() +""));
			
			if (ing_actual.getCantidad() > componente) return false;
		}
		
		Iterator<Bebida> iter4 = comandaAnotada.getBebidas().iterator();
		while (iter4.hasNext()) {
			// quiza se pueda usar una coleccion para almacenar todo lo que reciba Collection coleccion;
			Bebida bebida_actual= iter4.next();
			int componente =Integer.parseInt(Agente.get("SELECT cantidad FROM Ingredientes WHERE nombre = "+ bebida_actual.getNombre() +""));
			
			if (bebida_actual.getCantidad() > componente) return false;
		}
		
		return true;
	}

	private static boolean comprobarIngrediente(ArrayList<Ingrediente> ingredientes, Ingrediente i) { // Terminado
		Iterator<Ingrediente> iter= ingredientes.iterator();
		while (iter.hasNext()) {
			Ingrediente ing_actual=iter.next();
			if (ing_actual.getNombre()== i.getNombre()) return true;
			
		}
		// TODO Auto-generated method stub
		return false;
	}

	public void anotarComanda(Comanda comanda) { // Terminado
		Agente.insertar("INSERT INTO comandas VALUES (id_mesa, entrantes, primeros, segundos, postres, bebidas) VALUES ("+comanda.getMesa_asociada()+","+comanda.getEntrantes()+","+comanda.getPrimer_plato()+""+comanda.getSegundo_plato()+","+comanda.getPostre()+","+comanda.getBebidas()+")");
		// TODO - implement Camarero_Mesa.anotarComanda
		throw new UnsupportedOperationException();
	}

	public int obtenerNotificaciones(int identificador_usuario) {
		int n_mensajes=0;
		n_mensajes=Integer.parseInt(Agente.get("COUNT * FROM Notificiones WHERE destino = "+ identificador_usuario +""));
		return n_mensajes;
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ArrayList<String>> mostrarNotificaciones(int identificador_usuario) {
		ArrayList<ArrayList<String>> notificaciones= Agente.getMany("SELECT * FROM Notificaciones WHERE destino = "+identificador_usuario +"");
		return notificaciones;
	}

	public boolean Autenticar() {
		boolean correcto=true;
        int resultado=Integer.parseInt(Agente.get("SELECT id_empleado FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Mesa')"));
        if(resultado==0) {
        	correcto=false;
        }
        else {
        	correcto=true;
        	
        }
		return correcto;
	}
}