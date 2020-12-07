package Dominio;

import java.util.ArrayList;

import Presentacion.IU_Cocina;

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
	 * @param idMesa
	 */
	public int camarero_secuenciarEstado(int idMesa) {
		// TODO - implement Gestor_Comandas.camarero_secuenciarEstado
		throw new UnsupportedOperationException();
	}

	public int camarero_anotarComanda() {
		// TODO - implement Gestor_Comandas.camarero_anotarComanda
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param comandaAnotada
	 */
	public boolean camarero_validarComanda(Comanda comandaAnotada) {
		return false;

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
	public int camarero_AvisarCocina_FaltaIngredientes(String[] ingredientes, int[] cantidad_ingredientes) {
		// TODO - implement Gestor_Comandas.camarero_AvisarCocina_FaltaIngredientes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param comanda
	 */
	public void camarero_mandarComida(Comanda comanda) {
		ArrayList<String>comida=comanda.getEntrantes();
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
	public int camareroBarra_prepararBebida(Comanda comanda) {
		return 0;

	}

	/**
	 * 
	 * @param comanda
	 */
	public int cocina_cocinarPlatos(Comanda comanda) {
		return 0;

	}

	/**
	 * 
	 * @param ingredientes
	 */
	public int cocina_reponerAlmacen(String[] ingredientes) {
		// TODO - implement Gestor_Comandas.cocina_reponerAlmacen
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bebidas
	 * @param cantidad
	 */
	public int camareroBarra_reponerBebidas(String[] bebidas, int[] cantidad) {
		// TODO - implement Gestor_Comandas.camareroBarra_reponerBebidas
		throw new UnsupportedOperationException();
	}

}