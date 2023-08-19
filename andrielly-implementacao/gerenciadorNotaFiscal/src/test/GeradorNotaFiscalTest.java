package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GeradorNotaFiscal;
import main.NotaFiscal;

class GeradorNotaFiscalTest {
	
	private GeradorNotaFiscal gerador;
	
	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
	}

}
