package Dominio;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Persistencia.Agente;
import Presentacion.IU_Camarero;

// JORGE
	
public class Camarero_Barra extends Empleado {
	private String barra;
	static Scanner scanner =new Scanner (System.in);
	
	public Camarero_Barra(int i,String n,String t) {
		super(i,n,t);
		// TODO Auto-generated constructor stub
	}
	
	public Camarero_Barra(int id) {
		super(id);
	}

	public int avisarCamarero_Mesa_BebidasListas() {
		String mensaje= "LAS BEBIDAS DE LA COMANDA X YA ESTAN LISTAS PARA SER SERVIDAS ";
		
		// TODO - implement Camarero_Barra.avisarCamarero_Mesa_BebidasListas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param comanda
	 */
	public static void prepararBebidas(Comanda comanda) {
		ArrayList<Bebida> bebidas= comanda.getBebidas();
		for(int j = 0;j<bebidas.size();j++) {
			bebidas.get(j).setCantidad(1);
		Agente.modificar("UPDATE Bebidas SET cantidad=(cantidad-"+bebidas.get(j).getCantidad()+
				") WHERE nombre='"+ bebidas.get(j).getNombre()+"'");
		}
	}

	/**
	 * 
	 * @param bebidas
	 */
	public static void reponerBebidas() {
		Agente.modificar("UPDATE Bebidas SET cantidad=50 WHERE cantidad<10;\");"); //Insertar Bebidas
	}
	public void mandarNotificacion(Comanda comanda, String notificacion) {
		Agente.insertar("INSERT INTO notificaciones VALUES(origen, destino, mensaje) VALUES "+ id_empleado +", "+comanda.getId_camarero() +","+ notificacion+"");
		// TODO Auto-generated method stub
		
	}
	public static void eliminarNotificacion(String identificador) {
		Agente.eliminar("DELETE * FROM notificaciones WHERE id= " +identificador+ "");
		// TODO Auto-generated method stub
		
	}
	public boolean Autenticar() {
		boolean correcto=true;
        int resultado=Integer.parseInt(Agente.get("SELECT id_empleado FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Barra')"));
        if(resultado==0) {
        	correcto=false;
        }
        else {
        	correcto= true;
        	setId_empleado(resultado);
        	setNombre(Agente.get("SELECT nombre FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Barra')"));
        	setTelefono(Agente.get("SELECT telefono FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Barra')"));
        }
		return correcto;
	}

	public static Comanda leerComanda(int id_mesa) {
		
		ArrayList<ArrayList<String>>total=new ArrayList();
		Comanda comanda = new Comanda(id_mesa);		
		total=Agente.getMany("SELECT * FROM Comandas WHERE id_mesa = "+id_mesa+"");
		
		comanda.setBebidas(obtenerBebidas(total.get(0).get(5)));
		return comanda;
	}

	private static ArrayList<Plato> obtenerSegundos(String segundos) {
		ArrayList<Plato> lista_segundos = new ArrayList();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(segundos,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Plato segundo=new Plato(nombre);
			lista_segundos.add(segundo);
	        }
		return lista_segundos;
	}

	private static ArrayList<Plato> obtenerPrimeros(String primeros) {
		ArrayList<Plato> lista_primeros = new ArrayList();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(primeros,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Plato primero=new Plato(nombre);
			lista_primeros.add(primero);
	        }
		return lista_primeros;
	}

	private static ArrayList<Plato> obtenerEntrantes(String entrantes) {
		ArrayList<Plato> lista_entrantes = new ArrayList();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(entrantes,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Plato entrante=new Plato(nombre);
			lista_entrantes.add(entrante);
	        }
		return lista_entrantes;
	}

	private static ArrayList<Bebida> obtenerBebidas(String bebidas) {
		ArrayList<Bebida> lista_bebidas = new ArrayList();
		String nombre;
		StringTokenizer tokens=new StringTokenizer(bebidas,",");
		while(tokens.hasMoreTokens()){
			nombre=tokens.nextToken();
			Bebida bebida=new Bebida(nombre);
			lista_bebidas.add(bebida);
	        }
		return lista_bebidas;
	}

}