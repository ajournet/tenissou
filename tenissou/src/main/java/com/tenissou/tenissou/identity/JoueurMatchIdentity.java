package com.tenissou.tenissou.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class JoueurMatchIdentity implements Serializable{
	
	@NotNull
    @Size(max = 20)
	private long idJoueur;
	
	@NotNull
    @Size(max = 20)
	private long idMatch;

	public JoueurMatchIdentity() {
		super();
	}

	public JoueurMatchIdentity(@NotNull @Size(max = 20) long idJoueur, @NotNull @Size(max = 20) long idMatch) {
		super();
		this.idJoueur = idJoueur;
		this.idMatch = idMatch;
	}


	public long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(long idJoueur) {
		this.idJoueur = idJoueur;
	}

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}
}
