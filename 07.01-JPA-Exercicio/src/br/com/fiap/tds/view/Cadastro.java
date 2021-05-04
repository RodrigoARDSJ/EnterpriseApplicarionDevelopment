package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	public static void main(String[] args) {
		//Instanciar um sistema com nome
		Sistema sistema = new Sistema("Vendas online");
	
		//Instanciar 2 casos de teste com o nome e descrição
		CasoTeste caso1 = new CasoTeste("Vendas", "Realização de vendas");
		CasoTeste caso2 = new CasoTeste("Troca", "Realização de troca de vendas");
		
		//Adicionar os casos de teste no sistema 
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);
		//Instanciar 3 itens de teste com  a descrição 
		ItemTeste item1 = new ItemTeste("Venda com sucesso atraves de cartão de crédito");
		ItemTeste item2 = new ItemTeste("Venda com sucesso atraves de boletos");
		ItemTeste item3 = new ItemTeste("Venda com sucesso para troca");
		
		//Adicionar 2 itens no primeiro caso e 1 item no segundo
		Usuario usuario1 = new Usuario("Rodrigo");
		Usuario usuario2 = new Usuario("Gabriel");
		//Criar uma lista de usuario e adiciona-lo na lista
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		//Setar a lsista de usuario em 2 itens de teste 
		item1.setUsuario(usuarios);
		item3.setUsuario(usuarios);
		//Instanciar um EntittyManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		//INstanciar um SistemaDao
		SistemaDaoImpl dao = new SistemaDaoImpl(em);
		
		//commit
		try {
			dao.create(sistema);
			dao.commit();
			System.out.println("Deu Bom");
		} catch (CommitException e){
			System.out.println("Deu ruim");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
		
		
	}

}
