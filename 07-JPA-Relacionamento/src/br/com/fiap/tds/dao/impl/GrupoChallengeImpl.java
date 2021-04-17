package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.entity.GrupoChallenge;

public class GrupoChallengeImpl extends GenericDaoImpl<GrupoChallenge, Integer> implements GrupoChallengeDao{

	public GrupoChallengeImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
