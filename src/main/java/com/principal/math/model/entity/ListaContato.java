package com.principal.math.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "lista_contato")
public class ListaContato {
	
	@EmbeddedId
	private ChavePrimaria id;
	
	@ManyToOne
	@MapsId("professor_id")
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor;
	
	@ManyToOne
	@MapsId("aluno_id")
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;

	
	
	public ListaContato(Professor professor, Aluno aluno) {
		this.id = null;
		this.professor = professor;
		this.aluno = aluno;
	}

	public ChavePrimaria getId() {
		return id;
	}

	public void setId(ChavePrimaria id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}

@Embeddable
class ChavePrimaria implements Serializable{

	private static final long serialVersionUID = 7361062802965772769L;

	@Column(name = "professor_id")
	private Long professorId;

	@Column(name = "aluno_id")
	private Long alunoId;
}
