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
@Table(name = "utilisateur")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Utilisateur implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_utilisateur")
	private long idUtilisateur;
	
	@NotBlank @Column(name="Mail_utilisateur")
	private String mail;
	
	@NotBlank @Column(name="Mdp_utilisateur")
	private String mdpUtilisateur;
	
	@NotBlank @Column(name="Type_utilisateur")
	private String typeUtilisateur;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(long idUtilisateur, @NotBlank String mail, @NotBlank String mdpUtilisateur,
			@NotBlank String typeUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.mail = mail;
		this.mdpUtilisateur = mdpUtilisateur;
		this.typeUtilisateur = typeUtilisateur;
	}

	public long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public String getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}
	
}