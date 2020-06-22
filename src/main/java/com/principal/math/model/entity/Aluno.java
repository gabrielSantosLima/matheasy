package com.principal.math.model.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.principal.math.model.entity.Usuario;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario {

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<BlocoDeNotas> blocos;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Evento> eventos;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Modulo> modulos;
	
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Mensagem> mensagens;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ListaContato", joinColumns = {
			@JoinColumn(name = "aluno_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "professor_id", referencedColumnName = "id") })
	private List<Professor> professores;

	@ManyToMany
	private Set<Role> roles; 
	
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

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public void adicionaBloco(BlocoDeNotas bloco) {
		this.getBlocos().add(bloco);
	}

	public void removeBloco(BlocoDeNotas bloco) {
		this.getBlocos().remove(bloco);
	}
}
