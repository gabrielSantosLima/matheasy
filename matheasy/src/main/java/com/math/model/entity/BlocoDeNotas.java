package com.math.model.entity;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bloco_de_notas")
public class BlocoDeNotas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String texto;
	private String corHex;
	private Blob anexo;
	private Date dataAlarme;
	
	@ManyToOne(cascade = CascadeType.ALL)
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
