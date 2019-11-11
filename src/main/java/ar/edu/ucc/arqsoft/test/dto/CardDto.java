package ar.edu.ucc.arqsoft.test.dto;

import java.util.Set;

import ar.edu.ucc.arqsoft.test.model.Transaction;
import ar.edu.ucc.arqsoft.test.model.User;

public class CardDto {

    private Long id;

    private String number;

    private User user;

    private Double balance;

    private Set<Transaction> transactions;


    public CardDto() {}

    public CardDto(Long id, String number, User user, Double balance) {
        this.id = id;
        this.number = number;
        this.user = user;
        this.balance = balance;
    }


    public CardDto(Long id, String number, User user, Double balance, Set<Transaction> transactions) {
        this.id = id;
        this.number = number;
        this.user = user;
        this.balance = balance;
        this.transactions = transactions;
    }


    public Set<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}