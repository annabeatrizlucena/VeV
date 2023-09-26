package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Fatura;
import main.TipoServico;

class FaturaTest {

	@Test
	@DisplayName(value = "Teste de criação de fatura")
	@ConsultoriaTest
	void testFaturaCreation() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		assertTrue(fatura.isValid);
	}
	
	@Test
	@DisplayName(value = "Teste de criação de fatura com nome null")
	@ConsultoriaTest
	void testFaturaCreationNomeNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura(null, "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0));
	}
	
	@Test
	@DisplayName(value = "Teste de criação de fatura com endereço null")
	@ConsultoriaTest
	void testFaturaCreationEnderecoNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", null, TipoServico.CONSULTORIA, 100.0));
	}
	
	@Test
	@DisplayName(value = "Teste de criação de fatura com valor inválido")
	@ConsultoriaTest
	void testFaturaCreationValorFaturaMenorQueZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 0.0));
	}

	@Test
	@DisplayName(value = "Teste de recuperação de atributos de fatura")
	@ConsultoriaTest
	void testFaturaGetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		assertEquals("Jose Silva", fatura.getNome());
		assertEquals("Rua Silva Barbosa, 975", fatura.getEndereco());
		assertEquals(TipoServico.CONSULTORIA, fatura.getTipoServico());
		assertEquals(100.0, fatura.getValor());
	}
	
	@Test
	@DisplayName(value = "Teste de atualização de atributos de fatura")
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
	@DisplayName(value = "Teste de atualização de nome para null")
	@ConsultoriaTest
	void testSetNomeNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setNome(null));
	}
	
	@Test
	@DisplayName(value = "Teste de atualização de endereço para null")
	@ConsultoriaTest
	void testSetEnderecoNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setEndereco(null));
	}
	
	@ParameterizedTest
	@DisplayName(value = "Teste de atualização de valor para valor inválido")
	@ValueSource(doubles = {0.0, -1.0})
	@ConsultoriaTest
	void testSetValorFaturaMenorIgualQueZero(double value) {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setValor(value));
	}
	
	@Test
	@DisplayName(value = "Teste de função equals de fatura")
	@ConsultoriaTest
	void testEquals() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		assertTrue(fatura.equals(fatura2));
	}
	
	@Test
	@DisplayName(value = "Teste de função hashCode de fatura")
	@ConsultoriaTest
	void testHashCode() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		assertEquals(fatura.hashCode(), fatura2.hashCode());
	}
}
