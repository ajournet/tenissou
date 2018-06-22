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
import com.tenissou.tenissou.identity.JeuIdentity;
import com.tenissou.tenissou.identity.JoueurMatchIdentity;

@Entity
@Table(name = "points")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Points implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_point")
	private long idPoint;
	
	@NotBlank @Column(name="Equipe1_point")
	private long equipe1Point;
	
	@NotBlank @Column(name="Equipe2_point")
	private long equipe2Point;

	public Points() {
		super();
	}

	public Points(long idPoint, @NotBlank long equipe1Point, @NotBlank long equipe2Point) {
		super();
		this.idPoint = idPoint;
		this.equipe1Point = equipe1Point;
		this.equipe2Point = equipe2Point;
	}

	public long getIdPoint() {
		return idPoint;
	}

	public void setIdPoint(long idPoint) {
		this.idPoint = idPoint;
	}

	public long getEquipe1Point() {
		return equipe1Point;
	}

	public void setEquipe1Point(long equipe1Point) {
		this.equipe1Point = equipe1Point;
	}

	public long getEquipe2Point() {
		return equipe2Point;
	}

	public void setEquipe2Point(long equipe2Point) {
		this.equipe2Point = equipe2Point;
	}
}