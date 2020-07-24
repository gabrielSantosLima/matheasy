package com.principal.math.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "chave", nullable = false)
	private String key;
	
	@Column(name = "titulo", nullable = false)
	private String title;

	@Column(name = "dataInicio", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar start;

	@Column(name = "dataFim", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar end;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public Evento() {
		
	}
	
	public Evento(Integer id, String key, String title, Calendar start, Calendar end,
			Aluno aluno) {
		this.id = id;
		this.key = key;
		this.title = title;
		this.start = start;
		this.end = end;
		this.aluno = aluno;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}