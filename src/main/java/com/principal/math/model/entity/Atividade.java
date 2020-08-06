package com.principal.math.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, name = "titulo")
	private String titulo;

	@Column(nullable = false, name = "questao_1")
	private String questao1;

	@Column(nullable = false, name = "questao_2")
	private String questao2;

	@Column(nullable = false, name = "questao_3")
	private String questao3;

	@Column(nullable = false, name = "questao_4")
	private String questao4;

	@Column(nullable = false, name = "alternativa_correta")
	private Integer alternativaCorreta;

	@ManyToOne
	@JoinColumn(nullable = false, name = "modulo_id")
	private Modulo modulo;

	public Atividade() {

	}

	public Atividade(Integer id, 
			String titulo, 
			String questao1, 
			String questao2,
			String questao3, 
			String questao4, 
			Integer alternativaCorreta, 
			Modulo modulo
		) {
		this.id = id;
		this.titulo = titulo;
		this.questao1 = questao1;
		this.questao2 = questao2;
		this.questao3 = questao3;
		this.questao4 = questao4;
		this.alternativaCorreta = alternativaCorreta;
		this.modulo = modulo;
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

	public String getQuestao1() {
		return questao1;
	}

	public void setQuestao1(String questao1) {
		this.questao1 = questao1;
	}

	public String getQuestao2() {
		return questao2;
	}

	public void setQuestao2(String questao2) {
		this.questao2 = questao2;
	}

	public String getQuestao3() {
		return questao3;
	}

	public void setQuestao3(String questao3) {
		this.questao3 = questao3;
	}

	public String getQuestao4() {
		return questao4;
	}

	public void setQuestao4(String questao4) {
		this.questao4 = questao4;
	}

	public Integer getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(Integer alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}
