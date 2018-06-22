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
@Table(name = "stats_generale")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Stat implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_stat")
	private long idStat;
	
	@NotBlank @Column(name="Id_joueur")
	private long idJoueur;
	
	@Column(name="Stat_service")
	private String statService;
	
	@Column(name="Winrate")
	private String winrate;
	 
	@Column(name="Faute_directe")
	private String fauteDirecte;
	
	@Column(name="Stat_set_gagne")
	private String statSetGagne;
	
	@Column(name="Stat_match_gagne")
	private String statMatchGagne;

	public Stat() {
		super();
	}

	public Stat(long idStat, @NotBlank long idJoueur, String statService, String winrate, String fauteDirecte,
			String statSetGagne, String statMatchGagne) {
		super();
		this.idStat = idStat;
		this.idJoueur = idJoueur;
		this.statService = statService;
		this.winrate = winrate;
		this.fauteDirecte = fauteDirecte;
		this.statSetGagne = statSetGagne;
		this.statMatchGagne = statMatchGagne;
	}

	public long getIdStat() {
		return idStat;
	}

	public void setIdStat(long idStat) {
		this.idStat = idStat;
	}

	public long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(long idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getStatService() {
		return statService;
	}

	public void setStatService(String statService) {
		this.statService = statService;
	}

	public String getWinrate() {
		return winrate;
	}

	public void setWinrate(String winrate) {
		this.winrate = winrate;
	}

	public String getFauteDirecte() {
		return fauteDirecte;
	}

	public void setFauteDirecte(String fauteDirecte) {
		this.fauteDirecte = fauteDirecte;
	}

	public String getStatSetGagne() {
		return statSetGagne;
	}

	public void setStatSetGagne(String statSetGagne) {
		this.statSetGagne = statSetGagne;
	}

	public String getStatMatchGagne() {
		return statMatchGagne;
	}

	public void setStatMatchGagne(String statMatchGagne) {
		this.statMatchGagne = statMatchGagne;
	}



	
}