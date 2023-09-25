package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Fatura;
import main.GeradorNotaFiscal;
import main.NotaFiscal;
import main.TipoServico;

class GeradorNotaFiscalTest {
	
	private GeradorNotaFiscal gerador;
	private Fatura fatura;
	
	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
		fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
	}
	
	@Test
	@DisplayName(value = "Teste de geração de nota fiscal")
	void testGeraNotaFiscal() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(25.0, nota.getImposto());
	}

	@Test
	@DisplayName(value = "Teste de função de persistência no banco")
	void testSalvaNoBanco() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.salvaNoBanco(nota);
		assertEquals("salvando no banco", saida);
	}
	
	@Test
	@DisplayName(value = "Teste de função de envio de e-mail")
	void testEnviaEmail() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.enviaEmail(nota);
		assertEquals("enviando por email", saida);
	}
	
	@Test
	@DisplayName(value = "Teste de função de envio para SAP")
	void testEnviaParaSap() {
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.enviaParaSap(nota);
		assertEquals("enviando pro sap", saida);
	}
	
}
