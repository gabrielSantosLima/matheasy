package com.math.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String usuario;
	private String email;
	private String senha;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private List<BlocoDeNotas> blocos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ListaContato", 
	joinColumns = {@JoinColumn(name = "aluno_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "professor_id",referencedColumnName = "id")}) 
	private List<Professor> professores;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private List<Mensagem> mensagens;
	
	@ManyToOne
	private AnoCurso ano;
	

	public AnoCurso getAno() {
		return ano;
	}

	public void setAno(AnoCurso ano) {
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public List<BlocoDeNotas> getBlocos() {
		return blocos;
	}

	public void setBlocos(List<BlocoDeNotas> blocos) {
		this.blocos = blocos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
