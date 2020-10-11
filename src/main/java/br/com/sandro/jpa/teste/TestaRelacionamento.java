package br.com.sandro.jpa.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.Conta;
import br.com.sandro.jpa.modelo.Movimentacao;
import br.com.sandro.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia(12345);
		conta.setNumero(234554);
		conta.setSaldo(300.0);
		conta.setTitular("Alessandro");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovitencao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta); 
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.clear();
	}
	
}
