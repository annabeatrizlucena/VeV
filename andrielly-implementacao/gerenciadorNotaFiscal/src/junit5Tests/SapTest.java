package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Fatura;
import main.NotaFiscal;
import main.TipoServico;
import util.Sap;

class SapTest {

	@Test
	@DisplayName(value = "Teste de função de envio para SAP")
	@ConsultoriaTest
	void testSalvaNota() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals("enviando pro sap", Sap.envia(notaFiscal));
	}

}
