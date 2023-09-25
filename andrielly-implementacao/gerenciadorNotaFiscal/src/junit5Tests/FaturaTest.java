package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Fatura;
import main.TipoServico;

class FaturaTest {

	@Test
	@ConsultoriaTest
	void testFaturaCreation() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		assertTrue(fatura.isValid);
	}
	
	@Test
	@ConsultoriaTest
	void testFaturaCreationNomeNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura(null, "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0));
	}
	
	@Test
	@ConsultoriaTest
	void testFaturaCreationEnderecoNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", null, TipoServico.CONSULTORIA, 100.0));
	}
	
	@Test
	@ConsultoriaTest
	void testFaturaCreationValorFaturaMenorQueZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 0.0));
	}

	@Test
	@ConsultoriaTest
	void testFaturaGetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		assertEquals("Jose Silva", fatura.getNome());
		assertEquals("Rua Silva Barbosa, 975", fatura.getEndereco());
		assertEquals(TipoServico.CONSULTORIA, fatura.getTipoServico());
		assertEquals(100.0, fatura.getValor());
	}
	
	@Test
	@ConsultoriaTest
	@TreinamentoTest
	void testFaturaSetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		fatura.setNome("Joaquim Silva");
		assertEquals("Joaquim Silva", fatura.getNome());
		
		fatura.setEndereco("Rua Silva Barbosa, 975, Campina Grande, Paraíba");
		assertEquals("Rua Silva Barbosa, 975, Campina Grande, Paraíba", fatura.getEndereco());
		
		fatura.setTipoServico(TipoServico.TREINAMENTO);
		assertEquals(TipoServico.TREINAMENTO, fatura.getTipoServico());
		
		fatura.setValor(200.0);
		assertEquals(200.0, fatura.getValor());
	}
	
	@Test
	@ConsultoriaTest
	void testSetNomeNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setNome(null));
	}
	
	@Test
	@ConsultoriaTest
	void testSetEnderecoNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setEndereco(null));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {0.0, -1.0})
	@ConsultoriaTest
	void testSetValorFaturaMenorIgualQueZero(double value) {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setValor(value));
	}
	
	@Test
	@ConsultoriaTest
	void testEquals() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		assertTrue(fatura.equals(fatura2));
	}
	
	@Test
	@ConsultoriaTest
	void testHashCode() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		assertEquals(fatura.hashCode(), fatura2.hashCode());
	}
}
