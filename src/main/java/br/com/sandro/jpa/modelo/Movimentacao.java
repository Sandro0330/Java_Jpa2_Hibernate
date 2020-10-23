package br.com.sandro.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQuery;

@NamedQuery(name="mediaDiariaMovimentacoes", 
query="select new br.com.sandro.jpa.modelo.MediaComData (avg(m.valor), year(m.data), month(m.data), day(m.data)) from Movimentacao m group by  year(m.data), month(m.data), day(m.data)") // média dos valores da tabela movimentação


@Entity
public class Movimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovitencao; // Chamando o metodo Enum com o parametro de Entrada,Saida
	private BigDecimal valor;
	private LocalDateTime data;
	private String descricao;

	@ManyToOne
	private Conta conta;
	@OneToMany
	private List<Categoria> categorias = new ArrayList<>();

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMovimentacao getTipoMovitencao() {
		return tipoMovitencao;
	}

	public void setTipoMovitencao(TipoMovimentacao tipoMovitencao) {
		this.tipoMovitencao = tipoMovitencao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}