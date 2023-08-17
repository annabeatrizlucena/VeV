package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeradorNotaFiscalTest {
	
	@BeforeEach
	void inicializaGerador() {
		GeradorNotaFiscal gerador = new GeradorNotaFiscal();
	}

	@Test
	void testConsultoria() {
		NotaFiscal nota = gerador.geraNota("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		assertEquals(25.0, nota.imposto);
	}

}
