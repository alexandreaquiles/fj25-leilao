package br.com.caelum.leilao.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String email;

	private String nome;

	private String sobrenome;

	private Endereco endereco;

	private List<FormaDePagamento> formasDePagamento = new ArrayList<>();
	
	private List<Lance> lances = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<FormaDePagamento> getFormasDePagamento() {
		return formasDePagamento;
	}
	
	public void adicionaFormaDePagamento(FormaDePagamento forma) {
		this.formasDePagamento.add(forma);
	}

	public List<Lance> getLances() {
		return lances;
	}
	
	public void adicionaLance(Lance lance) {
		this.lances.add(lance);
	}

}
