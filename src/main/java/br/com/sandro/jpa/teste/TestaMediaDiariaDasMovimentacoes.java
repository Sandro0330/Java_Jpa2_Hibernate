package br.com.sandro.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.sandro.jpa.modelo.MediaComData;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select new br.com.sandro.jpa.modelo.MediaComData (avg(m.valor), year(m.data), month(m.data), day(m.data)) from Movimentacao m group by  year(m.data), month(m.data), day(m.data)"; // média dos valores da tabela movimentação
		
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		List<MediaComData> mediaDiariaMovimentacoes = query.getResultList();
		
		for (MediaComData resultado : mediaDiariaMovimentacoes) {
			
			System.out.println("A média das movimentações do dia  " + resultado.getDia() +  "/" + resultado.getMes() + "/" + resultado.getAno() + " é: " + resultado.getValor());
		}
		
		

	}
}
