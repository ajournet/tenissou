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

@Entity
@Table(name = "jeu")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Jeu implements Serializable{
	
	@EmbeddedId
	private JeuIdentity jeuIdentity;
	
	@NotBlank @Column(name="Equipe1_point")
	private long equipe1Point;
	
	@NotBlank @Column(name="Equipe2_point")
	private long equipe2Point;

	public Jeu() {
		super();
	}

	public Jeu(JeuIdentity jeuIdentity, @NotBlank long equipe1Point, @NotBlank long equipe2Point) {
		super();
		this.jeuIdentity = jeuIdentity;
		this.equipe1Point = equipe1Point;
		this.equipe2Point = equipe2Point;
	}

	public JeuIdentity getJeuIdentity() {
		return jeuIdentity;
	}

	public void setJeuIdentity(JeuIdentity jeuIdentity) {
		this.jeuIdentity = jeuIdentity;
	}

	public long getEquipe1Point() {
		return equipe1Point;
	}

	public void setEquipe1Point(long equipe1Point) {
		this.equipe1Point = equipe1Point;
	}

	public long getEquipe2Point() {
		return equipe2Point;
	}

	public void setEquipe2Point(long equipe2Point) {
		this.equipe2Point = equipe2Point;
	}
}