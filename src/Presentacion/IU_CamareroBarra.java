package Presentacion;

import java.util.ArrayList;
import java.util.Scanner;

//NO POR EL MOMENTO
public class IU_CamareroBarra {
	static Scanner scanner = new Scanner(System.in);
	ArrayList<String> notificaciones=new ArrayList<String>();
	public ArrayList<String> getNotificaciones() {
		return notificaciones;
	}


	
	public void mostrarMenu_barra() {
		// TODO - implement IU_CamareroBarra.mostrarMenu_barra
		throw new UnsupportedOperationException();
	}

	public void reponerBebidas() {
		// TODO - implement IU_CamareroBarra.reponerBebidas
		throw new UnsupportedOperationException();
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

}