package br.com.fiap.tds.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	private EntityManager em;
	private Class<E> clazz;

	public GenericDaoImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void create(E entidade) {
		em.persist(entidade);

	}

	@Override
	public E read(K codigo) throws EntityNotFoundException {
		E entidade = em.find(clazz, codigo);
		if (entidade == null) {
			throw new EntityNotFoundException();
		}

		return entidade;
	}

	@Override
	public void update(E entidade) {
		em.merge(entidade);
	}

	@Override
	public void delete(K codigo) throws EntityNotFoundException {
		E entidade = read(codigo);
		em.remove(entidade);

	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}

	}

}
