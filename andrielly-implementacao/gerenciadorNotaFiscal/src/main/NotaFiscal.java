package main;

public class NotaFiscal {

	public Double imposto;
	private String nome;
	private String endereco;
	private String tipoServico;
	private double valorFatura;

	public NotaFiscal(String nome, String endereco, String tipoServico, double valorFatura) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTipoServico(tipoServico);
		this.setValorFatura(valorFatura);
		this.setImposto(calculaImposto(tipoServico, valorFatura));
	}

	private double calculaImposto(String tipoServico, double valorFatura) {
		double valorImposto = 0.0;
		if (tipoServico.equals("CONSULTORIA")) {
			valorImposto = 0.25 * valorFatura;
		} else if (tipoServico.equals("TREINAMENTO")) {
			valorImposto = 0.15 * valorFatura;
		} else {
			valorImposto = 0.06 * valorFatura;
		}
		
		return valorImposto;
	}

	public Double getImposto() {
		return this.imposto;
	}
	
	private void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}

}
