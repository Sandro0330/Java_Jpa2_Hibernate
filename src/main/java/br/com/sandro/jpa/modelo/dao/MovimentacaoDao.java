package br.com.sandro.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sandro.jpa.modelo.MediaComData;
import br.com.sandro.jpa.modelo.Movimentacao;

public class MovimentacaoDao {
	private	EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Movimentacao> getMovimetacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {
		String sql = "select m from Movimentacao m ";
		
		
		if(dia != null) {
			sql = sql + " day(m.data) = :pDia";
		}
		
		if(dia != null) {
			sql = sql + "and month(m.data) = :pMes";
		}
		
		if(dia != null) {
			sql = sql + "and year(m.data) = :pAno";
		}
		
		
		
		return null;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {	
		
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		
		//String jpql = "select sum(m.valor) from Movimentacao m "; // somando os valores da tabela 
		String jpql = "select sum(m.valor) from Movimentacao m "; // média dos valores da tabela movimentação
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		return somaDasMovimentacoes;
	}
}
