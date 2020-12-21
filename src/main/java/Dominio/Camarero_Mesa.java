
package Dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Persistencia.Agente;

// SERGIO
public class Camarero_Mesa extends Empleado{
	private static Mesa[] mesas;
	private int id_mesa=0;
	
	public int getId_mesa() {
		return id_mesa;
	}

	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}

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
		
	}



	public static boolean validarComanda(Comanda comandaAnotada) {  // Terminado
		System.out.println(comandaAnotada.toString());
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
				int pos=comprobarIngrediente(ingredientes,i);
				if (pos==-1) {
					ingredientes.add(i);	
				}else {	
				
					ingredientes.get(pos).setCantidad(ingredientes.get(pos).getCantidad()+i.getCantidad());
				}
			}
		}
		Iterator<Ingrediente> iter_total = ingredientes.iterator();
		while (iter_total.hasNext()) {
			// quiza se pueda usar una coleccion para almacenar todo lo que reciba Collection coleccion;
			Ingrediente ing_actual= iter_total.next();
			int componente =Integer.parseInt(Agente.get("SELECT cantidad_disponible FROM Ingredientes WHERE nombre = '"+ ing_actual.getNombre() +"'"));
			
			if (ing_actual.getCantidad() > componente) return false;
			else {
				System.out.println("El ingrediente "+ing_actual.getNombre()+" Puede usarse "+ing_actual.getCantidad()+" Componente; "+componente);
			}
		}
		
		Iterator<Bebida> iter4 = comandaAnotada.getBebidas().iterator();
		while (iter4.hasNext()) {
			// quiza se pueda usar una coleccion para almacenar todo lo que reciba Collection coleccion;
			Bebida bebida_actual= iter4.next();
			int componente =Integer.parseInt(Agente.get("SELECT cantidad FROM Bebidas WHERE nombre = '"+ bebida_actual.getNombre() +"'"));
			
			if (bebida_actual.getCantidad() > componente) return false;
		}
		
		return true;
	}
	

	@Override
	public String toString() {
		return "Camarero_Mesa [id_mesa=" + id_mesa + ", nombre=" + nombre + ", id_empleado=" + id_empleado
				+ ", telefono=" + telefono + "]";
	}

	private static int  comprobarIngrediente(ArrayList<Ingrediente> ingredientes, Ingrediente i) { // Terminado
		int posicion =-1;
		Iterator<Ingrediente> iter= ingredientes.iterator();
		while (iter.hasNext()) {
			Ingrediente ing_actual=iter.next();
			if (ing_actual.getNombre()== i.getNombre())
				posicion=ingredientes.indexOf(ing_actual);
			
		}
		// TODO Auto-generated method stub
		return posicion;
	}

	public void anotarComanda(Comanda comanda) { // Terminado
		Agente.insertar("INSERT INTO Comandas (id_mesa, entrantes, primeros, segundos, postres, bebidas) VALUES ("+id_mesa+",'"+arrayListToString(comanda.getEntrantes())+"','"+arrayListToString(comanda.getPrimer_plato())+"','"+arrayListToString(comanda.getSegundo_plato())+"','"+arrayListToString(comanda.getPostre())+"','"+arrayListToString2(comanda.getBebidas())+"')");
		
	}
	public String arrayListToString(ArrayList<Plato> a) {
		String s="";
		if(!a.isEmpty()) {
			if(a.size()==1) {
				s=""+a.get(0).getNombre();
			}else {
				for(int i=0;i<a.size()-1;i++) {
					s=s+a.get(i).getNombre()+",";
					System.out.println(a.get(i).getNombre());
				}
				s=s+a.get(a.size()-1).getNombre();
			}
		}
	
		
		return s;
	}
	public String arrayListToString2(ArrayList<Bebida> a) {
		String s="";
		if(!a.isEmpty()) {
			if(a.size()==1) {
				s=""+a.get(0).getNombre();
			}else {
				for(int i=0;i<a.size()-1;i++) {
					s=s+a.get(i).getNombre()+",";
					System.out.println(a.get(i).getNombre());
				}
				s=s+a.get(a.size()-1).getNombre();
			}
		}
	
		
		return s;
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
        	correcto= true;
        	setId_empleado(resultado);
        	setNombre(Agente.get("SELECT nombre FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Mesa')"));
        	setTelefono(Agente.get("SELECT telefono FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Mesa')"));
        }
		return correcto;
	}
}