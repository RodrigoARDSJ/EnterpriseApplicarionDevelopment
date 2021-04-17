package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VAGAS")
@SequenceGenerator(allocationSize = 1, name = "vagas", sequenceName = "SQ_TB_VAGAS")
public class Vaga {
	@Id
	@GeneratedValue(generator = "vagas", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_vagas", nullable = false)
	private int codigo;
	
	@Column(name = "cd_estacionamento", nullable = false)
	private Estacionamento codigoEstacionamento;
	
	@Column(name = "ds_localizacao", length = 15, nullable = false)
	private String localizacao;
	
	@Column(name = "ds_andar", length = 15, nullable = false)
	private String andar;
	
	@Column(name = "ds_disponivel", nullable = false)
	private boolean disponivel;
	

}
