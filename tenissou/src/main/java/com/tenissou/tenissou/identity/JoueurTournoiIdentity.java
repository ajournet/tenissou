package com.tenissou.tenissou.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class JoueurTournoiIdentity implements Serializable{
	
	@NotNull
    @Size(max = 20)
	private long idJoueur;
	
	@NotNull
    @Size(max = 20)
	private long idTournoi;

	public JoueurTournoiIdentity() {
		super();
	}

	public JoueurTournoiIdentity(@NotNull @Size(max = 20) long idJoueur, @NotNull @Size(max = 20) long idTournoi) {
		super();
		this.idJoueur = idJoueur;
		this.idTournoi = idTournoi;
	}

	public long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(long idJoueur) {
		this.idJoueur = idJoueur;
	}

	public long getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(long idTournoi) {
		this.idTournoi = idTournoi;
	}
	
	

}
