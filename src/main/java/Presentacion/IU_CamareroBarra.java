package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Gestor_Comandas;

//NO POR EL MOMENTO
public class IU_CamareroBarra {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Gestor_Comandas gestor =new Gestor_Comandas();
		if(identificarse(gestor)==true) {
			mostrarMenu_barra(gestor);
		}
	}
	
	public static boolean identificarse(Gestor_Comandas gestor) {
		boolean valido;
		int id=controlarNumero("Introduzca su identicador:");
		if(gestor.identificarse("Camarero_Barra",id)==true){
			System.out.println("Inicio de sesion correcto");
			System.out.println(gestor.getBarra().toString());
			valido=true;
		}
		else {
			System.out.println("Inicio de sesion incorrecto");
			valido=false;
		}
		return valido;
	}
	
	public static void mostrarMenu_barra(Gestor_Comandas gestor) {
		int opcion;
		boolean fin = false;
		do {
			do {
				System.out.println("\n           ****   MENU   ****\n");
				System.out.println("  1.-Reponer Bebidas");
				System.out.println("  2.-Preparar Bebidas ");
				System.out.println("  3.- ");
				System.out.println("  4.- ");

				opcion = controlarNumero("\nSeleccione entre 1-2:");
			} while (opcion < 1 && opcion > 5);
			System.out.println("");
			
			switch(opcion) {
			case 1:
				reponerBebidas(gestor);
				break;
			case 2:
				prepararBebidas(gestor);
				break;
			case 3:
				
				break;
			case 4:
				mostrarNotificacion(gestor);
				break;
			case 5:
				fin=true;
				break;
			}
			leerNotificaciones(gestor);
		}while(fin==false);
		
	}
	
	private static void prepararBebidas(Gestor_Comandas gestor) {
		int num=controlarNumero("introduce el numero de mesa de la que quieres ver la comanda:");
		gestor.camareroBarra_prepararBebida(num);
	}

	public static void reponerBebidas(Gestor_Comandas gestor) {
		gestor.camareroBarra_reponerBebidas();
	}
	public static void leerNotificaciones(Gestor_Comandas gestor) {
		System.out.println("Tiene usted: " + gestor.contarNotificaciones() + " notificaciones.");
	}

	public static  void mostrarNotificacion(Gestor_Comandas gestor) {
		boolean salir = false;
		int elemento=0;
		ArrayList<ArrayList<String>> notificaciones = gestor.mostrarNotificaciones();
		while (!notificaciones.isEmpty() && salir == false) {
			ArrayList<String> notificacion = notificaciones.get(elemento);
			System.out.println("Mensaje:");
			System.out.println(" Id :"+ notificacion.get(0)+"\n Origen: "+notificacion.get(1) +"\n Mensaje: "+ notificacion.get(3)+"");
			System.out.println("1-Leer siguiente\n2-Borrar\n3-Salir");
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				elemento++;
				break;
			case 2:
				notificaciones.remove(elemento);
				eliminarNotificacion(notificacion.get(0));
				break;
			case 3:
				salir = true;
				break;
			}
		}
	}
	
private static void eliminarNotificacion(String identificador) {
Gestor_Comandas.eliminarNotificacion(identificador);
		// TODO Auto-generated method stub
		
	}

	public static int controlarNumero(String texto) {

		int num = 0;
		boolean control = true;

		do { // Bucle para controlar que se introducen numeros
			try {
				System.out.println(texto);
				num = scanner.nextInt();
				control = false;
			} catch (Exception e) {
				System.err.println("\nSolo se permiten números");
				scanner.next();
			}
		} while (control);

		return num;
	}
}