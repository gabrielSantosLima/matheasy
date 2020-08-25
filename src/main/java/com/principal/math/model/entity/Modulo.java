package com.principal.math.model.entity;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.principal.math.enums.AnoCurso;

@Entity
@Table(name = "modulo")
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String titulo;

	@Lob
	@Column(nullable = false)
	private String subconteudos;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AnoCurso ano;

	@Column(nullable = false)
	private String sigla;
	
	@OneToMany
	private List<EstadoEstudo> estados;

	@OneToMany
	private List<Atividade> atividades;

	public Modulo() {
		
	}

	public Modulo(Integer id, String titulo, String subconteudos,AnoCurso ano, List<EstadoEstudo> estados, List<Atividade> atividades, String sigla) {
		this.id = id;
		this.titulo = titulo;
		this.subconteudos = subconteudos;
		this.ano = ano;
		this.estados = estados;
		this.atividades = atividades;
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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

	public String getSubconteudos() {
		return subconteudos;
	}

	public void setSubconteudos(String subconteudos) {
		this.subconteudos = subconteudos;
	}

	public AnoCurso getAno() {
		return ano;
	}

	public void setAno(AnoCurso ano) {
		this.ano = ano;
	}

	public List<EstadoEstudo> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoEstudo> estados) {
		this.estados = estados;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
}