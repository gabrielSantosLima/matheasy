package com.principal.math.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.principal.math.enums.AnoCurso;

@Entity
@Table(name = "modulo")
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 30)
	private String titulo;

	@Lob
	@Column(nullable = false)
	private String conteudo;

	@Column(nullable = true, name = "concluido")
	private Boolean concluido;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AnoCurso ano;

	@ManyToOne
	@JoinColumn(nullable = false, name = "aluno_id")
	private Aluno aluno;
	
	@OneToMany(mappedBy = "modulo")
	private List<Atividade> atividades;

	public Modulo() {
		
	}
	
	public Modulo(Integer id, 
			String titulo, 
			String conteudo, 
			Date dataFinalizado,
			AnoCurso ano, 
			Aluno aluno,
			Boolean concluido
		) {
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.ano = ano;
		this.aluno = aluno;
		this.concluido = concluido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public AnoCurso getAno() {
		return ano;
	}

	public Boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public void setAno(AnoCurso ano) {
		this.ano = ano;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}