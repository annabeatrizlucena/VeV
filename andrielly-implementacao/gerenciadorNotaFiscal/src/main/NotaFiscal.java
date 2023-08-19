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
	
	public double calculaImposto(Fatura fatura) {
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

}
