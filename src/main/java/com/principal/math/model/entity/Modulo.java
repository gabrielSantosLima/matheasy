package com.principal.math.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.principal.math.enums.AnoCurso;

@Entity
@Table(name = "modulo")
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 30)
	private String titulo;

	@Column(nullable = false)
	private String conteudo;

	@Temporal(TemporalType.DATE)
	private Date dataFinalizado;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AnoCurso ano;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public Modulo() {
		
	}
	
	public Modulo(Integer id, String titulo, String conteudo, Date dataFinalizado,
			AnoCurso ano, Aluno aluno) {
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataFinalizado = dataFinalizado;
		this.ano = ano;
		this.aluno = aluno;
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

	public Date getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(Date dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}

	public AnoCurso getAno() {
		return ano;
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