package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GeradorNotaFiscal;
import main.NotaFiscal;

class GeradorNotaFiscalTest {
	
	private GeradorNotaFiscal gerador;
	
	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
	}

	@Test
	void testConsultoria() {
		NotaFiscal nota = gerador.geraNota("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		assertEquals(25.0, nota.getImposto());
	}
	
	@Test
	void testTreinamento() {
		NotaFiscal nota = gerador.geraNota("Jose Silva", "Rua Silva Barbosa, 975", "TREINAMENTO", 100.0);
		assertEquals(15.0, nota.getImposto());
	}
	
	@Test
	void testOutroTipo() {
		NotaFiscal nota = gerador.geraNota("Jose Silva", "Rua Silva Barbosa, 975", "OUTRO", 100.0);
		assertEquals(6.0, nota.getImposto());
	}
	
	@Test
	void testTipoNull() {
		NotaFiscal nota = gerador.geraNota("Jose Silva", "Rua Silva Barbosa, 975", null, 100.0);
		assertEquals(6.0, nota.getImposto());
	}

}
