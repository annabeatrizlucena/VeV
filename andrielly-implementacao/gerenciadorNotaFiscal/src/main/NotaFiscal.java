package main;

public class NotaFiscal {
	
	public boolean isValid;
	private Fatura fatura;
	private double imposto;

	public NotaFiscal(Fatura fatura) {
		this.fatura = fatura;
		this.imposto = calculaImposto(this.fatura);
		isValid = true;
	}
	
	private double calculaImposto(Fatura fatura) {
		double valorFatura = fatura.getValor();
		String tipoServico = fatura.getTipoServico();
		
		if (tipoServico == null) {
			tipoServico = "";
		}
		
		if (tipoServico.equals("CONSULTORIA")) {
			return valorFatura * 0.25;
		} else if (tipoServico.equals("TREINAMENTO")) {
			return valorFatura * 0.15;
		} else {
			return valorFatura * 0.06;
		}
	}

	public double getImposto() {
		return this.imposto;
	}

	public Fatura getFatura() {
		return this.fatura;
	}

	public void setFatura(Fatura fatura2) {
		if (fatura2 != null) {
			this.fatura = fatura2;
			this.imposto = calculaImposto(fatura2);
		}
	}

}
