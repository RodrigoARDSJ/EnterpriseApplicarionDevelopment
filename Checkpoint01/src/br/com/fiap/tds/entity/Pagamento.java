package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PAGAMENTO")
@SequenceGenerator(allocationSize = 1, name = "pagamento", sequenceName = "SQ_TB_PAGAMENTO")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento")
	@Column(name = "cd_pagamento", nullable = false)
	private int codigo;
	
	@Column(name = "cd_cliente", nullable = false)
	private Cliente codigoCliente;
	
	@Column(name = "nr_cartao", nullable = false)
	private int cart?o;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_metodo", nullable = false)
	private Metodo metodo;

	public Pagamento(int codigo, int cart?o, Metodo metodo) {
		super();
		this.codigo = codigo;
		this.cart?o = cart?o;
		this.metodo = metodo;
	}

	public Pagamento(int cart?o, Metodo metodo) {
		super();
		this.cart?o = cart?o;
		this.metodo = metodo;
	}

	public Pagamento() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCart?o() {
		return cart?o;
	}

	public void setCart?o(int cart?o) {
		this.cart?o = cart?o;
	}

	public Metodo getMetodo() {
		return metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

}
