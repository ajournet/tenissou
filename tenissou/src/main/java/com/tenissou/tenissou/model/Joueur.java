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
@Table(name = "joueur")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Joueur implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_joueur")
	private long idJoueur;
	
	@NotBlank @Column(name="Id_licence_joueur")
	private Integer idLicence;
	 
	@NotBlank @Column(name="Nom_joueur")
	private String nom;
	
	@NotBlank @Column(name="Prenom_joueur")
	private String prenom;
	
	@NotBlank @Column(name="Pays_joueur")
	private String pays;
	
	@NotBlank @Column(name="Age_joueur")
	private Integer age;
	
	@NotBlank @Column(name="Classement_joueur")
	private Integer classement;

	

	public Joueur(long idJoueur, @NotBlank Integer idLicence, @NotBlank String nom, @NotBlank String prenom,
			@NotBlank String pays, @NotBlank Integer age, @NotBlank Integer classement) {
		super();
		this.idJoueur = idJoueur;
		this.idLicence = idLicence;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.age = age;
		this.classement = classement;
	}

	public Joueur() {
	}

	public long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Integer idJoueur) {
		this.idJoueur = idJoueur;
	}

	public Integer getIdLicence() {
		return idLicence;
	}

	public void setIdLicence(Integer idLicence) {
		this.idLicence = idLicence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getClassement() {
		return classement;
	}

	public void setClassement(Integer classement) {
		this.classement = classement;
	}

	public void setIdJoueur(long idJoueur) {
		this.idJoueur = idJoueur;
	}
}