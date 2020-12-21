package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Gestor_Comandas;

//NO POR EL MOMENTO
public class IU_Cocina {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> notificaciones=new ArrayList<String>();
	public static void main(String[] args) {
		Gestor_Comandas gestor =new Gestor_Comandas();
		if(identificarse(gestor)==true) {
			mostrarMenu_cocina(gestor);
		}
	}
	
	public static boolean identificarse(Gestor_Comandas gestor) {
		boolean valido;
		int id=controlarNumero("Introduzca su identicador:");
		if(gestor.identificarse("Cocinero",id)==true){
			System.out.println("Inicio de sesion correcto");
			System.out.println(gestor.getCocinero().toString());
			valido=true;
		}
		else {
			System.out.println("Inicio de sesion incorrecto");
			valido=false;
		}
		return valido;
	}
	public static ArrayList<String> getNotificaciones() {
		return notificaciones;
	}
	public void leerNotificaciones() {
		System.out.println("Tiene usted: "+notificaciones.size()+" notificaciones.");
	}
	/**
	 * 
	 * @param 
	 */
	public void mostrarNotificacion() {
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

	public void reponerAlmacen() {
		
	}

	public static void mostrarMenu_cocina(Gestor_Comandas gestor) {
		int opcion;
		boolean fin = false;
		do {
			do {
				
				System.out.println("\n           ****   MENU   ****\n");
				System.out.println("  1.- Reponer Almacen");
				System.out.println("  2.- Cocinar Plato");
				System.out.println("  3.- Salir");

				opcion = controlarNumero("Elija una opcion");

				switch (opcion) {
				case 1:
					gestor.cocina_reponerAlmacen();
					break;
				case 2:
					int id_mesa=controlarNumero("Introduzca la mesa de la que quiere obtener la comanda:");
					gestor.cocina_cocinarPlatos(id_mesa);
					break;
				case 3:
					fin = true;
					break;
				default:
					System.out.println("Valor no valido ");
					break;
				}
			} while (opcion < 1 && opcion > 3);
			//leerNotificaciones(gestor);
		} while (fin == false);

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
				System.err.println("\nSolo se permiten numeros");
				scanner.next();
			}
		} while (control);

		return num;
	}

}