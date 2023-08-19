package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Fatura;
import main.GeradorNotaFiscal;
import main.NotaFiscal;

class GeradorNotaFiscalTest {
	
	private GeradorNotaFiscal gerador;
	private Fatura fatura;
	
	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
		fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		
	}
	
	@Test
	void testGeraNotaFiscal() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(25.0, nota.getImposto());
	}

	@Test
	void testSalvaNoBanco() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.salvaNoBanco(nota);
		assertEquals("salvando no banco", saida);
	}
	
	@Test
	void testEnviaEmail() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.enviaEmail(nota);
		assertEquals("enviando pro sap", saida);
	}
	
	@Test
	void testEnviaParaSap() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.enviaParaSap(nota);
		assertEquals("enviando por email", saida);
	}
	
}
