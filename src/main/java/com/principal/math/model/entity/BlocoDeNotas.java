package com.principal.math.model.entity;

//import java.sql.Blob;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "bloco_de_notas")
public class BlocoDeNotas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 30)
	private String titulo;

	@Lob
	@Column(nullable = false)
	private String texto;

//	@Column(nullable = false)
//	private String corHex;
//
//	private Blob anexo;
//
//	@Temporal(TemporalType.DATE)
//	private Date dataAlarme;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

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

//	public String getCorHex() {
//		return corHex;
//	}
//
//	public void setCorHex(String corHex) {
//		this.corHex = corHex;
//	}
//
//	public Blob getAnexo() {
//		return anexo;
//	}
//
//	public void setAnexo(Blob anexo) {
//		this.anexo = anexo;
//	}
//
//	public Date getDataAlarme() {
//		return dataAlarme;
//	}
//
//	public void setDataAlarme(Date dataAlarme) {
//		this.dataAlarme = dataAlarme;
//	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
