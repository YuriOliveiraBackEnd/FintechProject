package br.com.FintechProject.bean;

import java.io.Serializable;

public class ModelMovimentacaoFinanceira implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id_movimentacaoFinanceira;
	private double valor;
	private String descricao;
	private String tx_titulo;
	private String tipo;
	
	public ModelMovimentacaoFinanceira() {
		
	}
	
	public ModelMovimentacaoFinanceira(int id_movimentacaoFinanceira, double valor, String descricao, String tx_titulo,
			String tipo) {
		super();
		this.id_movimentacaoFinanceira = id_movimentacaoFinanceira;
		this.valor = valor;
		this.descricao = descricao;
		this.tx_titulo = tx_titulo;
		this.tipo = tipo;
	}
	
	public int getId_movimentacaoFinanceira() {
		return id_movimentacaoFinanceira;
	}
	public void setId_movimentacaoFinanceira(int id_movimentacaoFinanceira) {
		this.id_movimentacaoFinanceira = id_movimentacaoFinanceira;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTx_titulo() {
		return tx_titulo;
	}
	public void setTx_titulo(String tx_titulo) {
		this.tx_titulo = tx_titulo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}

