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
		conta.setTitular("Uilson");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(500.0);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.clear(); // A partir dessa linha a conta não é mais gerenciavel (Managed) 
							//ela se torna destacada (Detached)
		
		// Esse código torna a conta Managed novamente através do Merge
		EntityManager em2 = emf.createEntityManager();

		System.out.println("ID da conta do Uilson " + conta.getId());
		conta.setSaldo(1000.0);
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}
