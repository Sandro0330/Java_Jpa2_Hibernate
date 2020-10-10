package br.com.sandro.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Alessandro");
		conta.setAgencia(123321);
		conta.setNumero(5423654);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Alterando de estado Transient pata Managed
		em.persist(conta);
		
		//Managed para Removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}

}
