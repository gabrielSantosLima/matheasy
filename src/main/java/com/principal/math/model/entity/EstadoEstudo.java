package com.principal.math.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name=  "estado_estudo")
public class EstadoEstudo {

	@EmbeddedId
	private EstadoChavePrimaria id;
	
	@ManyToOne
	@MapsId("usuario_id")
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@MapsId("modulo_id")
	@JoinColumn(name = "modulo_id", nullable = false)
	private Modulo modulo;

	public EstadoEstudo(Usuario usuario, Modulo modulo) {
		this.id = null;
		this.usuario = usuario;
		this.modulo = modulo;
	}

	public EstadoChavePrimaria getId() {
		return id;
	}

	public void setId(EstadoChavePrimaria id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}

@Embeddable
class EstadoChavePrimaria implements Serializable{
	
	private static final long serialVersionUID = -4325977597961655904L;

	@Column(name = "usuario_id")
	private Integer usuarioId;

	@Column(name = "modulo_id")
	private Integer moduloId;
}
