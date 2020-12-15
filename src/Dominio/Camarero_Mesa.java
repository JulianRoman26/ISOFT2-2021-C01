
package Dominio;

import Persistencia.Agente;

// SERGIO
public class Camarero_Mesa extends Camarero{

	public Camarero_Mesa() {
		// TODO Auto-generated constructor stub
	}
	
	public Camarero_Mesa(String exp) {
		super(exp);
		// TODO Auto-generated constructor stub
	}

	private static Mesa[] mesas;
	// la forma en la que organizaremos las mesas es con 
	public static void secuenciarEstado_Mesa(int num_mesa) {
		mesas[num_mesa].setEstado(Agente.consultar("GET estado FROM mesa WHERE num_mesa = "+ num_mesa+""));
		mesas[num_mesa].secuenciarEstado();
		Agente.modificar("UPDATE mesa SET estados=("+mesas[num_mesa].getEstado()+") WHERE num ="+ num_mesa);
		throw new UnsupportedOperationException();
	}



	public boolean validarComanda() {
		// TODO - implement Camarero_Mesa.validarComanda
		throw new UnsupportedOperationException();
	}

	public void anotarComanda(Comanda comanda) {
		Agente.insertar("INSERT INTO comandas VALUES (id_mesa, entrantes, primeros, segundos, postres, bebidas) VALUES ("+comanda.getMesa_asociada().getNumero()+","+comanda.getEntrantes()+","+comanda.getPrimer_plato()+""+comanda.getSegundo_plato()+","+comanda.getPostre()+","+comanda.getBebidas()+")");
		// TODO - implement Camarero_Mesa.anotarComanda
		throw new UnsupportedOperationException();
	}

	public void seleccionarNum_Mesa() {
		// TODO - implement Camarero_Mesa.seleccionarNum_Mesa
		throw new UnsupportedOperationException();
	}

}