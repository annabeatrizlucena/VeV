package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Fatura;
import main.NotaFiscal;
import util.Sap;

class SapTest {

	@Test
	void testSalvaNota() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals("salvando no banco", Sap.envia(notaFiscal));
	}

}
