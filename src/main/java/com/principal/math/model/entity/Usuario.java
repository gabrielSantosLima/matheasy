package com.principal.math.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
public class Usuario implements IUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true, length = 200)
	private String nome;

	@Column(nullable = true)
	@DateTimeFormat(pattern	= "yyyy-MM-dd")
	private Date dataAniversario;

	@Column(nullable = false, length = 100, name = "email")
	private String email;

	@Column(nullable = false, name = "pontuacao")
	private Integer pontuacao;

	@Column(nullable = true, name = "descricao")
	private String descricao;

	@Column(nullable = true, name = "perfil")
	private byte[] perfil;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
	private List<BlocoDeNotas> blocos;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Evento> eventos;

	@OneToMany(mappedBy = "usuario")
	private List<EstadoEstudo> estados;

	@OneToMany(mappedBy="usuario1", fetch = FetchType.LAZY)
	private List<Mensagem> mensagens1;

	@OneToMany(mappedBy="usuario2", fetch = FetchType.LAZY)
	private List<Mensagem> mensagens2;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			  name = "contatos", 
			  joinColumns = @JoinColumn(name = "aluno_id"), 
			  inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private List<Usuario> contatos;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@Column(nullable = false, length = 20, name = "username")
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String passwordConfirm;

	public Usuario() {
		
	}
	
	public Usuario(String nome, 
			Date dataAniversario, 
			String username,
			String email,
			String descricao,
			String password,
			String passwordConfirm, 
			byte[] perfil
	) {
		this.id = null;
		this.nome = nome;
		this.dataAniversario = dataAniversario;
		this.username = username;
		this.email = email;
		this.pontuacao = 0;
		this.descricao = descricao;
		this.blocos = null;
		this.eventos = null;
		this.estados = null;
		this.mensagens1 = null;
		this.mensagens2 = null;
		this.password = password;
		this.perfil = perfil; 
		this.passwordConfirm = passwordConfirm;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<BlocoDeNotas> getBlocos() {
		return blocos;
	}

	public void setBlocos(List<BlocoDeNotas> blocos) {
		this.blocos = blocos;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<EstadoEstudo> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoEstudo> estados) {
		this.estados = estados;
	}

	public List<Mensagem> getMensagens1() {
		return mensagens1;
	}

	public void setMensagens1(List<Mensagem> mensagens1) {
		this.mensagens1 = mensagens1;
	}

	public List<Mensagem> getMensagens2() {
		return mensagens2;
	}
	
	public void setMensagens2(List<Mensagem> mensagens2) {
		this.mensagens2 = mensagens2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public byte[] getPerfil() {
		return perfil;
	}

	public void setPerfil(byte[] perfil) {
		this.perfil = perfil;
	}

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public void setRole(Role role) {
		this.role = role;
	}

	public List<Usuario> getContatos() {
		return contatos;
	}

	public void setContatos(List<Usuario> contatos) {
		this.contatos = contatos;
	}
}