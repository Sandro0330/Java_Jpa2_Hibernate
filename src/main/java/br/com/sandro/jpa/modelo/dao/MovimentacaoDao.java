package br.com.sandro.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sandro.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	private	EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {	
		
		String jpql = "select new br.com.sandro.jpa.modelo.MediaComData (avg(m.valor), year(m.data), month(m.data), day(m.data)) from Movimentacao m group by  year(m.data), month(m.data), day(m.data)"; // m�dia dos valores da tabela movimenta��o
		
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		
		//String jpql = "select sum(m.valor) from Movimentacao m "; // somando os valores da tabela 
		String jpql = "select sum(m.valor) from Movimentacao m "; // m�dia dos valores da tabela movimenta��o
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		return somaDasMovimentacoes;
	}
}
