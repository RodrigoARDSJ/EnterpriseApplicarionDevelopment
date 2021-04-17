package br.com.fiap.tds.exeptions;

public class CommitExeption extends Exception {
	public CommitExeption() {
		super("Erro ao fazer o commit");
	}

	public CommitExeption(String msg) {
		super(msg);
	}

}
