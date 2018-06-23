package com.tenissou.tenissou.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class EquipeTournoiIdentity implements Serializable{
	
	@NotNull
    @Size(max = 20)
	private long idEquipe;
	
	@NotNull
    @Size(max = 20)
	private long idTournoi;

	public EquipeTournoiIdentity() {
		super();
	}

	public EquipeTournoiIdentity(@NotNull @Size(max = 20) long idEquipe, @NotNull @Size(max = 20) long idTournoi) {
		super();
		this.idEquipe = idEquipe;
		this.idTournoi = idTournoi;
	}

	public long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public long getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(long idTournoi) {
		this.idTournoi = idTournoi;
	}
	
	

}
