package com.principal.math.model.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Formacao {

	private String nome_formacao;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome_formacao;
	}

	public void setNome(String nome) {
		this.nome_formacao = nome;
	}
}
