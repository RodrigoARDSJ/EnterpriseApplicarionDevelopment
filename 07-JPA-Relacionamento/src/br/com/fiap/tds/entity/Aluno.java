package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ALUNO")
@SequenceGenerator(allocationSize = 1, name = "aluno", sequenceName = "SQ_TB_ALUNO")
public class Aluno {
	
	@Id
	@GeneratedValue(generator = "aluno", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_aluno", nullable = false)
	private int codigo;
	
	@Column(name = "nm_aluno", nullable = false, length = 120)
	private String nome;
	
	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero", nullable = false, length = 20)
	private Genero genero;
	

	public Aluno(int codigo, String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Aluno(String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Aluno() {
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
