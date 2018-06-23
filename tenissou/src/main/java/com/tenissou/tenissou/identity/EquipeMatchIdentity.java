package com.tenissou.tenissou.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class EquipeMatchIdentity implements Serializable{
	
	@NotNull
    @Size(max = 20)
	private long idEquipe;
	
	@NotNull
    @Size(max = 20)
	private long idMatch;

	public EquipeMatchIdentity() {
		super();
	}

	public EquipeMatchIdentity(@NotNull @Size(max = 20) long idEquipe, @NotNull @Size(max = 20) long idMatch) {
		super();
		this.idEquipe = idEquipe;
		this.idMatch = idMatch;
	}


	public long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}
}
