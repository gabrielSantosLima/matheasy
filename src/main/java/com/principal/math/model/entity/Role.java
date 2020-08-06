package com.principal.math.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "role")
	private Set<Aluno> aluno;

	@OneToMany(mappedBy = "role")
	private Set<Professor> professor;
	
	public Role(String name){
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Aluno> getAluno() {
		return aluno;
	}
	
	public void setAluno(Set<Aluno> aluno) {
		this.aluno = aluno;
	}
	
	public Set<Professor> getProfessor() {
		return professor;
	}
	
	public void setProfessor(Set<Professor> professor) {
		this.professor = professor;
	}
}
