package br.com.fiap.tds.exeptions;

public class VeiculoNotFoundExeption extends Exception {
	public VeiculoNotFoundExeption() {
		super("Veiculo n�o encontrado");
	}
	
	public VeiculoNotFoundExeption(String msg) {
		super(msg);
	}

}
