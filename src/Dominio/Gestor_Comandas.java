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
	private Comanda[] Comandas;
	private Cocinero[] Cocineros;

	/**
	 * 
	 * @param numeroMesa
	 */
	public int camarero_secuenciarEstado(int numeroMesa) {
		// TODO - implement Gestor_Comandas.camarero_secuenciarEstado
		throw new UnsupportedOperationException();
	}

	public void camarero_anotarComanda(Camarero_Mesa cam,ArrayList<Plato> entrante,ArrayList<Plato> primer,ArrayList<Plato>segundo
									,ArrayList<Plato>postre, ArrayList<String>bebida) {

		Comanda comanda = new Comanda();
	
			comanda.setEntrantes(entrante);
			comanda.setPrimer_plato(primer);
			comanda.setSegundo_plato(segundo);
			comanda.setPostre(postre);
			comanda.setBebidas(bebida);
		if(camarero_validarComanda(comanda)==true) {
			cam.anotarComanda(); //Anadir la comanda en la base de datos
			camarero_mandarComida(comanda);
			camarero_mandarBebida(comanda);
			
		}else {
			camarero_AvisarCocina_FaltaIngredientes();
			
		}
	}

	/**
	 * 
	 * @param comandaAnotada
	 */
	public boolean camarero_validarComanda(Comanda comandaAnotada) {
		if(comandaAnotada!=null) {
			return true;
		}else {
			return false;
		}
		

	}

	public int camarero_seleccionarNumeroMesa() {
		// TODO - implement Gestor_Comandas.camarero_seleccionarNumeroMesa
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ingredientes
	 * @param cantidad_ingredientes
	 */
	public void camarero_AvisarCocina_FaltaIngredientes() {
		String notificacion="NOS HEMOS QUEDADO SIN INGREDIENTES. DEBES REPONER EL ALMACEN";
		IU_Cocina.getNotificaciones().add(notificacion);
	}

	/**
	 * 
	 * @param comanda
	 */
	public void camarero_mandarComida(Comanda comanda) {

		ArrayList<String>comida=comanda.getEntrantes();

		ArrayList<Plato>comida=comanda.getEntrantes();

		String notificacion="Preparar la comida de la mesa: " + comanda.getMesa_asociada().getNumero() +"\n";
		notificacion=notificacion+"ENTRANTES\n";
		while(!comida.isEmpty()) {
			notificacion= notificacion+ comida.remove(0) + "\n";
		}
		comida=comanda.getPrimer_plato();
		notificacion=notificacion+"PRIMEROS\n";
		while(!comida.isEmpty()) {
			notificacion= notificacion+ comida.remove(0) + "\n";
		}
		comida=comanda.getSegundo_plato();
		notificacion=notificacion+"SEGUNDOS\n";
		while(!comida.isEmpty()) {
			notificacion= notificacion+ comida.remove(0) + "\n";
		}
		comida=comanda.getPostre();
		notificacion=notificacion+"POSTRES\n";
		while(!comida.isEmpty()) {
			notificacion= notificacion+ comida.remove(0) + "\n";
		}
		IU_Cocina.getNotificaciones().add(notificacion);

	}

	/**
	 * 
	 * @param comanda
	 */
	public void camarero_mandarBebida(Comanda comanda) {
		ArrayList<String>bebida=comanda.getBebidas();
		String notificacion="Preparar las bebidas de la mesa: " + comanda.getMesa_asociada().getNumero() +"\n";
		while(!bebida.isEmpty()) {
			notificacion= notificacion+ bebida.remove(0) + "\n";
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
		String notificacion="COMANDA LISTA de la mesa: " + comanda.getMesa_asociada().getNumero() +"\n";
		IU_Camarero.getNotificaciones().add(notificacion);

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
		String notificacion="BEBIDAS LISTA de la mesa: " + comanda.getMesa_asociada().getNumero() +"\n";
		IU_Camarero.getNotificaciones().add(notificacion);

	}

}