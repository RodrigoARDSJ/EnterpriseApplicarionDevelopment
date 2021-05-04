package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(allocationSize = 1, name = "usuario", sequenceName = "SQ_TB_USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_usuario")
	private int codigo;

	@Column(name = "nm_usuario")
	private String nome;

	@ManyToMany(mappedBy = "usuarios")
	private List<ItemTeste> itensTeste;

	public List<ItemTeste> getItensTeste() {
		return itensTeste;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itensTeste = itensTeste;
	}

	public Usuario() {
		super();
	}

	public Usuario(String nome) {
		super();
		this.nome = nome;
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
