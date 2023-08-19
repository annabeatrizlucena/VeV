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
	
	@Test
	void testCalculaImpostoConsultoria() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals(25.0, notaFiscal.getImposto());
	}

	@Test
	void testCalculaImpostoTreinamento() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "TREINAMENTO", 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);

		assertEquals(15.0, notaFiscal.getImposto());
	}
	
	@Test
	void testCalculaImpostoOutroServico() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "OUTRO", 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);

		assertEquals(6.0, notaFiscal.getImposto());
	}
}
