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
import com.tenissou.tenissou.identity.EquipeTournoiIdentity;

@Entity
@Table(name = "equipe_tournoi")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class EquipeTournoi implements Serializable{
	
	@EmbeddedId
	private EquipeTournoiIdentity equipeTournoiIdentity;

	public EquipeTournoi() {
		super();
	}

	public EquipeTournoi(EquipeTournoiIdentity equipeTournoiIdentity) {
		super();
		this.equipeTournoiIdentity = equipeTournoiIdentity;
	}

	public EquipeTournoiIdentity getEquipeTournoiIdentity() {
		return equipeTournoiIdentity;
	}

	public void setEquipeTournoiIdentity(EquipeTournoiIdentity equipeTournoiIdentity) {
		this.equipeTournoiIdentity = equipeTournoiIdentity;
	}
}