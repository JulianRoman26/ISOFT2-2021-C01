package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Gestor_Comandas;

//NO POR EL MOMENTO
public class IU_CamareroBarra {
	static Scanner scanner = new Scanner(System.in);
	ArrayList<String> notificaciones=new ArrayList<String>();
	
	public ArrayList<String> getNotificaciones() {
		return notificaciones;
	}
	
	public void mostrarMenu_barra() {
		int opcion;
		boolean fin = false;
		do {
			do {
				System.out.println("\n           ****   MENU   ****\n");
				System.out.println("  1.-");
				System.out.println("  2.- ");
				System.out.println("  3.- ");
				System.out.println("  4.- ");

				opcion = controlarNumero("\nSeleccione entre 1-6:");
			} while (opcion < 1 && opcion > 5);
			System.out.println("");
			
			switch(opcion) {
			case 1:
				
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

	public void reponerBebidas() {
		Gestor_Comandas.camareroBarra_reponerBebidas();
	}
	public void leerNotificaciones() {
		System.out.println("Tiene usted: "+notificaciones.size()+" notificaciones.");
	}
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