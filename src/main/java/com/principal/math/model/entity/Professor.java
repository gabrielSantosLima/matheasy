package com.principal.math.model.entity;


import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Usuario implements IUsuario{

	@OneToMany(mappedBy = "professor")
	private List<ListaContato> listaContato;
	
	@OneToMany(mappedBy = "professor")
	private List<Mensagem> mensagens;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "role_id")
	private Role role; 
	
	@Column(nullable = false)
	private String descricao;
	
	public Professor() {
		
	}
	
	public Professor(Integer id, 
			String nome, 
			String username, 
			String email,
			String password, 
			String passwordConfirm, 
			List<ListaContato> listaContato,
			List<Mensagem> mensagens, 
			Role role, 
			String descricao, 
			Date dataAniversario
		) {
		
		super(id, nome, username, email, password, passwordConfirm, dataAniversario);
		this.listaContato = listaContato;
		this.mensagens = mensagens;
		this.role = role;
		this.descricao = descricao;
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
