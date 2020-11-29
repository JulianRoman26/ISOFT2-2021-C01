package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Gestor_Comandas;

//NO POR EL MOMENTO
public class IU_Camarero {
	static Scanner scanner = new Scanner(System.in);
	ArrayList<String> notificaciones=new ArrayList<String>();
	
	public ArrayList<String> getNotificaciones() {
		return notificaciones;
	}

	public void mostrarMenu() {
		int opcion;
		boolean fin = false;
		do {
			do {
				System.out.println("\n           ****   MENU   ****\n");
				System.out.println("  1.- Anotar Comanda");
				System.out.println("  2.- Secuenciar Estado de una Mesa");
				System.out.println("  3.- ");

				opcion = controlarNumero("\nSeleccione entre 1-6:");
			} while (opcion < 1 && opcion > 6);	System.out.println("");
			
			switch(opcion) {
			case 1:
				seleccionarPlatos();
				break;
			}
			leerNotificaciones();
		}while(fin);
			
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



	public void seleccionarPlatos() {
		boolean finComanda=false;
		int opcion;
		ArrayList<String>entrantes = new ArrayList<String>();
		ArrayList<String>primeros=new ArrayList<String>();
		ArrayList<String>segundos=new ArrayList<String>();
		ArrayList<String>postres=new ArrayList<String>();
		ArrayList<String>bebidas=new ArrayList<String>();
		do {
			System.out.println("\n           ****   MENU   ****\n");
			//while entrantes no acabados
			
			opcion=controlarNumero("Seleccione un plato");
			//while primeros no acabados
			switch(opcion) {
			case 1:
				seleccionarEntrantes(entrantes);
				break;
			case 2:
				seleccionarPrimeros(primeros);
				break;
			case 3:
		
				break;
			case 4:
				seleccionarSegundos(segundos);
				break;
			case 5:
				seleccionarPostres(postres);
				break;
			
			case 7:
				finComanda=true;
				break;
			}

		}while(finComanda);
		//Gestor_Comandas.camarero_anotarComanda(null, entrantes, primeros, segundos, postres, bebidas);
	}

	public void seleccionarMesa() {
		// TODO - implement IU_Camarero.seleccionarMesa
		throw new UnsupportedOperationException();
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
	
	private void seleccionarEntrantes(ArrayList<String>entrantes) {
		int opcion;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3Tostas\n4-Calamares");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				entrantes.add("Jamon");
				break;
			case 2:
				entrantes.add("Queso");
				break;
			case 3:
				entrantes.add("Tostas");
				break;
			case 4:
				entrantes.add("Calamares");
				break;
			
			case 5:
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}
	
	private void seleccionarPostres(ArrayList<String> postres) {
		// TODO Auto-generated method stub
		
	}

	private void seleccionarSegundos(ArrayList<String> segundos) {
		// TODO Auto-generated method stub
		
	}

	private void seleccionarPrimeros(ArrayList<String> primeros) {
		// TODO Auto-generated method stub
		
	}

}