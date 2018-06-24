package com.tenissou.tenissou.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class JeuIdentity implements Serializable{
	
	@NotNull
    @Size(max = 20)
	private long idMatch;

	@NotNull
    @Size(max = 20)
	private long idJeu;
	
	@NotNull
    @Size(max = 20)
	private long idSet;

	public JeuIdentity() {
		super();
	}

	public JeuIdentity(@NotNull @Size(max = 20) long idMatch, @NotNull @Size(max = 20) long idJeu,
			@NotNull @Size(max = 20) long idSet) {
		super();
		this.idMatch = idMatch;
		this.idJeu = idJeu;
		this.idSet = idSet;
	}

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}

	public long getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(long idJeu) {
		this.idJeu = idJeu;
	}

	public long getIdSet() {
		return idSet;
	}

	public void setIdSet(long idSet) {
		this.idSet = idSet;
	}
}
