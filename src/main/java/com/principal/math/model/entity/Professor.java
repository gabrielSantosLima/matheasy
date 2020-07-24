package com.principal.math.model.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Usuario {

	@OneToMany(mappedBy= "professor")
	private List<ListaContato> listaContato;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private List<Mensagem> mensagens;
	
	@ManyToMany
	private Set<Role> roles; 
	
	@Embedded
	private Formacao formacao;
	
	public Professor() {
		
	}
	
	public Professor(Integer id, String nome, String username, String email,
			String password, String passwordConfirm, List<ListaContato> listaContato,
			List<Mensagem> mensagens, Set<Role> roles, Formacao formacao) {
		super(id, nome, username, email, password, passwordConfirm);
		this.listaContato = listaContato;
		this.mensagens = mensagens;
		this.roles = roles;
		this.formacao = formacao;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
}
