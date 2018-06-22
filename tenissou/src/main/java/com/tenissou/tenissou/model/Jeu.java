package com.tenissou.tenissou.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tenissou.tenissou.identity.JeuIdentity;
import com.tenissou.tenissou.identity.JoueurMatchIdentity;

@Entity
@Table(name = "jeu")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Jeu implements Serializable{
	
	@EmbeddedId
	private JeuIdentity jeuIdentity;
	
	@NotBlank @Column(name="Id_point")
	private long idPoint;

	public Jeu() {
		super();
	}

	public Jeu(JeuIdentity jeuIdentity, @NotBlank long idPoint) {
		super();
		this.jeuIdentity = jeuIdentity;
		this.idPoint = idPoint;
	}

	public JeuIdentity getJeuIdentity() {
		return jeuIdentity;
	}

	public void setJeuIdentity(JeuIdentity jeuIdentity) {
		this.jeuIdentity = jeuIdentity;
	}

	public long getIdPoint() {
		return idPoint;
	}

	public void setIdPoint(long idPoint) {
		this.idPoint = idPoint;
	}
}