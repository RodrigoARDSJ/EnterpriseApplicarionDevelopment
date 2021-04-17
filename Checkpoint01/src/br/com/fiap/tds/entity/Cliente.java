package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(allocationSize = 1, name = "cliente", sequenceName = "SQ_TB_CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cleinte")
	@Column(name = "cd_cliente", nullable = false)
	@ManyToOne
	private int codigo;

	@Column(name = "nm_cliente", nullable = false, length = 60)
	private String nome;

	@Column(name = "nr_cnh", nullable = false, length = 30)
	private String cnh;

	@Column(name = "ds_email", nullable = false, length = 50)
	private String email;

	@Column(name = "ds_senha", nullable = false, length = 60)
	private String senha;

	public Cliente() {

	}

	public Cliente(int codigo, String nome, String cnh, String email, String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnh = cnh;
		this.email = email;
		this.senha = senha;
	}

	public Cliente(String nome, String cnh, String email, String senha) {
		super();
		this.nome = nome;
		this.cnh = cnh;
		this.email = email;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nCNH: " + cnh + "\nEmail: " + email + "\nSenha: " + senha;
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

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
