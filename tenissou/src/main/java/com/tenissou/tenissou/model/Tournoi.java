package com.tenissou.tenissou.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "tournoi")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Tournoi implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_tournoi")
	private long idTournoi;
	
	@NotBlank @Column(name="Lieu_tournoi")
	private String lieuTournoi;
	
	@NotBlank @Column(name="Date_debut_tournoi")
	private Date dateDebutTournoi;
	
	@NotBlank @Column(name="Date_fin_tournoi")
	private Date dateFinTournoi;
	
	@NotBlank @Column(name="Nom_tournoi")
	private String nomTournoi;
	
	@NotBlank @Column(name="Type_match_tournoi")
	private String typeMatchTournoi;
	
	@NotBlank @Column(name="Nb_participants_tournoi")
	private Integer nbParticipant;
	
	@NotBlank @Column(name="Cashprize_tournoi")
	private Integer cashprizeTournoi;
	
	//Grand chelem et le reste
	@NotBlank @Column(name="Type_tournoi")
	private String typeTournoi;
	
	//Masculin Feminin ou Mixte
	@NotBlank @Column(name="Genre_tournoi")
	private String genreTournoi;

	public Tournoi() {
		super();
	}

	public Tournoi(long idTournoi, @NotBlank String lieuTournoi, @NotBlank Date dateDebutTournoi,
			@NotBlank Date dateFinTournoi, @NotBlank String nomTournoi, @NotBlank String typeMatchTournoi,
			@NotBlank Integer nbParticipant, @NotBlank Integer cashprizeTournoi, @NotBlank String typeTournoi,
			@NotBlank String genreTournoi) {
		super();
		this.idTournoi = idTournoi;
		this.lieuTournoi = lieuTournoi;
		this.dateDebutTournoi = dateDebutTournoi;
		this.dateFinTournoi = dateFinTournoi;
		this.nomTournoi = nomTournoi;
		this.typeMatchTournoi = typeMatchTournoi;
		this.nbParticipant = nbParticipant;
		this.cashprizeTournoi = cashprizeTournoi;
		this.typeTournoi = typeTournoi;
		this.genreTournoi = genreTournoi;
	}

	public long getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(long idTournoi) {
		this.idTournoi = idTournoi;
	}

	public String getLieuTournoi() {
		return lieuTournoi;
	}

	public void setLieuTournoi(String lieuTournoi) {
		this.lieuTournoi = lieuTournoi;
	}

	public Date getDateDebutTournoi() {
		return dateDebutTournoi;
	}

	public void setDateDebutTournoi(Date dateDebutTournoi) {
		this.dateDebutTournoi = dateDebutTournoi;
	}

	public Date getDateFinTournoi() {
		return dateFinTournoi;
	}

	public void setDateFinTournoi(Date dateFinTournoi) {
		this.dateFinTournoi = dateFinTournoi;
	}

	public String getNomTournoi() {
		return nomTournoi;
	}

	public void setNomTournoi(String nomTournoi) {
		this.nomTournoi = nomTournoi;
	}

	public String getTypeMatchTournoi() {
		return typeMatchTournoi;
	}

	public void setTypeMatchTournoi(String typeMatchTournoi) {
		this.typeMatchTournoi = typeMatchTournoi;
	}

	public Integer getNbParticipant() {
		return nbParticipant;
	}

	public void setNbParticipant(Integer nbParticipant) {
		this.nbParticipant = nbParticipant;
	}

	public Integer getCashprizeTournoi() {
		return cashprizeTournoi;
	}

	public void setCashprizeTournoi(Integer cashprizeTournoi) {
		this.cashprizeTournoi = cashprizeTournoi;
	}

	public String getTypeTournoi() {
		return typeTournoi;
	}

	public void setTypeTournoi(String typeTournoi) {
		this.typeTournoi = typeTournoi;
	}

	public String getGenreTournoi() {
		return genreTournoi;
	}

	public void setGenreTournoi(String genreTournoi) {
		this.genreTournoi = genreTournoi;
	}
}