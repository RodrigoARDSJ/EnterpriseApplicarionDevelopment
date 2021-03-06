package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTACIONAMENTO")
@SequenceGenerator(allocationSize = 1, name = "estacionamento", sequenceName = "SQ_TB_ESTACIONAMENTO")
public class Estacionamento {
	
	@Id
	@GeneratedValue(generator = "estacionamento", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_estacionamento", nullable = false)
	private int codigo;
	
	@Column(name = "nm_estacionamento", length = 40, nullable = false)
	private String nome;

	public Estacionamento(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Estacionamento(String nome) {
		super();
		this.nome = nome;
	}

	public Estacionamento() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
