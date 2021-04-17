package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GRUPO_CHALLENGE")
@SequenceGenerator(allocationSize = 1, name = "grupo", sequenceName = "SQ_TB_GRUPO_CHALLENGE")
public class GrupoChallenge {

	@Id
	@Column(name = "cd_codigo", nullable = false)
	@GeneratedValue(generator = "grupo", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_grupo", nullable = false, length = 50)
	private String nome;
	
	@OneToOne(mappedBy = "grupo")
	private ProjetoChallenge projeto;

	public GrupoChallenge(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public GrupoChallenge(String nome) {
		super();
		this.nome = nome;
	}

	public GrupoChallenge() {
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