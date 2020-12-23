

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Camarero_Barra;

public class Camarero_Barra_Test {

	@Test
	public void testAutenticar() {
		Camarero_Barra cb = new Camarero_Barra(1);
		boolean expected = true;
		boolean actual = cb.Autenticar();
		assertEquals(expected,actual);
	}

}