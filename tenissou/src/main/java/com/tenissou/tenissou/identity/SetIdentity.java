package com.tenissou.tenissou.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class SetIdentity implements Serializable{

	@NotNull
    @Size(max = 20)
	private long idSat;
	
	@NotNull
    @Size(max = 20)
	private long idMatch;

	public SetIdentity() {
		super();
	}

	public SetIdentity(@NotNull @Size(max = 20) long idSat, @NotNull @Size(max = 20) long idMatch) {
		super();
		this.idSat = idSat;
		this.idMatch = idMatch;
	}
}
