package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PERMANENCIA")
public class Permanencia {



	@Column(name = "cd_cliente", nullable = false)
	@ManyToOne
	private Cliente codigoCliente;

	@Column(name = "cd_estacionamento", nullable = false)
	@OneToMany
	private Estacionamento codigoEstacionamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_entrada", nullable = false)
	private Calendar entrada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_saida", nullable = false)
	private Calendar saida;

	public Permanencia(Calendar entrada, Calendar saida) {
		super();
		this.entrada = entrada;
		this.saida = saida;
	}

	public Permanencia() {

	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm");
		return "Data/Hora entrada: " + sdf.format(entrada.getTime()) + "\nData/Hora saida: "
				+ sdf.format(saida.getTime());
	}

	public Cliente getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Estacionamento getCodigoEstacionamento() {
		return codigoEstacionamento;
	}

	public void setCodigoEstacionamento(Estacionamento codigoEstacionamento) {
		this.codigoEstacionamento = codigoEstacionamento;
	}

	public Calendar getEntrada() {
		return entrada;
	}

	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}

	public Calendar getSaida() {
		return saida;
	}

	public void setSaida(Calendar saida) {
		this.saida = saida;
	}

}
