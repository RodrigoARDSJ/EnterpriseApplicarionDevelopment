package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_TESTE")
@SequenceGenerator(allocationSize = 1, name = "item", sequenceName = "SQ_TB_ITEM_TESTE")
public class ItemTeste {

	@Id
	@GeneratedValue(generator = "item", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_item_item_teste", nullable = false)
	private int codigo;

	@Column(name = "ds_item_teste")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cd_caso_teste")
	private CasoTeste casoTeste;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_ITEEM_TESTE_USUARIO", joinColumns = @JoinColumn(name = "cd_item_teste"), inverseJoinColumns = @JoinColumn(name = "cd_usuario"))
	private List<Usuario> usuarios;

	public List<Usuario> getUsuario() {
		return usuarios;
	}

	public ItemTeste() {
	}

	public ItemTeste(String descricao) {
		super();
		this.descricao = descricao;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuarios = usuario;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
