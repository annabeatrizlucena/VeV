package main;

public class NotaFiscal {
	
	public boolean isValid;
	private Fatura fatura;

	public NotaFiscal(Fatura fatura) {
		this.fatura = fatura;
		isValid = true;
	}

	public double getImposto() {
		double valorFatura = this.fatura.getValor();
		String tipoServico = this.fatura.getTipoServico();
		
		if (tipoServico.equals("CONSULTORIA")) {
			return valorFatura * 0.25;
		} else if (tipoServico.equals("TREINAMENTO")) {
			return valorFatura * 0.15;
		} else {
			return valorFatura * 0.06;
		}
	}

}
