package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CASO_TESTE")
@SequenceGenerator(allocationSize = 1, name = "casoTeste", sequenceName = "SQ_TB_CASO_TESTE")
public class CasoTeste {

	@Id
	@GeneratedValue(generator = "casoTeste", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_caso_teste", nullable = false)
	private int codigo;

	@Column(name = "nm_caso_teste")
	private String nome;

	@Column(name = "ds_caso_teste")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cd_sistema")
	private Sistema sistema;

	@OneToMany(mappedBy = "casoTeste")
	private List<ItemTeste> itensTeste;

	public void addItemTeste(ItemTeste item) {
		if (itensTeste == null)
			itensTeste = new ArrayList<>();
		item.setCasoTeste(this);
		itensTeste.add(item);
	}

	public CasoTeste() {

	}

	public CasoTeste(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;

	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<ItemTeste> getItensTeste() {
		return itensTeste;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itensTeste = itensTeste;
	}

}
