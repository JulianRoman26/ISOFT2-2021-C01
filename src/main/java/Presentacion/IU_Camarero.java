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
	/*static int identificador_usuario = 0;
	static int mesa_actual = 0;*/
	static Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) {
		Gestor_Comandas gestor =new Gestor_Comandas();
		if(identificarse(gestor)==true) {
			mostrarMenu(gestor);
		}
	}
	public static boolean identificarse(Gestor_Comandas gestor) {
		boolean valido;
		int id=controlarNumero("Introduzca su identicador:");
		if(gestor.identificarse("Camarero_Mesa",id)==true){
			System.out.println("Inicio de sesion correcto");
			System.out.println("BIENVENIDO "+gestor.getCamarero().toString());
			valido=true;
		}
		else {
			System.out.println("Inicio de sesion incorrecto");
			valido=false;
		}
		return valido;
	}
	
	public static void mostrarMenu(Gestor_Comandas gestor) {
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
					seleccionarMesa(gestor);
					break;
				case 2:
					if(gestor.getCamarero().getId_mesa()==0) {
						System.out.println("Error, no has escogido la mesa a la cual se va a atender, por favor seleccione el numero de mesa.");
					}else{
						gestor.camarero_secuenciarEstado(gestor.getCamarero().getId_mesa());
					}
					break;
				case 3:
					if(gestor.getCamarero().getId_mesa()==0) {
						System.out.println("Error, no has escogido la mesa a la cual se va a atender, por favor seleccione el numero de mesa.");
						}else{
							seleccionarPlatos(gestor);
						}
					break;
				case 4:
					mostrarNotificacion(gestor);
					break;
				case 5:
					fin = true;
					break;
				default:
					System.out.println("Valor no valido ");
					break;
				}
			} while (opcion < 1 && opcion > 5);
			//leerNotificaciones(gestor);
		} while (fin == false);

	}
	// Seleccion de mesa------------------------------------------------------------------------------------------------------
	public static void seleccionarMesa(Gestor_Comandas gestor) {
		int num_mesa = 0;
		do {
			num_mesa = controlarNumero("Por favor, seleccione el numero de mesa:");
			if (num_mesa <= 0 || num_mesa > 8) { // hemos supuesto que tenemos 8 mesas en el restaurante
				System.out.println("Mesa no valida");
			}
		} while (num_mesa <= 0 || num_mesa > 8);
		gestor.getCamarero().setId_mesa(num_mesa);
		System.out.println(gestor.getCamarero().toString());
		
	}


// Seccion de platos y comandas----------------------------------------------------------------------------------------------------
	
	public static  void seleccionarPlatos(Gestor_Comandas gestor) {
		boolean finComanda = false;
		int opcion;
	
		Comanda comanda= new Comanda(gestor.getCamarero().getId_empleado(),gestor.getCamarero().getId_mesa());
		ArrayList<Plato> entrantes = new ArrayList<Plato>();
		ArrayList<Plato> primeros = new ArrayList<Plato>();
		ArrayList<Plato> segundos = new ArrayList<Plato>();
		ArrayList<Plato> postres = new ArrayList<Plato>();
		ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
		do {
			System.out.println("\n           ****   MENU   ****\n");
			// while seleccion no terminado

			opcion = controlarNumero("¿Que desea pedir ahora?\n 1-Entrantes\n 2-Primeros\n 3-Segundos\n 4-Postres\n 5-Bebidas\n 6-Terminar");
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
				seleccionarBebidas(bebidas);
				comanda.setBebidas(bebidas);
				
				break;
			case 6:
				finComanda = true;
				break;
			default:
				System.out.println("Opcion no valido");
				break;
			}

		} while (finComanda==false);

		gestor.camarero_anotarComanda(comanda);
	}
	private static void seleccionarEntrantes(ArrayList<Plato> entrantes) {
		int opcion;
		Plato p;
		boolean fin_entrante = false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3-Patatas Bravas\n 4-Salir");
			opcion = controlarNumero("Seleccione un entrante: ");
			switch (opcion) {
			case 1:
				p = new Plato("jamon");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 2:
				p = new Plato("queso");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 3:
				p = new Plato("bravas");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
	
			case 4:
				fin_entrante = true;
				break;
			default:
				System.out.println("Opcion no valido");
				break;
			}
		} while (fin_entrante == false);
	
	}

	private static void seleccionarPrimeros(ArrayList<Plato> primeros) {
		int opcion;
		Plato p;
		boolean fin_primero = false;
		do {
			System.out.println("\n1-Sopa de Cocido\n2-Ensalada\n3-Crema de Calabaza\n4-Paella\n 5-Salir");
			opcion = controlarNumero("Seleccione un primer plato: ");
			switch (opcion) {
			case 1:
				p = new Plato("sopa_de_cocido");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;
			case 2:
				p = new Plato("ensalada");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;
			case 3:
				p = new Plato("crema_de_calabaza");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;
			case 4:
				p = new Plato("paella");
				Carta.getPrimerPlato(p);
				primeros.add(p);
				break;

			case 5:
				fin_primero = true;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (fin_primero == false);
		
	}

	private static void seleccionarSegundos(ArrayList<Plato> segundos) {
		int opcion;
		Plato p;
		boolean fin_segundo = false;
		do {
			System.out.println("\n1-Lubina\n2-Cordero\n3-Macarrones\n4-Hamburguesa\n 5-Salir");
			opcion = controlarNumero("Seleccione un segundo plato: ");
			switch (opcion) {
			case 1:
				p = new Plato("lubina");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;
			case 2:
				p = new Plato("cordero");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;
			case 3:
				p = new Plato("macarrones");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;
			case 4:
				p = new Plato("hamburguesa");
				Carta.getSegundoPlato(p);
				segundos.add(p);
				break;

			case 5:

				fin_segundo = true;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (fin_segundo == false);
	
	}

	private static void seleccionarPostres(ArrayList<Plato> postres) {
		int opcion;
		Plato p;
		boolean fin_postre = false;
		do {
			System.out.println("\n1-Tarta De Queso\n2-Flan\n3-Chocolate\n4-Bizcocho\n5-Salir");
			opcion = controlarNumero("Seleccione un postre: ");
			switch (opcion) {
			case 1:
				p = new Plato("tarta_de_queso");
				Carta.getPostre(p);
				postres.add(p);
				break;
			case 2:
				p = new Plato("flan");
				Carta.getPostre(p);
				postres.add(p);
				break;
			case 3:
				p = new Plato("chocolate");
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
				System.out.println("Opcion no valida");
				break;
			}
		} while (fin_postre == false);
	}

	/*private static void seleccionarBebidas(Comanda comanda) {
		int opcion;
		boolean fin_bebida = false;
		do {
			System.out.println("\n1-Agua\n2-Pepsi\n3-Vino\n4-Fanta\n 5-Salir");
			opcion = controlarNumero("Seleccione una bebida: ");
			switch (opcion) {
			case 1:
				comanda.AnadirBebidas(new Bebida("agua",1));
				break;
			case 2:
				comanda.AnadirBebidas(new Bebida("pepsi",1));
				break;
			case 3:
				comanda.AnadirBebidas(new Bebida("vino",1));
				break;
			case 4:
				comanda.AnadirBebidas(new Bebida("fanta",1));
				break;

			case 5:
				fin_bebida = true;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (fin_bebida == false);

	}*/
	private static void seleccionarBebidas(ArrayList<Bebida> bebidas) {
	
		int opcion;
		boolean fin_bebida = false;
		do {
			System.out.println("\n1-Agua\n2-Pepsi\n3-Vino\n4-Fanta\n 5-Salir");
			opcion = controlarNumero("Seleccione una bebida: ");
			switch (opcion) {
			case 1:
				bebidas.add(new Bebida("agua",1));
				
				break;
			case 2:
				bebidas.add(new Bebida("pepsi",1));
				break;
			case 3:
				bebidas.add(new Bebida("vino",1));
				break;
			case 4:
				bebidas.add(new Bebida("fanta",1));
				break;

			case 5:
				fin_bebida = true;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (fin_bebida == false);
		
	}
	// Seccion de notificaciones----------------------------------------------------------------------------------------------------
		public static void leerNotificaciones(Gestor_Comandas gestor) {
			System.out.println("Tiene usted: " + gestor.contarNotificaciones(gestor.getCamarero().getId_empleado()) + " notificaciones.");
		}

		public static  void mostrarNotificacion(Gestor_Comandas gestor) {
			boolean salir = false;
			int elemento=0;
			ArrayList<ArrayList<String>> notificaciones = gestor.mostrarNotificaciones(gestor.getBarra().getId_empleado());
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