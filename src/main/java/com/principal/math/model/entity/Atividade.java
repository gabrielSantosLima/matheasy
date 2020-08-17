package com.principal.math.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	@Column(nullable = false, name = "pergunta")
	private String answer;

	@Column(nullable = false, name = "questao_1")
	private String questao1;

	@Column(nullable = false, name = "questao_2")
	private String questao2;

	@Column(nullable = false, name = "questao_3")
	private String questao3;

	@Column(nullable = false, name = "questao_4")
	private String questao4;

	@Column(nullable = false, name = "questao_5")
	private String questao5;

	@Column(nullable = false, name = "ponto")
	private Integer pointByQuestion;

	@Column(nullable = false, name = "alternativa_correta")
	private Integer correctIndex;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "modulo_id")
	private Modulo modulo;

	public Atividade() {
		
	}
	
	public Atividade(Integer id, String answer, String questao1, String questao2,
			String questao3, String questao4, String questao5, Integer pointByQuestion,
			Integer correctIndex, Modulo modulo) {
		super();
		this.id = id;
		this.answer = answer;
		this.questao1 = questao1;
		this.questao2 = questao2;
		this.questao3 = questao3;
		this.questao4 = questao4;
		this.questao5 = questao5;
		this.pointByQuestion = pointByQuestion;
		this.correctIndex = correctIndex;
		this.modulo = modulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public String getQuestao5() {
		return questao5;
	}

	public void setQuestao5(String questao5) {
		this.questao5 = questao5;
	}

	public Integer getPointByQuestion() {
		return pointByQuestion;
	}

	public void setPointByQuestion(Integer pointByQuestion) {
		this.pointByQuestion = pointByQuestion;
	}

	public Integer getCorrectIndex() {
		return correctIndex;
	}

	public void setCorrectIndex(Integer correctIndex) {
		this.correctIndex = correctIndex;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}
