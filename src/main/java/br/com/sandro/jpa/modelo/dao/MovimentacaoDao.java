package br.com.sandro.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.sandro.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select new br.com.sandro.jpa.modelo.MediaComData (avg(m.valor), year(m.data), month(m.data), day(m.data)) from Movimentacao m group by  year(m.data), month(m.data), day(m.data)"; // média dos valores da tabela movimentação
		
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		return query.getResultList();

	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//String jpql = "select sum(m.valor) from Movimentacao m "; // somando os valores da tabela 
		String jpql = "select sum(m.valor) from Movimentacao m "; // média dos valores da tabela movimentação
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		return somaDasMovimentacoes;
	}
}
