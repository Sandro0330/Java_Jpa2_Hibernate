package br.com.sandro.jpa.teste;

import br.com.sandro.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		MovimentacaoDao dao = new MovimentacaoDao();
		
		//System.out.println("A soma das movimenta��es �: " + somaDasMovimentacoes);
		System.out.println("A m�dia das movimenta��es �: " + dao.getSomaDasMovimentacoes());
	}
}
