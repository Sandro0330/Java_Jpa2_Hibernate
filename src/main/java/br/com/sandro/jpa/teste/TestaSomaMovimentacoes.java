package br.com.sandro.jpa.teste;

import br.com.sandro.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		MovimentacaoDao dao = new MovimentacaoDao();
		
		//System.out.println("A soma das movimentações é: " + somaDasMovimentacoes);
		System.out.println("A média das movimentações é: " + dao.getSomaDasMovimentacoes());
	}
}
