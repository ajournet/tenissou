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
import com.tenissou.tenissou.identity.EquipeMatchIdentity;

@Entity
@Table(name = "equipe_match")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class EquipeMatch implements Serializable{
	
	@EmbeddedId
	private EquipeMatchIdentity equipeMatchIdentity;
	
	@NotBlank @Column(name="Stat_equipe_match")
	private long statEquipeMatch;
	
	@NotBlank @Column(name="Type_equipe_match")
	private long typeEquipeMatch;
	
	public EquipeMatch() {
		super();
	}
	
	public EquipeMatch(EquipeMatchIdentity equipeMatchIdentity, @NotBlank long statEquipeMatch,
			@NotBlank long typeEquipeMatch) {
		super();
		this.equipeMatchIdentity = equipeMatchIdentity;
		this.statEquipeMatch = statEquipeMatch;
		this.typeEquipeMatch = typeEquipeMatch;
	}

	public long getStatEquipeMatch() {
		return statEquipeMatch;
	}

	public void setStatEquipeMatch(long statEquipeMatch) {
		this.statEquipeMatch = statEquipeMatch;
	}

	public long getTypeEquipeMatch() {
		return typeEquipeMatch;
	}

	public void setTypeEquipeMatch(long typeEquipeMatch) {
		this.typeEquipeMatch = typeEquipeMatch;
	}

	public EquipeMatchIdentity getEquipeMatchIdentity() {
		return equipeMatchIdentity;
	}

	public void setEquipeMatchIdentity(EquipeMatchIdentity equipeMatchIdentity) {
		this.equipeMatchIdentity = equipeMatchIdentity;
	}
	
}