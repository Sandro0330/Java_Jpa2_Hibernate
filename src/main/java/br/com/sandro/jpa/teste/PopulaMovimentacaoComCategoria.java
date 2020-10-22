package br.com.sandro.jpa.teste;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandro.jpa.modelo.Categoria;
import br.com.sandro.jpa.modelo.Conta;
import br.com.sandro.jpa.modelo.Movimentacao;
import br.com.sandro.jpa.modelo.TipoMovimentacao;


public class PopulaMovimentacaoComCategoria {
	

		    public static void main(String[] args) {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
			EntityManager em = emf.createEntityManager();

	        Categoria categoria1 = new Categoria("Viagem");
	        Categoria categoria2 = new Categoria("Neg�cios");

	        Conta conta = new Conta();
	        conta.setTitular("Maria");
	        conta.setAgencia(98767);
	        conta.setNumero(14512);
	        conta.setSaldo(600.0);
	        
	        Conta conta2 = new Conta();
	        conta2.setTitular("Uilson");
	        conta2.setAgencia(65432);
	        conta2.setNumero(16987);
	        conta2.setSaldo(1200.0);

	        Movimentacao movimentacao1 = new Movimentacao();
	        movimentacao1.setData(LocalDateTime.now()); // hoje
	        movimentacao1.setDescricao("Viagem � SP");
	        movimentacao1.setTipoMovitencao(TipoMovimentacao.SAIDA);
	        movimentacao1.setValor(new BigDecimal(100.0));
	        movimentacao1.setCategorias(Arrays.asList(categoria1));

	        movimentacao1.setConta(conta2);

	        Movimentacao movimentacao2 = new Movimentacao();
	        movimentacao2.setData(LocalDateTime.now().plusDays(1)); // amanh�
	        movimentacao2.setDescricao("Viagem ao RJ");
	        movimentacao2.setTipoMovitencao(TipoMovimentacao.SAIDA);
	        movimentacao2.setValor(new BigDecimal(300.0));
	        movimentacao2.setCategorias(Arrays.asList(categoria2));

	        movimentacao2.setConta(conta2);
	        
	        em.getTransaction().begin();
	        
	        em.persist(categoria1); 
	        em.persist(categoria2); 

	        em.persist(conta);
	        em.persist(conta2);
	        
	        em.persist(movimentacao1);
	        em.persist(movimentacao2);
	       
	        em.getTransaction().commit();
	        em.close();

	    }
}

