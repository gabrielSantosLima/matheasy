package com.principal.math.model.entity;

import java.util.Set;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.principal.math.model.entity.Usuario;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario {

	@Column(nullable = false, name = "pontuacao")
	private Integer pontuacao;

	@OneToMany(mappedBy = "aluno")
	private List<BlocoDeNotas> blocos;

	@OneToMany(mappedBy = "aluno")
	private List<Evento> eventos;

	@OneToMany(mappedBy = "aluno")
	private List<Modulo> modulos;

	@OneToMany(mappedBy = "aluno")
	private List<Mensagem> mensagens;

	@OneToMany(mappedBy = "aluno")
	private List<ListaContato> listaContato;

	@ManyToMany
	private Set<Role> roles;

	public Aluno() {

	}

	public Aluno(Integer id, 
			String nome, 
			String username, 
			String email, 
			String password,
			String passwordConfirm, 
			Integer pontuacao, 
			List<BlocoDeNotas> blocos,
			List<Evento> eventos, 
			List<Modulo> modulos, 
			List<Mensagem> mensagens,
			List<ListaContato> listaContato, 
			Set<Role> roles
		) {
		super(id, nome, username, email, password, passwordConfirm);
		this.pontuacao = pontuacao;
		this.blocos = blocos;
		this.eventos = eventos;
		this.modulos = modulos;
		this.mensagens = mensagens;
		this.listaContato = listaContato;
		this.roles = roles;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<ListaContato> getListaContato() {
		return listaContato;
	}

	public void setListaContato(List<ListaContato> listaContato) {
		this.listaContato = listaContato;
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

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<BlocoDeNotas> getBlocos() {
		return blocos;
	}

	public void setBlocos(List<BlocoDeNotas> blocos) {
		this.blocos = blocos;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}
