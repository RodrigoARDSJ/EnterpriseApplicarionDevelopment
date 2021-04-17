package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public interface GenericDao<E, K> {
	void create(E entidade);

	E read(K codigo)throws EntityNotFoundException;

	void update(E entidade);

	void delete(K codigo)throws EntityNotFoundException;
	
	void commit()throws CommitException;

}
