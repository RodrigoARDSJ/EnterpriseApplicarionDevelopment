package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PROJETO_CHALLENGE")
@SequenceGenerator(allocationSize = 1, name = "projeto", sequenceName = "SQ_TB_PROJETO_CHALLENGE")
public class ProjetoChallenge {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proejeto")
	@Column(name = "cd_projeto", nullable = false)
	private int codigo;

	@Column(name = "nm_projeto", length = 80, nullable = false)
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_entrega", nullable = false)
	private Calendar dataEntrega;

	@Column(name = "vl_nota")
	private float nota;

	@Column(name = "ds_setor", length = 100)
	private String setor;

	@OneToOne
	@JoinColumn(name = "cd_grupo", nullable = false)
	private GrupoChallenge grupo;

	public ProjetoChallenge(int codigo, String nome, Calendar dataEntrega, float nota, String setor, GrupoChallenge grupo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataEntrega = dataEntrega;
		this.nota = nota;
		this.setor = setor;
		this.grupo = grupo;
	}

	public ProjetoChallenge(String nome, Calendar dataEntrega, float nota, String setor) {
		super();
		this.nome = nome;
		this.dataEntrega = dataEntrega;
		this.nota = nota;
		this.setor = setor;;
	}

	public ProjetoChallenge() {
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

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public GrupoChallenge getCodigoGrupo() {
		return grupo;
	}

	public void setCodigoGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

}