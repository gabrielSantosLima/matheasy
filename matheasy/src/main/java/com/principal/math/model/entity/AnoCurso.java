package com.principal.math.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ano_curso")
public class AnoCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qtdeModulos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ano_id")
	private List<Modulo> modulos;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ano_id")
	private List<Aluno> alunos;

	public AnoCurso() {
		
	}
	
	public AnoCurso(Integer id, Integer qtdeModulos, List<Modulo> modulos, List<Aluno> alunos) {
		this.id = id;
		this.qtdeModulos = qtdeModulos;
		this.modulos = modulos;
		this.alunos = alunos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdeModulos() {
		return qtdeModulos;
	}

	public void setQtdeModulos(Integer qtdeModulos) {
		this.qtdeModulos = qtdeModulos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

}
