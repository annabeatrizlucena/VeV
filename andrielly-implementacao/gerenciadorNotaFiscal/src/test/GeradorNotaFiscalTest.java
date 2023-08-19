package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Fatura;
import main.GeradorNotaFiscal;
import main.NotaFiscal;

class GeradorNotaFiscalTest {
	
	private GeradorNotaFiscal gerador;
	
	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
	}
	
	@Test
	void testGeraNotaFiscal() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		
		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
	}

	@Test
	void testSalvaNoBanco() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.salvaNoBanco(nota);
	}
	
	@Test
	void testEnviaEmail() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.enviaEmail(nota);
	}
	
	@Test
	void testEnviaParaSap() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		String saida = gerador.enviaParaSap(nota);
	}
	
}
