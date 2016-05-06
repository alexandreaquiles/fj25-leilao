package br.com.caelum.leilao.modelo;

public class CartaoDeCredito extends FormaDePagamento {

	private String numero;
	private Integer mesExpiracao;
	private Integer anoExpiracao;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getMesExpiracao() {
		return mesExpiracao;
	}

	public void setMesExpiracao(Integer mesExpiracao) {
		this.mesExpiracao = mesExpiracao;
	}

	public Integer getAnoExpiracao() {
		return anoExpiracao;
	}

	public void setAnoExpiracao(Integer anoExpiracao) {
		this.anoExpiracao = anoExpiracao;
	}

}
