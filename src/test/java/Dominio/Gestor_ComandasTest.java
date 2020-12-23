package Dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class Gestor_ComandasTest {

	@Test
	public void testIdentificarse() {
		Gestor_Comandas gc = new Gestor_Comandas();
		boolean expected=true;
		boolean actual=gc.identificarse("Cocinero", 3);
		assertEquals(expected,actual);
	}
}
