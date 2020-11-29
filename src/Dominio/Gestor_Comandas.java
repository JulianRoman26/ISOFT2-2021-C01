package Dominio;

import java.util.ArrayList;

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

	public int camarero_anotarComanda(Camarero_Mesa cam,ArrayList<String> entrante,ArrayList<String> primer,ArrayList<String>segundo
									,ArrayList<String>postre, ArrayList<String>bebida) {
		// TODO - implement Gestor_Comandas.camarero_anotarComanda
		int res=0;
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
		
		
		
		return res;

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
	public int camarero_AvisarCocina_FaltaIngredientes() {
		// TODO - implement Gestor_Comandas.camarero_AvisarCocina_FaltaIngredientes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param comanda
	 */
	public int camarero_mandarComida(Comanda comanda) {
		return 0;

	}

	/**
	 * 
	 * @param comanda
	 */
	public int camarero_mandarBebida(Comanda comanda) {
		return 0;

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