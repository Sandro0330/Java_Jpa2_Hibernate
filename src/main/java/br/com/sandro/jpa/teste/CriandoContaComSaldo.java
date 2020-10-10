package br.com.sandro.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.Conta;

public class CriandoContaComSaldo {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Regina");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(500.0);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
	}
}
