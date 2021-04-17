package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {
	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		GrupoChallengeDao daoGrupo = new GrupoChallengeImpl(em);
		ProjetoChallengeDao daoProjeto = new ProjetoChallengeDaoImpl(em);

		GrupoChallenge grupoChallenge = new GrupoChallenge("CONNECTALL");
		ProjetoChallenge ProjetoChallenge = new ProjetoChallenge("DISRUPT",
				new GregorianCalendar(2021, Calendar.AUGUST, 9), 0,"TI");
		
		daoGrupo.create(grupoChallenge);
		daoProjeto.create(ProjetoChallenge);
		
		try {
			daoProjeto.commit();
			System.out.println("Grupo e Projeto Criado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
