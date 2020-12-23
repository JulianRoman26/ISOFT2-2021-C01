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

	private static Camarero_Mesa camarero;
	private Camarero_Barra barra;
	private Cocinero cocinero;

	public Camarero_Mesa getCamarero() {
		return camarero;
	}

	public Camarero_Barra getBarra() {
		return barra;
	}

	public Cocinero getCocinero() {
		return cocinero;
	}

	public void setCamarero(Camarero_Mesa camarero) {
		this.camarero = camarero;
	}

	public void setBarra(Camarero_Barra barra) {
		this.barra = barra;
	}

	public void setCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}

	/**
	 * 
	 * @param numeroMesa
	 */
	public void camarero_secuenciarEstado(int numeroMesa) { // Terminado
		camarero.secuenciarEstado_Mesa(numeroMesa);
	}

	public  void camarero_anotarComanda(Comanda comanda) { // Terminado
		if (camarero_validarComanda(comanda) == true) {
			System.out.println("Validada");
			camarero.anotarComanda(comanda); // Anadir la comanda en la base de datos
			camarero_mandarComida(comanda);
			camarero_mandarBebida(comanda);
		} else {
			System.out.println(" No Validada");
			camarero_AvisarCocina_FaltaIngredientes();
		}
	}

	/**
	 * 
	 * @param comandaAnotada
	 */
	public boolean camarero_validarComanda(Comanda comandaAnotada) { // Terminado
		return camarero.validarComanda(comandaAnotada);
	}
	/**
	 * 
	 * @param ingredientes
	 * @param cantidad_ingredientes
	 */
	public static void camarero_AvisarCocina_FaltaIngredientes() {
		String notificacion = "NOS HEMOS QUEDADO SIN INGREDIENTES. DEBES REPONER EL ALMACEN";
		camarero.avisar_ingredientes(notificacion);
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
		camarero.mandar_comida(notificacion);
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
		camarero.mandar_bebida(notificacion);
	}

	/**
	 * 
	 * @param comanda
	 */
	public void cocina_cocinarPlatos(int id_mesa) {
		Comanda comanda =cocinero.leerComanda(id_mesa);
		Cocinero.cocinarPlatos(comanda);
		cocina_avisarComidaLista(comanda);
	}

	/**
	 * 
	 * @param ingredientes
	 */
	public void cocina_reponerAlmacen() {
		Cocinero.reponerAlmacen();
	}

	public void cocina_avisarComidaLista(Comanda comanda) {
		String notificacion = "COMANDA LISTA de la mesa: " + comanda.getMesa_asociada() + "\n";
		cocinero.avisar_Comida_Lista(notificacion, comanda);
	}
	
	/**
	 * 
	 * @param comanda
	 */
	public void camareroBarra_prepararBebida(int n) {
		Comanda comanda = barra.leerComanda(n);
		barra.prepararBebidas(comanda);
		//camareroBarra_avisarBebidaLista(comanda);
	}

	public void camareroBarra_reponerBebidas() {
		barra.reponerBebidas();
	}

	public void camareroBarra_avisarBebidaLista(Comanda comanda) {
		String notificacion = "BEBIDAS LISTA de la mesa: " + comanda.getMesa_asociada() + "\n";
		barra.avisarCamarero_Mesa_BebidasListas(comanda, notificacion);
	}

	public int contarNotificaciones() {
		int num=camarero.obtenerNotificaciones();
		return num;
	}

	public  ArrayList<ArrayList<String>> mostrarNotificaciones() {
		
		ArrayList<ArrayList<String>> notificaciones=camarero.mostrarNotificaciones();
		return notificaciones;

	}

	public static void eliminarNotificacion(String identificador) {
		Camarero_Barra.eliminarNotificacion(identificador);
		// TODO Auto-generated method stub
		
	}

	public boolean identificarse(String rol, int id) {
		boolean existe=true;
		switch(rol) {
		case "Camarero_Mesa":
			Camarero_Mesa c= new Camarero_Mesa(id);
			existe=c.Autenticar();
			setCamarero(c);
			break;
		case "Camarero_Barra":
			Camarero_Barra cb= new Camarero_Barra(id);
			existe=cb.Autenticar();
			setBarra(cb);
			
			break;
		case "Cocinero":
			Cocinero co=new Cocinero(id);
			existe=co.Autenticar();
			setCocinero(co);
			break;
		case "Jefe_Mesa":
			break;
		}
		return existe;

	}






}