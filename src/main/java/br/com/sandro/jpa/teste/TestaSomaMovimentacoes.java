package br.com.sandro.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		//System.out.println("A soma das movimentações é: " + somaDasMovimentacoes);
		System.out.println("A média das movimentações é: " + dao.getSomaDasMovimentacoes());
	}
}
