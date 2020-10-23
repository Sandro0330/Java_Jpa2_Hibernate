package br.com.sandro.jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.sandro.jpa.modelo.Movimentacao;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		// == select sum(m.valor);
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		
		System.out.println("A média das movimentações é: " + typedQuery.getSingleResult());
	}
}
