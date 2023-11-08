package br.com.FintechProject.bean;

import java.util.Date;

public class ModelUsuario {
	private int id_usuario;
	private String nome;
	private String nr_cpf;
	private Date dt_nasc;
	private String tel_usuario;
	private String email_usuario;
	private String senha_usuario;
	private String url_foto;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNr_cpf() {
		return nr_cpf;
	}
	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public String getTel_usuario() {
		return tel_usuario;
	}
	public void setTel_usuario(String tel_usuario) {
		this.tel_usuario = tel_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getUrl_foto() {
		return url_foto;
	}
	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}
	
}
