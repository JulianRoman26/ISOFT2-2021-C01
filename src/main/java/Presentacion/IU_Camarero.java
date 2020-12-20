package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Bebida;
import Dominio.Camarero_Mesa;
import Dominio.Carta;
import Dominio.Comanda;
import Dominio.Gestor_Comandas;
import Dominio.Plato;

//NO POR EL MOMENTO
public class IU_Camarero {
	static int identificador_usuario = 0;
	static int mesa_actual = 0;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		identificarse();
		mostrarMenu();
		// TODO Auto-generated method stub

	}
	public static void mostrarMenu() {
		int opcion;
		boolean fin = false;
		do {
			do {
				
				System.out.println("\n           ****   MENU   ****\n");
				System.out.println("  1.- Seleccionar Numero de mesa");
				System.out.println("  2.- Secuenciar Estado de una Mesa");
				System.out.println("  3.- Anotar Comanda");
				System.out.println("  4.- Mostrar Notificaciones");

				opcion = scanner.nextInt();

				switch (opcion) {
				case 1:
					seleccionarMesa();
					break;
				case 2:
					Gestor_Comandas.camarero_secuenciarEstado(mesa_actual);
					break;
				case 3:
					seleccionarPlatos();
					break;
				case 4:
					mostrarNotificacion();
					break;
				case 5:
					fin = true;
					break;
				default:
					System.out.println("Valor no valido ");
					break;
				}
			} while (opcion < 1 && opcion > 5);
			leerNotificaciones();
		} while (fin == false);

	}
	// Seccion de mesa------------------------------------------------------------------------------------------------------
	public static void seleccionarMesa() {
		int num_mesa = 0;
		do {
			num_mesa = scanner.nextInt();
			if (num_mesa <= 0 || num_mesa > 8) { // hemos suspuesto que tenemos 8 mesas en el restaurante
				System.out.println("Mesa no valida");
			}
		} while (num_mesa <= 0 || num_mesa > 8);
		mesa_actual= num_mesa;
	}


// Seccion de platos y comandas----------------------------------------------------------------------------------------------------
	
	public static void seleccionarPlatos() {
		Camarero_Mesa camarero = new Camarero_Mesa("",identificador_usuario);
		boolean finComanda = false;
		int opcion;
		Comanda comanda= new Comanda(identificador_usuario,mesa_actual);
		ArrayList<Plato> entrantes = new ArrayList<Plato>();
		ArrayList<Plato> primeros = new ArrayList<Plato>();
		ArrayList<Plato> segundos = new ArrayList<Plato>();
		ArrayList<Plato> postres = new ArrayList<Plato>();
		ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
		do {
			System.out.println("\n           ****   MENU   ****\n");
			// while seleccion no terminado

			opcion = controlarNumero("¿Qué desea pedir ahora?\n 1-Entrantes\n 2-Primeros\n 3-Segundos\n 4-Postres\n 5-Bebidas\n 6-Terminar");
			switch (opcion) {
			case 1:
				seleccionarEntrantes(entrantes); // Va introduciendo los platos que le van indicando al camarero
				comanda.setEntrantes(entrantes);
				
				break;
			case 2:
				seleccionarPrimeros(primeros);
				comanda.setPrimer_plato(primeros);
				break;
			case 3:
				seleccionarSegundos(segundos);
				comanda.setSegundo_plato(segundos);
				break;
			case 4:
				seleccionarPostres(postres);
				comanda.setPostre(postres);
				break;
			case 5:
				seleccionarBebidas(comanda);
				comanda.setBebidas(bebidas);
				break;
			case 6:
				finComanda = true;
				break;
			default:
				System.out.println("Opción no válido");
				break;
			}

		} while (finComanda);
		
		Gestor_Comandas.camarero_anotarComanda(camarero, comanda);
	}
	private static void seleccionarEntrantes(ArrayList<Plato> entrantes) {
		int opcion;
		Plato p;
		boolean fin_entrante = false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3-Tostas\n4-Calamares\n 5-Salir");
			opcion = controlarNumero("Seleccione un entrante: ");
			switch (opcion) {
			case 1:
				p = new Plato("Jamon");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 2:
				p = new Plato("Queso");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 3:
				p = new Plato("Tostas");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 4:
				p = new Plato("Calamares");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;

			case 5:
				fin_entrante = true;
				break;
			default:
				System.out.println("Opción no válido");
				break;
			}
		} while (fin_entrante == false);

	}

	private static void seleccionarPrimeros(ArrayList<Plato> primeros) {
		int opcion;
		Plato p;
		boolean fin_primero = false;
		do {
			System.out.println("\n1-Cocido\n2-Ensalada\n3-Crema de Verduras\n4-Esparragos\n 5-Salir");
			opcion = controlarNumero("Seleccione un primer plato: ");
			switch (opcion) {
			case 1:
				p = new Plato("Cocido");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;
			case 2:
				p = new Plato("Ensalada");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;
			case 3:
				p = new Plato("Crema de Verduras");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;
			case 4:
				p = new Plato("Esparragos");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;

			case 5:
				fin_primero = true;
				break;
			default:
				System.out.println("Opción no válido");
				break;
			}
		} while (fin_primero == false);

	}

	private static void seleccionarSegundos(ArrayList<Plato> segundos) {
		int opcion;
		Plato p;
		boolean fin_segundo = false;
		do {
			System.out.println("\n1-Lubina\n2-Solomillo\n3-Macarrones\n4-Hamburguesa\n 5-Salir");
			opcion = controlarNumero("Seleccione un segundo plato: ");
			switch (opcion) {
			case 1:
				p = new Plato("Lubina");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;
			case 2:
				p = new Plato("Solomillo");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;
			case 3:
				p = new Plato("Macarrones");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;
			case 4:
				p = new Plato("Hamburguesa");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;

			case 5:

				fin_segundo = true;
				break;
			default:
				System.out.println("Opción no válido");
				break;
			}
		} while (fin_segundo == false);

	}

	private static void seleccionarPostres(ArrayList<Plato> postres) {
		int opcion;
		Plato p;
		boolean fin_postre = false;
		do {
			System.out.println("\n1-Tarta\n2-Helado\n3-Chocolate\n4-Bizcocho\n 5-Salir");
			opcion = controlarNumero("Seleccione un postre: ");
			switch (opcion) {
			case 1:
				p = new Plato("Tarta");
				Carta.getPostre(p);
				postres.add(p);
				break;
			case 2:
				p = new Plato("Helado");
				Carta.getPostre(p);
				postres.add(p);
				break;
			case 3:
				p = new Plato("Chocolate");
				Carta.getPostre(p);
				postres.add(p);
				break;
			case 4:
				p = new Plato("Bizcocho");
				Carta.getPostre(p);
				postres.add(p);
				break;

			case 5:
				fin_postre = true;
				break;
			default:
				System.out.println("Opción no válido");
				break;
			}
		} while (fin_postre == false);

	}

	private static void seleccionarBebidas(Comanda comanda) {
		int opcion;
		boolean fin_bebida = false;
		do {
			System.out.println("\n1-Soda\n2-CocaCola\n3-Vino\n4-Cerveza\n 5-Salir");
			opcion = controlarNumero("Seleccione una bebida: ");
			switch (opcion) {
			case 1:
				comanda.AñadirBebidas(new Bebida("Soda",1));
				break;
			case 2:
				comanda.AñadirBebidas(new Bebida("CocaCola",1));
				break;
			case 3:
				comanda.AñadirBebidas(new Bebida("Vino",1));
				break;
			case 4:
				comanda.AñadirBebidas(new Bebida("Cerveza",1));
				break;

			case 5:
				fin_bebida = true;
				break;
			default:
				System.out.println("Opción no válido");
				break;
			}
		} while (fin_bebida == false);

	}
	// Seccion de notificaciones----------------------------------------------------------------------------------------------------
		public static void leerNotificaciones() {
			System.out.println("Tiene usted: " + Gestor_Comandas.contarNotificaciones(identificador_usuario) + " notificaciones.");
		}

		public static void mostrarNotificacion() {
			boolean salir = false;
			int elemento=0;
			ArrayList<ArrayList<String>> notificaciones = Gestor_Comandas.mostrarNotificaciones(identificador_usuario);
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
// Metodos de apoyo---------------------------------------------------------------------------------------------------------
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