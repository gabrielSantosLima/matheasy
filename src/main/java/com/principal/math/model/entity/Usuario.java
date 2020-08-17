package com.principal.math.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Column(nullable = false, length = 200)
	private String nome;

	@Column(nullable = true)
	@DateTimeFormat(pattern	= "yyyy-MM-dd")
	private Date dataAniversario;

	@Column(nullable = false, length = 100, name = "email")
	private String email;

	@Column(nullable = false, name = "pontuacao")
	private Integer pontuacao;

	@Column(nullable = false, name = "descricao")
	private String descricao;

	@Column(nullable = false, name = "perfil")
	private byte[] perfil;
	
	@OneToMany(mappedBy = "usuario")
	private List<BlocoDeNotas> blocos;

	@OneToMany(mappedBy = "usuario")
	private List<Evento> eventos;

	@OneToMany(mappedBy = "usuario")
	private List<EstadoEstudo> estados;

	@OneToMany(mappedBy = "aluno")
	private List<Mensagem> mensagens;

	@ManyToMany
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
	
	public Usuario(Integer id, 
			String nome, 
			Date dataAniversario, 
			String username,
			String email, 
			Integer pontuacao, 
			String descricao,
			List<EstadoEstudo> estados, 
			Role role, String password,
			String passwordConfirm, 
			byte[] perfil
	) {
		this.id = id;
		this.nome = nome;
		this.dataAniversario = dataAniversario;
		this.username = username;
		this.email = email;
		this.pontuacao = pontuacao;
		this.descricao = descricao;
		this.blocos = null;
		this.eventos = null;
		this.estados = estados;
		this.mensagens = null;
		this.role = role;
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

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
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