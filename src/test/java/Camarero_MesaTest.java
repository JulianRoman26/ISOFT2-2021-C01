
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import Dominio.Bebida;
import Dominio.Camarero_Mesa;
import Dominio.Comanda;
import Dominio.Plato;

public class Camarero_MesaTest {

	@Test
	public void test_ValidarComanda() {
		Camarero_Mesa cm = new Camarero_Mesa(2,"Rafa","617002896");
		cm.setId_mesa(1);
		Comanda comanda = new Comanda(1,1);
		ArrayList<Plato> e = new ArrayList<Plato>();
		ArrayList<Plato> p = new ArrayList<Plato>();
		ArrayList<Plato> s = new ArrayList<Plato>();
		ArrayList<Plato> t = new ArrayList<Plato>();
		ArrayList<Bebida> b = new ArrayList<Bebida>();
		
		Plato entrante = new Plato("queso");
		Plato primero= new Plato("ensalada");
		Plato segundo= new Plato("lubina");
		Plato postre= new Plato("tarta_de_queso");
		Bebida bebida= new Bebida("agua");
		e.add(entrante);
		p.add(primero);
		s.add(segundo);
		t.add(postre);
		b.add(bebida);
		comanda.setBebidas(b);
		comanda.setEntrantes(e);
		comanda.setPrimer_plato(p);
		comanda.setSegundo_plato(s);
		comanda.setPostre(p);
		
		boolean espected = true;
		boolean actual = cm.validarComanda(comanda);
		assertEquals(espected,actual); 
	}

}