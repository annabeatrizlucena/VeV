package functionalTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Fatura;
import main.GeradorNotaFiscal;
import main.NotaFiscal;
import main.TipoServico;

class ParticaoPorEquivalenciaTest {
	private GeradorNotaFiscal gerador;

	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
		
	}


	@Test
	void testConsultoria() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(25.0, nota.getImposto());

	}

	@Test
	void testTreinamento() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.TREINAMENTO, 100);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(15.0, nota.getImposto());

	}

	@Test
	void testOutro() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.OUTROS, 100);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(6.0, nota.getImposto());

	}
	
	@Test
	void testConsultoriaEValorInvalido() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, -1));

	}

	@Test
	void testTreinamentoEValorInvalido() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.TREINAMENTO, -1));

	}

	@Test
	void testOutroEValorInvalido() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.OUTROS, -1));

	}
}
