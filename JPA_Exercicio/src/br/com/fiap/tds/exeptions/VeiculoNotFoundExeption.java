package br.com.fiap.tds.exeptions;

public class VeiculoNotFoundExeption extends Exception {
	public VeiculoNotFoundExeption() {
		super("Veiculo não encontrado");
	}
	
	public VeiculoNotFoundExeption(String msg) {
		super(msg);
	}

}
