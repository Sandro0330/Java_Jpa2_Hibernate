package br.com.sandro.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.Conta;

public class AlteraSaldoConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoSandro = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		contaDoSandro.setSaldo(20.0);
		em.getTransaction().commit();
	}	
}
