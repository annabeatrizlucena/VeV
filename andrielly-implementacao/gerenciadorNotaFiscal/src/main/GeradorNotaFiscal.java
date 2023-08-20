package main;

import util.*;

public class GeradorNotaFiscal {

	public NotaFiscal geraNotaFiscal(Fatura fatura) {
		NotaFiscal nota = new NotaFiscal(fatura);
		return nota;
	}

	public String salvaNoBanco(NotaFiscal nota) {
		return NotaFiscalDao.salva(nota);
	}

	public String enviaEmail(NotaFiscal nota) {
		return Smtp.envia(nota);
	}

	public String enviaParaSap(NotaFiscal nota) {
		return Sap.envia(nota);
	}

}
