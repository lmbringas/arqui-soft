package ar.edu.ucc.arqsoft.test.dto;

import java.util.Set;

import ar.edu.ucc.arqsoft.test.model.Transaction;

public class CardTransactionsDto {

	private Set<Transaction> transactions;

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
