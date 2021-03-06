package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exeptions.CommitExeption;
import br.com.fiap.tds.exeptions.VeiculoNotFoundExeption;

public class VeiculoDaoImpl implements VeiculoDao {

	private EntityManager em;

	public VeiculoDaoImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void create(Veiculo veiculo) {
		em.persist(veiculo);

	}

	@Override
	public Veiculo read(int codigo) throws VeiculoNotFoundExeption {
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		if (veiculo == null) {
			throw new VeiculoNotFoundExeption();
		}
		return veiculo;
	}

	@Override
	public void update(Veiculo veiculo) {
		em.merge(veiculo);

	}

	@Override
	public void delete(int codigo) throws VeiculoNotFoundExeption {
		Veiculo veiculo = read(codigo);
		em.remove(veiculo);
	}

	@Override
	public void commit() throws CommitExeption {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getStackTrace();
			em.getTransaction().rollback();
			throw new CommitExeption();
		}
	}

}
