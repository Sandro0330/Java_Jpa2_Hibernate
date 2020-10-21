package br.com.sandro.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.Conta;
import br.com.sandro.jpa.modelo.Movimentacao;

public class TesteMovimentacaoConta {	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
		Conta contas = movimentacao.getConta();
		int quantidadeDeMovimentacoes = contas.getMovimentacoes().size();
		
		
		System.out.println("Quantidade de movimentações: " + quantidadeDeMovimentacoes);
		System.out.println("Titular da conta: " + contas.getTitular());
		
		
	}

}
