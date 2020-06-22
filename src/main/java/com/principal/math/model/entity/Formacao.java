package com.principal.math.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Formacao {

	@Column(nullable = false, length = 100)
	private String nome_formacao;

	public String getNome() {
		return nome_formacao;
	}

	public void setNome(String nome) {
		this.nome_formacao = nome;
	}
}
