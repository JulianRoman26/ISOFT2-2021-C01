package Presentacion;

import java.util.*;



public class IU_Jefe_Mesa {
	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
		// TODO Auto-generated method stub

	}

	private static void menu() {

		int opcion = 0;
		do {
			System.out.println("Elija la funcion que desea realizar");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				asignarMesa();
				break;
			case 2:
				asignarCamarero();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				System.out.println("Se va a apagar el programa");
				break;

			default:
				System.out.println("Valor no aceptado, elija otra opción");

			}

		} while (opcion != 6);

		// TODO Auto-generated method stub

	}

	private static void asignarCamarero() {
		
		// TODO Auto-generated method stub
		
	}

	private static void asignarMesa() {
		// TODO Auto-generated method stub
		
	}

}
