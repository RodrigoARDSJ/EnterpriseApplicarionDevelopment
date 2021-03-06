package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.dao.impl.VeiculoDaoImpl;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exeptions.CommitExeption;
import br.com.fiap.tds.exeptions.VeiculoNotFoundExeption;

public class VeiculoTeste {
	public static void main(String[] args) throws VeiculoNotFoundExeption {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDao dao = new VeiculoDaoImpl(em);
		
		Veiculo veiculo = new Veiculo("he234h37u", "Vermelho", 2020);
		
		try {
			dao.create(veiculo);
			dao.commit();
			System.out.println("Veiculo cadastrado!");
		} catch (CommitExeption e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.read(1);
			System.out.println(veiculo);
		} catch (VeiculoNotFoundExeption e) {
			System.out.println(e.getMessage());
		}
		
		try {
			veiculo = new Veiculo(1,"he234h37u", "Vermelho", 2020);
			dao.update(veiculo);
			dao.commit();
			System.out.println("Veiculo atualizado");
		} catch (CommitExeption e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Veiculo removido");
		} catch (VeiculoNotFoundExeption e) {
			System.out.println("Veiculo n?o foi removido");
		} catch (CommitExeption e) {
			System.out.println(e.getMessage());
		}
		
		
		fabrica.close();
		em.close();
	}

}
