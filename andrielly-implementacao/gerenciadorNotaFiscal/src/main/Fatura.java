package main;

public class Fatura {

	public boolean isValid;

	public Fatura(String nome, String endereco, String tipoServico, double valorFatura) {
		if (nome == null || endereco == null || valorFatura <= 0.0) {
			throw new IllegalArgumentException("Campos invalidos");
		}
		isValid = true;
	}

}
