package br.com.FintechProject.bean;

import java.time.LocalDate;
import java.util.Calendar;

public class ModelRendimento extends ModelMovimentacaoFinanceira{
	private int id_rendimento;
	private double rendimento_anual;
	private LocalDate dt_rendimento;
	private int id_usuario;
	
	public ModelRendimento() {
		
	}
	

	public ModelRendimento(int id_rendimento,LocalDate dt_rendimento,  double rendimento_anual,double valor,String descricao,String tx_titulo,String tipo, int id_usuario) {
		super();
		this.id_rendimento = id_rendimento;
		this.rendimento_anual = rendimento_anual;
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setTx_titulo(tx_titulo);
		this.setTipo(tipo);
		this.id_usuario = id_usuario;
		this.dt_rendimento = dt_rendimento;
	}
	public ModelRendimento(LocalDate dt_rendimento,  double rendimento_anual,double valor,String descricao,String tx_titulo,String tipo, int id_usuario) {
		super();

		this.rendimento_anual = rendimento_anual;
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setTx_titulo(tx_titulo);
		this.setTipo(tipo);
		this.id_usuario = id_usuario;
		this.dt_rendimento = dt_rendimento;
	}

	public int getId_rendimento() {
		return id_rendimento;
	}
	
	public void setId_rendimento(int id_rendimento) {
		this.id_rendimento = id_rendimento;
	}
	public LocalDate getDt_rendimento() {
		return dt_rendimento;
	}

	public void setDt_rendimento(LocalDate dt_rendimento) {
		this.dt_rendimento = dt_rendimento;
	}
	
	public double getRendimento_anual() {
		return rendimento_anual;
	}
	
	public void setRendimento_anual(double rendimento_anual) {
		this.rendimento_anual = rendimento_anual;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
	@Override
    public String toString() {
        return "Rendimento [id_rendimento=" + id_rendimento  + ", rendimento_anual=" + rendimento_anual + ", id_usuario=" + id_usuario + "]";
    }
	
}

