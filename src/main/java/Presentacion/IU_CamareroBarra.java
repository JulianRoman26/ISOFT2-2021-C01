package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Gestor_Comandas;

//NO POR EL MOMENTO
public class IU_CamareroBarra {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> notificaciones=new ArrayList<String>();
	
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
	public ArrayList<String> getNotificaciones() {
		return notificaciones;
	}
	
	public static void mostrarMenu_barra(Gestor_Comandas gestor) {
		int opcion;
		boolean fin = false;
		do {
			do {
				System.out.println("\n           ****   MENU   ****\n");
				System.out.println("  1.- Reponer Bebidas");
				System.out.println("  2.-");
				System.out.println("  3.-");
				System.out.println("  4.-");

				opcion = controlarNumero("\nSeleccione entre 1-5:");
			} while (opcion < 1 && opcion > 5);
			System.out.println("");
			
			switch(opcion) {
			case 1:
				reponerBebidas(gestor);
				break;
			case 2:
				break;
			case 3:
				
				break;
			case 4:
				mostrarNotificacion();
				break;
			case 5:
				fin=true;
				break;
			}
			leerNotificaciones();
		}while(fin==false);
		
	}
	
	public static void reponerBebidas(Gestor_Comandas gestor) {
		gestor.camareroBarra_reponerBebidas();
	}
	public static void leerNotificaciones() {
		System.out.println("Tiene usted: "+notificaciones.size()+" notificaciones.");
	}
	public static void mostrarNotificacion() {
		boolean salir=false;
		while(!notificaciones.isEmpty()&& salir==false) {
			System.out.println(notificaciones.get(0));
			System.out.println("1-Leer\n2-Borrar\n3-Salir");
			int opcion=scanner.nextInt();
			switch(opcion) {
			case 1:
				break;
			case 2:
				notificaciones.remove(0);
				break;
			case 3:
					salir=true;
					break;
			}
		}
	}
	public static int controlarNumero(String texto) {

		int num = 0;
		boolean control = true;

		do { 		// Bucle que sirve para controlar si se introducen numeros
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