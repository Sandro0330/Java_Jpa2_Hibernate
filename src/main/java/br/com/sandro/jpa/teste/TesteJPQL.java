package br.com.sandro.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sandro.jpa.modelo.Conta;
import br.com.sandro.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1L);
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		List<Movimentacao> resulList  = query.getResultList();
		
		for (Movimentacao movimentacao : resulList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo:" + movimentacao.getTipoMovitencao());
			
		}
	}
}
