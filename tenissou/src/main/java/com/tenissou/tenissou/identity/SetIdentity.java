package com.tenissou.tenissou.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class SetIdentity implements Serializable{

	@NotNull
    @Size(max = 20)
	private long idSet;
	
	@NotNull
    @Size(max = 20)
	private long idMatch;

	public SetIdentity() {
		super();
	}

	public SetIdentity(@NotNull @Size(max = 20) long idSet, @NotNull @Size(max = 20) long idMatch) {
		super();
		this.idSet = idSet;
		this.idMatch = idMatch;
	}

	public long getIdSet() {
		return idSet;
	}

	public void setIdSet(long idSet) {
		this.idSet = idSet;
	}

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}

}
