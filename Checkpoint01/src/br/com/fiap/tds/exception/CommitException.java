package br.com.fiap.tds.exception;

public class CommitException extends Exception {
	public CommitException() {
		super("N�o foi possivel fazer o commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}

}
