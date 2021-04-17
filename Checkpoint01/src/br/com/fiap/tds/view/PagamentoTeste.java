package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Metodo;
import br.com.fiap.tds.entity.Pagamento;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PagamentoTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<Pagamento, Integer> dao = new GenericDaoImpl<Pagamento, Integer>(em) {
		};

		Pagamento pagamento = new Pagamento(1234545, Metodo.CREDITO);

		try {
			dao.create(pagamento);
			dao.commit();
			System.out.println("Metodo de pagamento cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

//		try {
//			pagamento = dao.read(1);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		fabrica.close();
		em.close();
	}

}
