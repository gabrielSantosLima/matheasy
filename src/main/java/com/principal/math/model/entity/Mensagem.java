package com.principal.math.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mensagem")
public class Mensagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Lob
	@Column(nullable = false, name = "mensagem")
	private String mensagem;

	@Column(nullable = false, name = "data")
	private String data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id")
	private Usuario usuario1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professor_id")
	private Usuario usuario2;
	
	public Mensagem() {
		
	}
	
	public Mensagem(String mensagem, String data, Usuario usuario1, Usuario usuario2) {
		this.id = null;
		this.mensagem = mensagem;
		this.data = data;
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}
}