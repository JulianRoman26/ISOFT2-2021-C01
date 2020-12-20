package Dominio;

import java.util.ArrayList;

import Presentacion.*;

//SERGIO: AVISARCOCINA, REPONERALMACEN
//ALEX: MANDARCOMIDA, MANDARBEBIDA
//RAFA: ANOTARCOMANDA, PREPARARBEBIDA
//AARON: SELECCIONARNUMERO
//JORGE: SECUENCIARESTADOS, COCINARPLATOS
//JULIAN: VALIDARCOMANDA, REPONERBEBIDAS
public class Gestor_Comandas {

	private Camarero[] Camareros;
	private Cocinero[] Cocineros;

	/**
	 * 
	 * @param numeroMesa
	 */
	public static int camarero_secuenciarEstado(int numeroMesa) { // Terminado
		Camarero_Mesa.secuenciarEstado_Mesa(numeroMesa);
		// TODO - implement Gestor_Comandas.camarero_secuenciarEstado
		throw new UnsupportedOperationException();
	}

	public static void camarero_anotarComanda(Camarero_Mesa cam, Comanda comanda) { // Terminado
		if (camarero_validarComanda(comanda) == true) {
			cam.anotarComanda(comanda); // Anadir la comanda en la base de datos
			camarero_mandarComida(comanda);
			camarero_mandarBebida(comanda);
		} else {
			camarero_AvisarCocina_FaltaIngredientes();
		}
	}

	/**
	 * 
	 * @param comandaAnotada
	 */
	public static boolean camarero_validarComanda(Comanda comandaAnotada) { // Terminado
		return Camarero_Mesa.validarComanda(comandaAnotada);
	}
	/**
	 * 
	 * @param ingredientes
	 * @param cantidad_ingredientes
	 */
	public static void camarero_AvisarCocina_FaltaIngredientes() {
		String notificacion = "NOS HEMOS QUEDADO SIN INGREDIENTES. DEBES REPONER EL ALMACEN";
		IU_Cocina.getNotificaciones().add(notificacion);
	}

	/**
	 * 
	 * @param comanda
	 */
	public static void camarero_mandarComida(Comanda comanda) {
		
		ArrayList<Plato> comida = comanda.getEntrantes();
		
		String notificacion = "Preparar la comida de la mesa: " + comanda.getMesa_asociada() + "\n";
		notificacion = notificacion + "ENTRANTES\n";
		while (!comida.isEmpty()) {
			notificacion = notificacion + comida.remove(0) + "\n";
		}
		comida = comanda.getPrimer_plato();
		notificacion = notificacion + "PRIMEROS\n";
		while (!comida.isEmpty()) {
			notificacion = notificacion + comida.remove(0) + "\n";
		}
		comida = comanda.getSegundo_plato();
		notificacion = notificacion + "SEGUNDOS\n";
		while (!comida.isEmpty()) {
			notificacion = notificacion + comida.remove(0) + "\n";
		}
		comida = comanda.getPostre();
		notificacion = notificacion + "POSTRES\n";
		while (!comida.isEmpty()) {
			notificacion = notificacion + comida.remove(0) + "\n";
		}
		IU_Cocina.getNotificaciones().add(notificacion);
	}

	/**
	 * 
	 * @param comanda
	 */
	public static void camarero_mandarBebida(Comanda comanda) { 
		ArrayList<Bebida> bebida = comanda.getBebidas();
		String notificacion = "Preparar las bebidas de la mesa: " + comanda.getMesa_asociada() + "\n";
		while (!bebida.isEmpty()) {
			notificacion = notificacion + bebida.remove(0) + "\n";
		}
		IU_Cocina.getNotificaciones().add(notificacion);
	}

	/**
	 * 
	 * @param comanda
	 */
	public void cocina_cocinarPlatos(Comanda comanda) {
		Cocinero.cocinarPlatos(comanda);
		cocina_avisarComidaLista(comanda);
	}

	/**
	 * 
	 * @param ingredientes
	 */
	public void cocina_reponerAlmacen(String[] ingredientes) {
		Cocinero.reponerAlmacen();
	}

	public void cocina_avisarComidaLista(Comanda comanda) {
		String notificacion = "COMANDA LISTA de la mesa: " + comanda.getMesa_asociada() + "\n";
		Cocinero.mandarNotificacion(notificacion, comanda);
	}
	
	/**
	 * 
	 * @param comanda
	 */
	public void camareroBarra_prepararBebida(Comanda comanda) {
		Camarero_Barra.prepararBebidas(comanda);
		camareroBarra_avisarBebidaLista(comanda);
	}

	public static void camareroBarra_reponerBebidas() {
		Camarero_Barra.reponerBebidas();
	}

	public void camareroBarra_avisarBebidaLista(Comanda comanda) {
		String notificacion = "BEBIDAS LISTA de la mesa: " + comanda.getMesa_asociada() + "\n";
		Camarero_Barra cam = new Camarero_Barra();
		cam.mandarNotificacion(comanda, notificacion);
	}

	public static int contarNotificaciones(int identificador_usuario) {
		Camarero_Mesa cam =new Camarero_Mesa("",identificador_usuario);
		int num=cam.obtenerNotificaciones(identificador_usuario);
		return num;
	}

	public static ArrayList<ArrayList<String>> mostrarNotificaciones(int identificador_usuario) {
		Camarero_Mesa cam =new Camarero_Mesa("",identificador_usuario);
		ArrayList<ArrayList<String>> notificaciones=cam.mostrarNotificaciones(identificador_usuario);
		return notificaciones;

	}

	public static void eliminarNotificacion(String identificador) {
		Camarero_Barra.eliminarNotificacion(identificador);
		// TODO Auto-generated method stub
		
	}

}
