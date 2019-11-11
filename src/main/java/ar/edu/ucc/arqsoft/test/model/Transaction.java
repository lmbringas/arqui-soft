package ar.edu.ucc.arqsoft.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction extends ObjetoGenerico {

	@Column(name = "date")
	private Date date;
	
	@Column(name = "amount")
	private Double amount;
	
	@Enumerated(EnumType.ORDINAL)
	private Operation operation;
	
	@ManyToOne(targetEntity = Card.class)
	@JoinColumn(name = "Card_ID", nullable = false)
	private Card card;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}
