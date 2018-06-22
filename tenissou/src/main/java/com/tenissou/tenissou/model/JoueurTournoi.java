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
import com.tenissou.tenissou.identity.JoueurMatchIdentity;
import com.tenissou.tenissou.identity.JoueurTournoiIdentity;

@Entity
@Table(name = "joueur_tournoi")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class JoueurTournoi implements Serializable{
	
	@EmbeddedId
	private JoueurTournoiIdentity joueurTournoiIdentity;

	public JoueurTournoi() {
		super();
	}

	public JoueurTournoi(JoueurTournoiIdentity joueurTournoiIdentity) {
		super();
		this.joueurTournoiIdentity = joueurTournoiIdentity;
	}

	public JoueurTournoiIdentity getJoueurTournoiIdentity() {
		return joueurTournoiIdentity;
	}

	public void setJoueurTournoiIdentity(JoueurTournoiIdentity joueurTournoiIdentity) {
		this.joueurTournoiIdentity = joueurTournoiIdentity;
	}
}