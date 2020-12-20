package Dominio;

import java.util.ArrayList;

import Persistencia.Agente;
import Presentacion.IU_Camarero;

// JORGE
public class Camarero_Barra extends Empleado {
	private String barra;
	
	public Camarero_Barra(int i,String n,String t) {
		super(i,n,t);
		// TODO Auto-generated constructor stub
	}
	
	public Camarero_Barra(int id) {
		super(id);
	}

	public int avisarCamarero_Mesa_BebidasListas() {
		String mensaje= "LAS BEBIDAS DE LA COMANDA X YA ESTAN LISTAS PARA SER SERVIDAS ";
		
		// TODO - implement Camarero_Barra.avisarCamarero_Mesa_BebidasListas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param comanda
	 */
	public static void prepararBebidas(Comanda comanda) {
		ArrayList<Bebida> bebidas= comanda.getBebidas();
		for(int j = 0;j<bebidas.size();j++) {
		Agente.modificar("UPDATE Bebidas SET cantidad_disponible=(cantidad_disponible-"+bebidas.get(j).getCantidad()+
				") WHERE nombre="+ bebidas.get(j).getNombre());
		}
	}

	/**
	 * 
	 * @param bebidas
	 */
	public static void reponerBebidas() {
		Agente.modificar("UPDATE Bebidas SET cantidad_disponible=50 WHERE cantidad_disponible<10;\");"); //Insertar Bebidas
	}
	public void mandarNotificacion(Comanda comanda, String notificacion) {
		Agente.insertar("INSERT INTO notificaciones VALUES(origen, destino, mensaje) VALUES "+ id_empleado +", "+comanda.getId_camarero() +","+ notificacion+"");
		// TODO Auto-generated method stub
		
	}
	public static void eliminarNotificacion(String identificador) {
		Agente.eliminar("DELETE * FROM notificaciones WHERE id= " +identificador+ "");
		// TODO Auto-generated method stub
		
	}
	public boolean Autenticar() {
		boolean correcto=true;
        int resultado=Integer.parseInt(Agente.get("SELECT id_empleado FROM Empleados WHERE id_empleado="+this.id_empleado));
        if(resultado==0) {
        	correcto=false;
        }
        else {
        	correcto= true;
        	setId_empleado(resultado);
        	setNombre(Agente.get("SELECT nombre FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Barra')"));
        	setTelefono(Agente.get("SELECT telefono FROM Empleados WHERE (id_empleado="+this.id_empleado+" AND rol='Camarero_Barra')"));
        }
		return correcto;
	}

}