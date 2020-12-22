package Dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import Persistencia.Agente;


// JULIAN
public class Cocinero extends Empleado implements Carta {

	public static Scanner scanner=new Scanner(System.in);
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
						") WHERE nombre='"+ ingredientes.get(j).getNombre()+"'");
			}

		}

		for(int i = 0;i<primeros.size();i++) {

			p.setNombre(primeros.get(i).getNombre());		
			p=Carta.getPrimerPlato(p);
			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE nombre='"+ ingredientes.get(j).getNombre()+"'");
			}

		}

		for(int i = 0;i<segundos.size();i++) {

			p.setNombre(segundos.get(i).getNombre());		
			p=Carta.getSegundoPlato(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE nombre='"+ ingredientes.get(j).getNombre()+"'");
			}

		}

		for(int i = 0;i<postres.size();i++) {

			p.setNombre(postres.get(i).getNombre());	
			p=Carta.getPostre(p);

			ingredientes=p.getIngredientes();
			for(int j = 0;j<ingredientes.size();j++) {
				Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=(cantidad_disponible-"+ingredientes.get(j).getCantidad()+
						") WHERE nombre='"+ ingredientes.get(j).getNombre()+"'");
			}

		}

	}

	public static void reponerAlmacen() {
		Agente.modificar("UPDATE Ingredientes SET cantidad_disponible=50 WHERE cantidad_disponible<10;");
	}

	public void avisar_Comida_Lista(String notificacion,Comanda comanda) {
		Agente.insertar("INSERT INTO Notificaciones (origen, destino, mensaje) VALUES ("+ id_empleado +","+comanda.getId_camarero()+",'"+notificacion +"')");
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

	public static Comanda leerComanda(int id_mesa) {
		ArrayList<ArrayList<String>>total=new ArrayList();
		Comanda comanda = new Comanda(id_mesa);		
		total=Agente.getMany("SELECT * FROM Comandas WHERE id_mesa = "+id_mesa+"");

		comanda.setEntrantes(obtenerEntrantes(total.get(0).get(1)));
		comanda.setPrimer_plato(obtenerPrimeros(total.get(0).get(2)));
		comanda.setSegundo_plato(obtenerSegundos(total.get(0).get(3)));
		comanda.setPostre(obtenerPostres(total.get(0).get(4)));
		
		/*for(int i=0;i<comanda.getPrimer_plato().size();i++) {
			System.out.println("Primero: "+comanda.getPrimer_plato().get(i).getNombre());
		}*/
		return comanda;
	}
	private static ArrayList<Bebida> obtenerBebidas(String bebidas){
		ArrayList<Bebida> lista_bebidas = new ArrayList<Bebida>();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(bebidas,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Bebida bebida=new Bebida(nombre);
			lista_bebidas.add(bebida);
	        }
		return lista_bebidas;
	}
	private static ArrayList<Plato> obtenerEntrantes(String entrantes){
		ArrayList<Plato> lista_entrantes = new ArrayList<Plato>();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(entrantes,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Plato entrante=new Plato(nombre);
			lista_entrantes.add(entrante);
	        }
		return lista_entrantes;
	}
	private static ArrayList<Plato> obtenerPrimeros(String primeros){
		ArrayList<Plato> lista_primeros = new ArrayList<Plato>();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(primeros,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Plato primero=new Plato(nombre);
			lista_primeros.add(primero);
	        }
		return lista_primeros;
	}
	private static ArrayList<Plato> obtenerSegundos(String segundos){
		ArrayList<Plato> lista_segundos = new ArrayList<Plato>();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(segundos,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Plato segundo=new Plato(nombre);
			lista_segundos.add(segundo);
	        }
		return lista_segundos;
	}
	private static ArrayList<Plato> obtenerPostres(String postres){
		ArrayList<Plato> lista_postres = new ArrayList<Plato>();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(postres,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Plato segundo=new Plato(nombre);
			lista_postres.add(segundo);
	        }
		return lista_postres;
	}
	
	
	
}

