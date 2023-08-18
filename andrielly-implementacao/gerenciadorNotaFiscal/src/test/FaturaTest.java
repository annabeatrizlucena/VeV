package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Fatura;

class FaturaTest {

	@Test
	void testFaturaCreation() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		assertTrue(fatura.isValid);
	}
	
	@Test
	void testFaturaCreationNomeNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura(null, "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0));
	}
	
	@Test
	void testFaturaCreationEnderecoNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", null, "CONSULTORIA", 100.0));
	}
	
	@Test
	void testFaturaCreationValorFaturaMaiorQueZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 0.0));
	}
	

	@Test
	void testFaturaGetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", "CONSULTORIA", 100.0);
		assertEquals("Jose Silva", fatura.getNome());
		assertEquals("Rua Silva Barbosa, 975", fatura.getEndereco());
		assertEquals("CONSULTORIA", fatura.getTipoServico());
		assertEquals(100.0, fatura.getValor());
	}
}
