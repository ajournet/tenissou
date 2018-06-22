package com.tenissou.tenissou.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tenissou.tenissou.identity.SetIdentity;

@Entity
@Table(name = "set")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Set implements Serializable{
	
	@EmbeddedId
	private SetIdentity setIdentity;
	
	@NotBlank @Column(name="Equipe1_jeu")
	private long equipe1Jeu;
	
	@NotBlank @Column(name="Equipe2_jeu")
	private long equipe2Jeu;

	public Set() {
		super();
	}

	public Set(SetIdentity setIdentity, @NotBlank long equipe1Jeu, @NotBlank long equipe2Jeu) {
		super();
		this.setIdentity = setIdentity;
		this.equipe1Jeu = equipe1Jeu;
		this.equipe2Jeu = equipe2Jeu;
	}

	public SetIdentity getSetIdentity() {
		return setIdentity;
	}

	public void setSetIdentity(SetIdentity setIdentity) {
		this.setIdentity = setIdentity;
	}

	public long getEquipe1Jeu() {
		return equipe1Jeu;
	}

	public void setEquipe1Jeu(long equipe1Jeu) {
		this.equipe1Jeu = equipe1Jeu;
	}

	public long getEquipe2Jeu() {
		return equipe2Jeu;
	}

	public void setEquipe2Jeu(long equipe2Jeu) {
		this.equipe2Jeu = equipe2Jeu;
	}
	
}