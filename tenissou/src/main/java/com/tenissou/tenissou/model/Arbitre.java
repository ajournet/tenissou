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
@Table(name = "arbitre")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Arbitre implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_arbitre")
	private long idArbitre;
	 
	@NotBlank @Column(name="Nom_arbitre")
	private String nom;
	
	@NotBlank @Column(name="Prenom_arbitre")
	private String prenom;
	
	@NotBlank @Column(name="Pays_arbitre")
	private String pays;
	
	@NotBlank @Column(name="Age_arbitre")
	private Integer age;
	
	@NotBlank @Column(name="Mail_arbitre")
	private String mailArbitre;

	@NotBlank @Column(name="Password_arbitre")
	private String passwordArbitre;
	
	public Arbitre() {
		super();
	}

	public Arbitre(long idArbitre, @NotBlank String nom, @NotBlank String prenom, @NotBlank String pays,
			@NotBlank Integer age, @NotBlank String mailArbitre, @NotBlank String passwordArbitre) {
		super();
		this.idArbitre = idArbitre;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.age = age;
		this.mailArbitre = mailArbitre;
		this.passwordArbitre = passwordArbitre;
	}

	public long getIdArbitre() {
		return idArbitre;
	}

	public void setIdArbitre(long idArbitre) {
		this.idArbitre = idArbitre;
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

	public String getMailArbitre() {
		return mailArbitre;
	}

	public void setMailArbitre(String mailArbitre) {
		this.mailArbitre = mailArbitre;
	}

	public String getPasswordArbitre() {
		return passwordArbitre;
	}

	public void setPasswordArbitre(String passwordArbitre) {
		this.passwordArbitre = passwordArbitre;
	}
	
}