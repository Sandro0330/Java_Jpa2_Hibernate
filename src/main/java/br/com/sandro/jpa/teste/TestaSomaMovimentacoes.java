package br.com.sandro.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//String jpql = "select sum(m.valor) from Movimentacao m "; // somando os valores da tabela 
		String jpql = "select avg(m.valor) from Movimentacao m "; // m�dia dos valores da tabela movimenta��o
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double mediaDasMovimentacoes = query.getSingleResult();
		
		//System.out.println("A soma das movimenta��es �: " + somaDasMovimentacoes);
		System.out.println("A m�dia das movimenta��es �: " + mediaDasMovimentacoes);

		
	}
}
