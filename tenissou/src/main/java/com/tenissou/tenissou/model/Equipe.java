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
import javax.validation.constraints.Null;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "equipe")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Equipe implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_equipe")
	private long idEquipe;
	 
	@NotBlank @Column(name="Id_joueur1")
	private long idJoueur1;
	
	@Column(name="Id_joueur2")
	private Long idJoueur2;

	public Equipe() {
		super();
	}

	public Equipe(long idEquipe, @NotBlank long idJoueur1, Long idJoueur2) {
		super();
		this.idEquipe = idEquipe;
		this.idJoueur1 = idJoueur1;
		this.idJoueur2 = idJoueur2;
	}

	public long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public long getIdJoueur1() {
		return idJoueur1;
	}

	public void setIdJoueur1(long idJoueur1) {
		this.idJoueur1 = idJoueur1;
	}

	public Long getIdJoueur2() {
		return idJoueur2;
	}

	public void setIdJoueur2(Long idJoueur2) {
		this.idJoueur2 = idJoueur2;
	}
}