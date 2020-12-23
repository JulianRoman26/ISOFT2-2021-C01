import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Gestor_Comandas;

public class Gestor_ComandasTest {

	@Test
	public void testIdentificarse() {
		Gestor_Comandas gc = new Gestor_Comandas();
		boolean expected=true;
		boolean actual=gc.identificarse("Cocinero", 3);
		assertEquals(expected,actual);
	}
}