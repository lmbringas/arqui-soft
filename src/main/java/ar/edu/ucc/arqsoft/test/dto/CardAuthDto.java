package ar.edu.ucc.arqsoft.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardAuthDto {

	@JsonProperty("numero")
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
