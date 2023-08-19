package main;

public class GeradorNotaFiscal {

	public NotaFiscal geraNotaFiscal(Fatura fatura) {
		NotaFiscal nota = new NotaFiscal(fatura);
		return nota;
	}

	public String salvaNoBanco(NotaFiscal nota) {
		return "salvando no banco";
	}

	public String enviaEmail(NotaFiscal nota) {
		return "enviando por email";
	}

	public String enviaParaSap(NotaFiscal nota) {
		return "enviando pro sap";
	}

}
