package br.com.sandro.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor), year(m.data), month(m.data), day(m.data) from Movimentacao m group by  year(m.data), month(m.data), day(m.data)"; // média dos valores da tabela movimentação
		
		Query query = em.createQuery(jpql);
		List<Object[]> mediaDiariaMovimentacoes = query.getResultList();
		
		for (Object[] resultado : mediaDiariaMovimentacoes) {
			
			System.out.println("A média das movimentações do dia  " + resultado[1] +  "/" + resultado[2] + "/" + resultado[3] + " é: " + resultado[0]);
		}
		
		

	}
}
