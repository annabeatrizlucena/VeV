package main;

public class GeradorNotaFiscal {

	public NotaFiscal geraNota(String nome, String endereco, String tipoServico, double valorFatura) {
		NotaFiscal nota = new NotaFiscal(nome, endereco, tipoServico, valorFatura);
		return nota;
	}

}
