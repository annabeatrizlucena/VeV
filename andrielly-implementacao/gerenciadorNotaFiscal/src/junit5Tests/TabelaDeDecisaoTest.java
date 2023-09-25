package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import main.Fatura;
import main.GeradorNotaFiscal;
import main.NotaFiscal;
import main.TipoServico;

class TabelaDeDecisaoTest {
	private GeradorNotaFiscal gerador;

	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
		
	}

	@Test
	@ConsultoriaTest
	void testConsultoria() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(25.0, nota.getImposto());

	}

	@Test
	@TreinamentoTest
	void testTreinamento() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.TREINAMENTO, 100);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(15.0, nota.getImposto());

	}

	@Test
	@OutroServicoTest
	void testOutro() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.OUTROS, 100);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(6.0, nota.getImposto());

	}
	
	@ParameterizedTest
	@EnumSource(TipoServico.class)
	@ConsultoriaTest
	@TreinamentoTest
	@OutroServicoTest
	void testValorInvalido(TipoServico servico) {

		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", servico, -1));

	}

}
