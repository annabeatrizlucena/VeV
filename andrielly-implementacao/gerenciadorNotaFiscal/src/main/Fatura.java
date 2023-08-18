package main;

public class Fatura {

	public boolean isValid;
	
	private String nome;
	private String endereco;
	private String tipoServico;
	private double valor;
	
	public Fatura(String nome, String endereco, String tipoServico, double valor) {
		if (nome == null || endereco == null || valor <= 0.0) {
			throw new IllegalArgumentException("Campos invalidos");
		}
		this.nome = nome;
		this.endereco = endereco;
		this.tipoServico = tipoServico;
		this.valor = valor;
		isValid = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("Campo invalido");
		}
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("Campo invalido");
		}
		this.endereco = endereco;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if (valor <= 0.0) {
			throw new IllegalArgumentException("Campo invalido");
		}
		this.valor = valor;
	}


}
