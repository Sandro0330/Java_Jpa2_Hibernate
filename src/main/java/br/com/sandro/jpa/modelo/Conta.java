package br.com.sandro.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // mapea a entidade como uma tabela no banco de dados
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gera o auto_increment nos dados do ID
	private Long id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	private Double saldo;
	
	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER) // carregando antecipadamente a tabela 
	private List<Movimentacao> movimentacoes;
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
}
