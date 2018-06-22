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

@Entity
@Table(name = "joueur_match")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class JoueurMatch implements Serializable{
	
	@EmbeddedId
	private JoueurMatchIdentity joueurMatchIdentity;
	
	@NotBlank @Column(name="Stat_joueur_match")
	private long statJoueurMatch;
	
	@NotBlank @Column(name="Type_joueur_match")
	private long typeJoueurMatch;
	
	public JoueurMatch() {
		super();
	}
	
	public JoueurMatch(JoueurMatchIdentity joueurMatchIdentity, @NotBlank long statJoueurMatch,
			@NotBlank long typeJoueurMatch) {
		super();
		this.joueurMatchIdentity = joueurMatchIdentity;
		this.statJoueurMatch = statJoueurMatch;
		this.typeJoueurMatch = typeJoueurMatch;
	}

	public long getStatJoueurMatch() {
		return statJoueurMatch;
	}

	public void setStatJoueurMatch(long statJoueurMatch) {
		this.statJoueurMatch = statJoueurMatch;
	}

	public long getTypeJoueurMatch() {
		return typeJoueurMatch;
	}

	public void setTypeJoueurMatch(long typeJoueurMatch) {
		this.typeJoueurMatch = typeJoueurMatch;
	}

	public JoueurMatchIdentity getJoueurMatchIdentity() {
		return joueurMatchIdentity;
	}

	public void setJoueurMatchIdentity(JoueurMatchIdentity joueurMatchIdentity) {
		this.joueurMatchIdentity = joueurMatchIdentity;
	}
	
}