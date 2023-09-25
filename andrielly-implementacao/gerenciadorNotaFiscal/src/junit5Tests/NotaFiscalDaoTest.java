package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Fatura;
import main.NotaFiscal;
import main.TipoServico;
import util.NotaFiscalDao;

class NotaFiscalDaoTest {

	@Test
	@ConsultoriaTest
	void testSalvaNota() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals("salvando no banco", NotaFiscalDao.salva(notaFiscal));
	}

}
