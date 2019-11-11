package ar.edu.ucc.arqsoft.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequestDto {

	@JsonProperty("tarjeta")
	private CardAuthDto card;

	@JsonProperty("monto")
	private Double amount;

	public CardAuthDto getCard() {
		return card;
	}

	public void setCard(CardAuthDto card) {
		this.card = card;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
