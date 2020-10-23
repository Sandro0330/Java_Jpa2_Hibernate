package br.com.sandro.jpa.teste;

import java.util.List;

import br.com.sandro.jpa.modelo.MediaComData;
import br.com.sandro.jpa.modelo.dao.MovimentacaoDao;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao().getMediaDiariaDasMovimentacoes();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {
			
			System.out.println("A média das movimentações do dia  " + resultado.getDia() +  "/" + resultado.getMes() + "/" + resultado.getAno() + " é: " + resultado.getValor());
		}		 
	}
}
