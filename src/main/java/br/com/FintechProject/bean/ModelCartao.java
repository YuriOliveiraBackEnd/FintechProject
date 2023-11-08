package br.com.FintechProject.bean;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public class ModelCartao {
  private int id_cartao;
  private String nr_cartao;
  private String dt_validade;
  private String nm_pessoa;
  private String cv_cartao;
  private String nm_bandeira;
  private String nm_banco;
  private int id_usuario;

  
  
  
  public ModelCartao() {
	super();
}

public ModelCartao(int id_cartao,String nr_cartao, String dt_validade, String nm_pessoa, String cv_cartao, String nm_bandeira,
		String nm_banco, int id_usuario) {
	super();
	
	this.id_cartao= id_cartao;
	this.nr_cartao = nr_cartao;
	this.dt_validade = dt_validade;
	this.nm_pessoa = nm_pessoa;
	this.cv_cartao = cv_cartao;
	this.nm_bandeira = nm_bandeira;
	this.nm_banco = nm_banco;
	this.id_usuario = id_usuario;
}

public int getId_cartao() {
	return id_cartao;
}
public void setId_cartao(int id_cartao) {
	this.id_cartao = id_cartao;
}
public String getNr_cartao() {
	return nr_cartao;
}
public void setNr_cartao(String nr_cartao) {
	this.nr_cartao = nr_cartao;
}
public String getDt_validade() {
	return dt_validade;
}
public void setDt_validade(String dt_validade) {
	this.dt_validade = dt_validade;
}
public String getNm_pessoa() {
	return nm_pessoa;
}
public void setNm_pessoa(String nm_pessoa) {
	this.nm_pessoa = nm_pessoa;
}
public String getCv_cartao() {
	return cv_cartao;
}
public void setCv_cartao(String cv_cartao) {
	this.cv_cartao = cv_cartao;
}
public String getNm_bandeira() {
	return nm_bandeira;
}
public void setNm_bandeira(String nm_bandeira) {
	this.nm_bandeira = nm_bandeira;
}
public String getNm_banco() {
	return nm_banco;
}
public void setNm_banco(String nm_banco) {
	this.nm_banco = nm_banco;
}
public int getId_usuario() {
	return id_usuario;
}
public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
} 


}
