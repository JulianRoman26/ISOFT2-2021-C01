package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Gestor_Comandas;

//NO POR EL MOMENTO
public class IU_Camarero {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> notificaciones=new ArrayList<String>();
	
	public static ArrayList<String> getNotificaciones() {
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
				System.out.println("  3.- Seleccionar Numero de mesa");
				System.out.println("  4.- Mostrar Notificaciones");

				opcion = controlarNumero("\nSeleccione entre 1-6:");
			} while (opcion < 1 && opcion > 5);
			System.out.println("");
			
			switch(opcion) {
			case 1:
				seleccionarPlatos();
				break;
			case 2:
				break;
			case 3:
				seleccionarMesa();
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
			switch(opcion) {
			case 1:
				seleccionarEntrantes(entrantes);
				break;
			case 2:
				seleccionarPrimeros(primeros);
				break;
			case 3:
				seleccionarSegundos(segundos);
				break;
			case 4:
				seleccionarPostres(postres);
				break;
			case 5:
				seleccionarBebidas(bebidas);
				break;
			
			case 6:
				finComanda=true;
				break;
			}

		}while(finComanda);
		//Gestor_Comandas.camarero_anotarComanda(null, entrantes, primeros, segundos, postres, bebidas);
	}

	public void seleccionarMesa() {

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
		int opcion;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3Tostas\n4-Calamares");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				postres.add("Tarta");
				break;
			case 2:
				postres.add("Helado");
				break;
			case 3:
				postres.add("Chocolate");
				break;
			case 4:
				postres.add("Bizcocho");
				break;
			
			case 5:
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}

	private void seleccionarSegundos(ArrayList<String> segundos) {
		int opcion;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3Tostas\n4-Calamares");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				segundos.add("Lubina");
				break;
			case 2:
				segundos.add("Solomillo");
				break;
			case 3:
				segundos.add("Macarrones");
				break;
			case 4:
				segundos.add("Hamburguesa");
				break;
			
			case 5:
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}

	private void seleccionarPrimeros(ArrayList<String> primeros) {
		int opcion;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3Tostas\n4-Calamares");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				primeros.add("Cocido");
				break;
			case 2:
				primeros.add("Ensalada");
				break;
			case 3:
				primeros.add("Crema de Verduras");
				break;
			case 4:
				primeros.add("Esparragos");
				break;
			
			case 5:
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}
	
	private void seleccionarBebidas(ArrayList<String> bebidas) {
		int opcion;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3Tostas\n4-Calamares");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				bebidas.add("Soda");
				break;
			case 2:
				bebidas.add("CocaCola");
				break;
			case 3:
				bebidas.add("Vino");
				break;
			case 4:
				bebidas.add("Cerveza");
				break;
			
			case 5:
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}

}