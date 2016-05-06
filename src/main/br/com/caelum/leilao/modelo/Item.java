package br.com.caelum.leilao.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {

	private Integer id;

	private String nome;

	private BigDecimal precoInicial;

	private Leilao leilao;

	private List<String> categorias = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(BigDecimal precoInicial) {
		this.precoInicial = precoInicial;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

	public void aumentaPreco(BigDecimal aumento) {
		this.precoInicial = this.precoInicial.add(aumento);
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void adicionaCategoria(String categoria) {
		this.categorias.add(categoria);
	}

}
