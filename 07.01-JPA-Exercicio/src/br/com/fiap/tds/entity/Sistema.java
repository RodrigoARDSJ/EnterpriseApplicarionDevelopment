package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SISTEMA")
@SequenceGenerator(allocationSize = 1, name = "sistema", sequenceName = "SQ_TAB_SISTEMA")
public class Sistema {
	@Id
	@GeneratedValue(generator = "sistema", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_sistema", nullable = false)
	private int codigo;
	
	@Column(name = "nm_sistema")
	private String nome;
	
	@OneToMany(mappedBy = "sistema", cascade = CascadeType.ALL)
	private List<CasoTeste> casosTeste;

	public void addCasoTeste(CasoTeste caso) {
		if (casosTeste == null)
			casosTeste = new ArrayList<>();
		
		casosTeste.add(caso);
		caso.setSistema(this);
	}
	
	
	
	public List<CasoTeste> getCasosTeste() {
		return casosTeste;
	}
	
	public Sistema() {
		
	}
	
	public Sistema(String nome) {
		this.nome = nome;
	}

	public void setCasosTeste(List<CasoTeste> casosTeste) {
		this.casosTeste = casosTeste;
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
