
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



	public boolean validarComanda(Comanda comandaAnotada) {
		ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
		ArrayList<Plato> platos = new ArrayList<Plato>();
		Plato p;
		
		platos.addAll(comandaAnotada.getEntrantes());
		platos.addAll(comandaAnotada.getPrimer_plato());
		platos.addAll(comandaAnotada.getSegundo_plato());
		platos.addAll(comandaAnotada.getPostre());
		Iterator<Plato> iter = platos.iterator();
		
		while (iter.hasNext()) {
			p= iter.next();
			Iterator<Ingrediente> iter2= p.getIngredientes().iterator();
			
			while (iter2.hasNext()){
				Ingrediente i=iter2.next();
				if (!ingredientes.contains(i)) {
					ingredientes.add(i);	
				}else {
					int num=ingredientes.indexOf(i);
					ingredientes.get(num).setCantidad(ingredientes.get(num).getCantidad()+i.getCantidad());
				}
			}
		}
		Iterator<Ingrediente> iter3 = ingredientes.iterator();
		while (iter3.hasNext()) {
			// quiza se pueda usar una coleccion para almacenar todo lo que reciba Collection coleccion;
			Ingrediente ing= null; 
			Ingrediente ing_actual= iter3.next();
			ArrayList<ArrayList<String>> componente =Agente.consultar("SELECT cantidad FROM Ingredientes WHERE nombre = "+ ing_actual.getNombre() +"");
			
			if (ing_actual.getCantidad() > Integer.parseInt(componente.get(0).get(0))) return false;
		}
		return true;
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
