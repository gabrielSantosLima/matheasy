package com.principal.math.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.principal.math.model.entity.Usuario;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario{

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
