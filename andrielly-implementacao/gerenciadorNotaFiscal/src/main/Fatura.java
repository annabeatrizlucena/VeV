package main;

import java.util.Objects;

public class Fatura {

	public boolean isValid;
	
	private String nome;
	private String endereco;
	private TipoServico tipoServico;
	private double valor;
	
	public Fatura(String nome, String endereco, TipoServico tipoServico, double valor) {
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

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
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

	@Override
	public int hashCode() {
		return Objects.hash(endereco, isValid, nome, tipoServico, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fatura other = (Fatura) obj;
		return Objects.equals(endereco, other.endereco) && isValid == other.isValid && Objects.equals(nome, other.nome)
				&& Objects.equals(tipoServico, other.tipoServico)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}


}
