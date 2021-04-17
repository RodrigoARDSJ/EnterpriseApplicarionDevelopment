package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NANO_COURSE")
@SequenceGenerator(allocationSize = 1, name = "nano", sequenceName = "SQ_TB_NANO_COURSE")
public class NanoCourse {
	
	@Id
	@GeneratedValue(generator = "nano", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_nano_course", nullable = false)
	private int codigo;
	
	@Column(name = "nm_nano_course", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "nr_creditos", nullable = false)
	private int creditos;
	
	@Column(name = "ds_nivel", length = 20)
	private Nivel nivel;

	public NanoCourse(int codigo, String nome, int creditos, Nivel nivel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.creditos = creditos;
		this.nivel = nivel;
	}

	public NanoCourse(String nome, int creditos, Nivel nivel) {
		super();
		this.nome = nome;
		this.creditos = creditos;
		this.nivel = nivel;
	}

	public NanoCourse() {
		super();
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

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

}
