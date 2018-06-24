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
@Table(name = "organisation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Organisation implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_organisation")
	private long idOrganisation;
	
	@NotBlank @Column(name="Nom_organisation")
	private String nom;
	
	@NotBlank @Column(name="Mail_organisation")
	private Integer mailOrganisation;
	
	@NotBlank @Column(name="Password_organisation")
	private Integer passwordOrganisation;

	public Organisation() {
		super();
	}

	public Organisation(long idOrganisation, @NotBlank String nom, @NotBlank Integer mailOrganisation,
			@NotBlank Integer passwordOrganisation) {
		super();
		this.idOrganisation = idOrganisation;
		this.nom = nom;
		this.mailOrganisation = mailOrganisation;
		this.passwordOrganisation = passwordOrganisation;
	}

	public long getIdOrganisation() {
		return idOrganisation;
	}

	public void setIdOrganisation(long idOrganisation) {
		this.idOrganisation = idOrganisation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getMailOrganisation() {
		return mailOrganisation;
	}

	public void setMailOrganisation(Integer mailOrganisation) {
		this.mailOrganisation = mailOrganisation;
	}

	public Integer getPasswordOrganisation() {
		return passwordOrganisation;
	}

	public void setPasswordOrganisation(Integer passwordOrganisation) {
		this.passwordOrganisation = passwordOrganisation;
	}
	
}