package br.com.FintechProject.bean;

import java.time.LocalDate;
import java.util.Date;
import br.com.FintechProject.util.CriptografiaUtils;
public class ModelUsuario {
	private int id_usuario;
	private String nome;
	private String nr_cpf;
	private LocalDate dt_nasc;
	private String tel_usuario;
	private String email_usuario;
	private String senha_usuario;
	private String url_foto;
	
	
	public ModelUsuario( String nome, String nr_cpf, String tel_usuario ,String email_usuario,
			 String senha_usuario, LocalDate dt_nasc) {
		super();
		this.nome = nome;
		this.nr_cpf = nr_cpf;
		this.dt_nasc = dt_nasc;
		this.tel_usuario = tel_usuario;
		this.email_usuario = email_usuario;
		this.senha_usuario = senha_usuario;
	}
	public ModelUsuario( String email_usuario,
			 String senha_usuario) {
		super();
		this.email_usuario = email_usuario;
		this.senha_usuario = senha_usuario;
	}
	public ModelUsuario( String nome) {
		super();
		this.nome = nome;
		
	}
	


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
	public LocalDate getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(LocalDate dt_nasc) {
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
		try {
		this.senha_usuario = CriptografiaUtils.criptografar(senha_usuario);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getUrl_foto() {
		return url_foto;
	}
	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}
	
}
