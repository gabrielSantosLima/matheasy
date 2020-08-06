package com.principal.math.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Usuario implements IUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, length = 200)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	
	@Column(nullable = false, length = 20)
	private String username;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 8)
	private String password;

	@Column(nullable = false, length = 8)
	private String passwordConfirm;

	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nome, String username, String email,
			String password, String passwordConfirm, Date dataAniversario) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.dataAniversario = dataAniversario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
