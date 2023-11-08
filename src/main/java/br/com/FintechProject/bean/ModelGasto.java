package br.com.FintechProject.bean;


import java.time.LocalDate;

public class ModelGasto extends ModelMovimentacaoFinanceira {
	private int id_gasto;
	private int nr_parcelas;
	private LocalDate dt_gasto;
	private int id_cartao;
	private int id_usuario;
	
	

	public ModelGasto() {
		
	}


	public ModelGasto(int id_gasto, int nr_parcelas, LocalDate dt_gasto,double valor,String descricao,String tx_titulo,String tipo, int id_cartao, int id_usuario) {
		super();
		this.id_gasto = id_gasto;
		this.nr_parcelas = nr_parcelas;
		this.dt_gasto = dt_gasto;
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setTx_titulo(tx_titulo);
		this.setTipo(tipo);
		this.id_cartao = id_cartao;
		this.id_usuario = id_usuario;
	}


	public int getId_gasto() {
		return id_gasto;
	}
	
	public void setId_gasto(int id_gasto) {
		this.id_gasto = id_gasto;
	}
	
	public int getNr_parcelas() {
		return nr_parcelas;
	}
	
	public void setNr_parcelas(int nr_parcelas) {
		this.nr_parcelas = nr_parcelas;
	}
	
	public int getId_cartao() {
		return id_cartao;
	}
	
	public void setId_cartao(int id_cartao) {
		this.id_cartao = id_cartao;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	

	public LocalDate getDt_gasto() {
		return dt_gasto;
	}

	public void setDt_gasto(LocalDate dt_gasto) {
		this.dt_gasto = dt_gasto;
	}
	
}
