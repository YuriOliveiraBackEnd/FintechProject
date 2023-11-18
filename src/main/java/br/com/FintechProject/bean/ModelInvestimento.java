package br.com.FintechProject.bean;

import java.time.LocalDate;
import java.util.Calendar;

public class ModelInvestimento extends ModelMovimentacaoFinanceira {
	private int id_investimento;
	private LocalDate dt_investimento;
	private int id_usuario;
	
	private String dataformatada;
	public String getDataformatada() {
		return dataformatada;
	}


	public void setDataformatada(String dataformatada) {
		this.dataformatada = dataformatada;
	}
	
	
	public ModelInvestimento() {
		super();
	}
	public ModelInvestimento(int id_investimento, LocalDate dt_investimento,double valor,String descricao,String tx_titulo,String tipo, int id_usuario) {
		super();
		this.id_investimento = id_investimento;
		this.dt_investimento = dt_investimento;
		this.id_usuario = id_usuario;
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setTx_titulo(tx_titulo);
		this.setTipo(tipo);
	}
	public ModelInvestimento( LocalDate dt_investimento,double valor,String descricao,String tx_titulo,String tipo, int id_usuario) {
		super();
		
		this.dt_investimento = dt_investimento;
		this.id_usuario = id_usuario;
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setTx_titulo(tx_titulo);
		this.setTipo(tipo);
	}
	public ModelInvestimento( int id_investimento,String dataformatada,double valor,String descricao,String tx_titulo,String tipo, int id_usuario) {
		super();
		
		this.dataformatada = dataformatada;
		this.id_usuario = id_usuario;
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setTx_titulo(tx_titulo);
		this.setTipo(tipo);
	}
	public int getId_investimento() {
		return id_investimento;
	}
	public void setId_investimento(int id_investimento) {
		this.id_investimento = id_investimento;
	}
	public LocalDate getDt_investimento() {
		return dt_investimento;
	}
	public void setDt_investimento(LocalDate dt_investimento) {
		this.dt_investimento = dt_investimento;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
}
