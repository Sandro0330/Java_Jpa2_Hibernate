package br.com.sandro.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.Cliente;
import br.com.sandro.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {
	
	public static void main(String[] args) {
		 
		Conta conta = new Conta();
		 conta.setId(5L);
		 
		 Cliente cliente = new Cliente();
		 cliente.setNome("Josefa");
		 cliente.setEndereco("Rua General Molina, 1245");
		 cliente.setProfissao("Aux de Nutrição");
		 cliente.setConta(conta);
		 
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		 EntityManager em = emf.createEntityManager();
		 
		 em.getTransaction().begin();
		 
		 em.persist(cliente);
		 	 
		 em.getTransaction().commit();
		 em.close();
		 
	}

}
