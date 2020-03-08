package com.principal.math.model.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Formacao {

	@NotEmpty
	private String nome_formacao;
	
	@NotEmpty
	private String descricao_formacao;


	public String getNome() {
		return nome_formacao;
	}

	public void setNome(String nome) {
		this.nome_formacao = nome;
	}

	public String getDescricao_formacao() {
		return descricao_formacao;
	}

	public void setDescricao_formacao(String descricao_formacao) {
		this.descricao_formacao = descricao_formacao;
	}
}
