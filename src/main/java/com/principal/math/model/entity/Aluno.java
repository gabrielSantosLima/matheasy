package com.principal.math.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario implements IUsuario{

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

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

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
			Role role,
			Date dataAniversario
		) {
		super(id, nome, username, email, password, passwordConfirm, dataAniversario);
		this.pontuacao = pontuacao;
		this.blocos = blocos;
		this.eventos = eventos;
		this.modulos = modulos;
		this.mensagens = mensagens;
		this.listaContato = listaContato;
		this.role = role;
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
