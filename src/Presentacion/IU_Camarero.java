package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Camarero_Barra;
import Dominio.Camarero_Mesa;
import Dominio.Carta;
import Dominio.Gestor_Comandas;
import Dominio.Plato;

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
				System.out.println("Indique el número de la mesa que va a cambiar el estado");
				int num=seleccionarMesa();
				Gestor_Comandas.camarero_secuenciarEstado(num);
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
		Camarero_Mesa camarero= new Camarero_Mesa();
		boolean finComanda=false;
		int opcion;
		ArrayList<Plato>entrantes = new ArrayList<Plato>();
		ArrayList<Plato>primeros=new ArrayList<Plato>();
		ArrayList<Plato>segundos=new ArrayList<Plato>();
		ArrayList<Plato>postres=new ArrayList<Plato>();
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
		Gestor_Comandas.camarero_anotarComanda(camarero, entrantes, primeros, segundos, postres, bebidas);
	}

	public int seleccionarMesa() {
		int num_mesa=0;
		do {
			 num_mesa=scanner.nextInt();
				if(num_mesa<=0 || num_mesa>8) {
					System.out.println("Mesa no valida");
				}	
		} while(num_mesa<=0 || num_mesa>8);
		return num_mesa;
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
	
	private void seleccionarEntrantes(ArrayList<Plato>entrantes) {
		int opcion;
		Plato p;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Jamon\n2-Queso\n3-Tostas\n4-Calamares");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				p= new Plato("Jamon");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 2:
				p= new Plato("Queso");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 3:
				p= new Plato("Tostas");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			case 4:
				p= new Plato("Calamares");
				Carta.getEntrantes(p);
				entrantes.add(p);
				break;
			
			case 5:
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}
	
	private void seleccionarPrimeros(ArrayList<Plato> primeros) {
		int opcion;
		Plato p;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Cocido\n2-Ensalada\n3-Crema de Verduras\n4-Esparragos");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				p= new Plato("Cocido");
				Carta.getEntrantes(p);
				primeros.add(p);
				break;
			case 2:
				p= new Plato("Ensalada");
				Carta.getEntrantes(p);
				primeros.add(p);
				break;
			case 3:
				p= new Plato("Crema de Verduras");
				Carta.getEntrantes(p);
				primeros.add(p);
				break;
			case 4:
				p= new Plato("Esparragos");
				Carta.getEntrantes(p);
				primeros.add(p);
				break;
			
			case 5:
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}
	
	private void seleccionarSegundos(ArrayList<Plato> segundos) {
		int opcion;
		Plato p;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Lubina\n2-Solomillo\n3-Macarrones\n4-Hamburguesa");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				p= new Plato("Lubina");
				Carta.getEntrantes(p);
				segundos.add(p);
				break;
			case 2:
				p= new Plato("Solomillo");
				Carta.getEntrantes(p);
				segundos.add(p);
				break;
			case 3:
				p= new Plato("Macarrones");
				Carta.getEntrantes(p);
				segundos.add(p);
				break;
			case 4:
				p= new Plato("Hamburguesa");
				Carta.getEntrantes(p);
				segundos.add(p);
				break;
			
			case 5:
				
				fin_entrante=true;
				break;
			}
		}while(fin_entrante==false);
		
	}
	
	private void seleccionarPostres(ArrayList<Plato> postres) {
		int opcion;
		Plato p;
		boolean fin_entrante=false;
		do {
			System.out.println("\n1-Tarta\n2-Helado\n3-Chocolate\n4-Bizcocho");
			opcion=controlarNumero("Seleccione un entrante: ");
			switch(opcion) {
			case 1:
				p= new Plato("Tarta");
				Carta.getEntrantes(p);
				postres.add(p);
				break;
			case 2:
				p= new Plato("Helado");
				Carta.getEntrantes(p);
				postres.add(p);
				break;
			case 3:
				p= new Plato("Chocolate");
				Carta.getEntrantes(p);
				postres.add(p);
				break;
			case 4:
				p= new Plato("Bizcocho");
				Carta.getEntrantes(p);
				postres.add(p);
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
			System.out.println("\n1-Soda\n2-CocaCola\n3-Vino\n4-Cerveza");
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
	
	private void seleccionarEstado() {
		
		String estado=null;
		System.out.print("Selecciona la mesa");
		int mesa_id=scanner.nextInt(); //buscar mesa en la base de datos
		System.out.print("Seleccione el estado de la mesa");
		int opcion= scanner.nextInt();
		
		switch(opcion) {
		case 1:
			estado="Libre";
			break;
		case 2:
			estado="Ocupado";
			break;
		case 3:
			estado="Pidiendo";
			break;
		case 4:
			estado="En espera";
			break;
		case 5:
			estado="Servidos";
			break;
		case 6:
			estado="Esperando";
			break;
		case 7:
			estado="Pagando";
			break;
		case 8:
			estado="En preparación";
			break;
		
		}
		
		Gestor_Comandas.camarero_secuenciarEstado(mesa_id, estado);
		
		
	}

}