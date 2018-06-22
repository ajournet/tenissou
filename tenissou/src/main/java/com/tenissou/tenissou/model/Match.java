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
@Table(name = "match_tennis")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Match implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_match")
	private long idMatch;
	
	@NotBlank @Column(name="Lieu_match")
	private String lieuMatch;
	
	@NotBlank @Column(name="Tournoi_match")
	private Integer idTournoi;
	 
	@NotBlank @Column(name="Date_debut_match")
	private Date dateDebut;
	
	@NotBlank @Column(name="Etat_match")
	private String etatMatch;
	
	@NotBlank @Column(name="Terrain_match")
	private String terrainMatch;
	
	public Match() {
		super();
	}

	public Match(long idMatch, @NotBlank String lieuMatch, @NotBlank Integer idTournoi, @NotBlank Date dateDebut,
			@NotBlank String etatMatch, @NotBlank String terrainMatch, @NotBlank Integer idScore) {
		super();
		this.idMatch = idMatch;
		this.lieuMatch = lieuMatch;
		this.idTournoi = idTournoi;
		this.dateDebut = dateDebut;
		this.etatMatch = etatMatch;
		this.terrainMatch = terrainMatch;
	}

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}

	public String getLieuMatch() {
		return lieuMatch;
	}

	public void setLieuMatch(String lieuMatch) {
		this.lieuMatch = lieuMatch;
	}

	public Integer getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(Integer idTournoi) {
		this.idTournoi = idTournoi;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getEtatMatch() {
		return etatMatch;
	}

	public void setEtatMatch(String etatMatch) {
		this.etatMatch = etatMatch;
	}

	public String getTerrainMatch() {
		return terrainMatch;
	}

	public void setTerrainMatch(String terrainMatch) {
		this.terrainMatch = terrainMatch;
	}
}