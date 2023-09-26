package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import main.Fatura;
import main.NotaFiscal;
import main.TipoServico;

class NotaFiscalTest {
	
	@Test
	@DisplayName(value = "Teste de criação de nota fiscal")
	@ConsultoriaTest
	void testNotaFiscalCreation() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		assertTrue(notaFiscal.isValid);
	}
	
	@Test
	@DisplayName(value = "Teste de cálculo de imposto de nota fiscal para serviço de consultoria")
	@ConsultoriaTest
	void testCalculaImpostoConsultoria() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals(25.0, notaFiscal.getImposto());
	}

	@Test
	@DisplayName(value = "Teste de cálculo de imposto de nota fiscal para serviço de treinamento")
	@TreinamentoTest
	void testCalculaImpostoTreinamento() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.TREINAMENTO, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);

		assertEquals(15.0, notaFiscal.getImposto());
	}
	
	@ParameterizedTest
	@DisplayName(value = "Teste de cálculo de imposto de nota fiscal para outros tipos de serviço")
	@NullSource
	@EnumSource(value = TipoServico.class, names = { "OUTROS" })
	@OutroServicoTest
	void testCalculaImpostoOutroServico(TipoServico value) {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", value, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);

		assertEquals(6.0, notaFiscal.getImposto());
	}
	
	@Test
	@DisplayName(value = "Teste de recuperação de atributos da nota fiscal")
	@ConsultoriaTest
	void testNotaFiscalGetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals(fatura, notaFiscal.getFatura());
		assertEquals(25.0, notaFiscal.getImposto());
	}
	
	@Test
	@DisplayName(value = "Teste de atualização de atributos da nota fiscal")
	@ConsultoriaTest
	void testFaturaSetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 250.0);
		
		notaFiscal.setFatura(fatura2);
		
		assertEquals(fatura2, notaFiscal.getFatura());
		assertEquals(62.5, notaFiscal.getImposto());
		
	}
	
	@Test
	@DisplayName(value = "Teste de atualização de fatura da nota fiscal para null")
	@ConsultoriaTest
	void testSetFaturaNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		notaFiscal.setFatura(null);
		assertEquals(fatura, notaFiscal.getFatura());
	}
}
