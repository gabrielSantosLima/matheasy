package com.principal.math.model.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "bloco_de_notas")
public class BlocoDeNotas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String titulo;

	private String texto;

	private String corHex;

	private Blob anexo;

	@Temporal(TemporalType.DATE)
	private Date dataAlarme;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public BlocoDeNotas() {
		
	}
	
	public BlocoDeNotas(Integer id, String titulo, String texto, String corHex, Blob anexo, Date dataAlarme,
			Aluno aluno) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.corHex = corHex;
		this.anexo = anexo;
		this.dataAlarme = dataAlarme;
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorHex() {
		return corHex;
	}

	public void setCorHex(String corHex) {
		this.corHex = corHex;
	}

	public Blob getAnexo() {
		return anexo;
	}

	public void setAnexo(Blob anexo) {
		this.anexo = anexo;
	}

	public Date getDataAlarme() {
		return dataAlarme;
	}

	public void setDataAlarme(Date dataAlarme) {
		this.dataAlarme = dataAlarme;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
