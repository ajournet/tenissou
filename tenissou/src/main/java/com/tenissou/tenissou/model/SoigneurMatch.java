package com.tenissou.tenissou.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "soigneur_match")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class SoigneurMatch implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_soigneur")
	private long idSoigneur;
	
	@NotBlank @Column(name="Id_match")
	private long idMatch;

	public SoigneurMatch() {
		super();
	}

	public SoigneurMatch(long idSoigneur, @NotBlank long idMatch) {
		super();
		this.idSoigneur = idSoigneur;
		this.idMatch = idMatch;
	}

	public long getIdSoigneur() {
		return idSoigneur;
	}

	public void setIdSoigneur(long idSoigneur) {
		this.idSoigneur = idSoigneur;
	}

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}
}