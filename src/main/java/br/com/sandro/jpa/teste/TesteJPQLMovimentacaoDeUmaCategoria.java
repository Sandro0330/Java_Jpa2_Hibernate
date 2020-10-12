package br.com.sandro.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.sandro.jpa.modelo.Categoria;
import br.com.sandro.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Categoria categoria = new Categoria();
		categoria.setId(16L);
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> movimentacoes  = query.getResultList();
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Categorias " + movimentacao.getCategorias());
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo:" + movimentacao.getTipoMovitencao());
	
		}
		
	}	
}
