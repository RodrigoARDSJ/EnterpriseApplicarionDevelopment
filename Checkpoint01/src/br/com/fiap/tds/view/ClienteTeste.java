package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class ClienteTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<Cliente, Integer> dao = new GenericDaoImpl<Cliente, Integer>(em) {
		};

		Cliente cliente = new Cliente("Bruno", "145246525435", "brunocovasrei", "1234covasvai");

		try {
			dao.create(cliente);
			dao.commit();
			System.out.println("\nCliente cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			cliente = dao.read(1);
			System.out.println("\n" + cliente);
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		cliente = new Cliente(1, "João", "7895421", "joaodoria", "joao123");
		try {
			cliente = dao.read(1);
			dao.update(cliente);
			dao.commit();
			System.out.println("\nCliente Atualizado");
			System.out.println(cliente);
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dao.delete(1);
			dao.commit();
			System.out.println("\nCliente apagado");
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

	}

}
