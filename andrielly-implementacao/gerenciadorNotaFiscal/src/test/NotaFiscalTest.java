package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Fatura;
import main.NotaFiscal;

class NotaFiscalTest {
	
	@Test
	void testNotaFiscalCreation() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		assertTrue(notaFiscal.isValid);
	}

}
