package Dominio;

import java.util.ArrayList;

import Persistencia.Agente;

// JORGE
public class Camarero_Barra extends Camarero {
	private String barra;

	public Camarero_Barra(String experiencia_laboral) {
		super(experiencia_laboral);
		// TODO Auto-generated constructor stub
	}
	public Camarero_Barra() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int avisarCamarero_Mesa_BebidasListas() {
		String mensaje= "LAS BEBIDAS DE LA COMANDA X YA ESTAN LISTAS PARA SER SERVIDAS ";
		IU_Camarero.getNotificaciones().add(mensaje);
		// TODO - implement Camarero_Barra.avisarCamarero_Mesa_BebidasListas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param comanda
	 */
	public static void prepararBebidas(Comanda comanda) {
		ArrayList<String> bebidas= comanda.getBebidas();
		for(int j = 0;j<bebidas.size();j++) {
		Agente.modificar("UPDATE Bebidas SET cantidad_disponible=(cantidad_disponible-"+1+
				") WHERE nombre="+ bebidas.get(0));
		}
	}

	/**
	 * 
	 * @param bebidas
	 */
	public static void reponerBebidas() {
		Agente.modificar("UPDATE Bebidas SET cantidad_disponible=50 WHERE cantidad_disponible<10;\");"); //reponer bebidas
	}

}
