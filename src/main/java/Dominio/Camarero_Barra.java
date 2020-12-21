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

	public int avisarCamarero_Mesa_BebidasListas(Comanda comanda,String notificacion) {
		Agente.insertar("INSERT INTO notificaciones VALUES(origen, destino, mensaje) VALUES "+ id_empleado +", "+comanda.getId_camarero() +","+ notificacion+"");
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
		Agente.modificar("UPDATE Bebidas SET cantidad_disponible=(cantidad_disponible-"+bebidas.get(j).getCantidad()+
				") WHERE nombre="+ bebidas.get(j).getNombre());
		}
	}

	/**
	 * 
	 * @param bebidas
	 */
	public static void reponerBebidas() {
		Agente.modificar("UPDATE Bebidas SET cantidad_disponible=50 WHERE cantidad_disponible<10;\");"); //Insertar Bebidas
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

	public static Comanda leerComanda() {
		System.out.println("Introduzca la mesa de la que quiere obtener la comanda:");
		int id_mesa=scanner.nextInt();
		ArrayList<ArrayList<String>>total=new ArrayList();
		Comanda comanda = new Comanda(id_mesa);		
		total=Agente.getMany("SELECT * FROM Comandas WHERE id_mesa = "+id_mesa+"");
		
		comanda.setBebidas(obtenerBebidas(total.get(0).get(5)));	
		return comanda;
	}

	private static ArrayList<Bebida> obtenerBebidas(String bebidas) {
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

}