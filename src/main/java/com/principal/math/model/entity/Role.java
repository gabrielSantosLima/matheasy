package com.principal.math.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "papel")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "role")
	private List<Usuario> usuarios;
	
	@ManyToMany
	@JoinTable(
			  name = "role_authority", 
			  joinColumns = @JoinColumn(name = "role_id"), 
			  inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private List<Authorities> authorities;
	
	public Role() {
		
	}
	
	public Role(String name, List<Authorities> authorities){
		this.name = name;
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}
}
