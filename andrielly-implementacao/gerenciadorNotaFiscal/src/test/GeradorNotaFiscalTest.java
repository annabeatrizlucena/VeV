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

}
