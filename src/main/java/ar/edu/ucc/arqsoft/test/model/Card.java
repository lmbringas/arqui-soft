package ar.edu.ucc.arqsoft.test.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
public class Card extends ObjetoGenerico {

	@Column(name = "number")
	private String number;
	
	@Column(name = "balance")
	private Double balance;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "User_ID", nullable = false)
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
	private Set<Transaction> transactions = new HashSet<Transaction>();

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
