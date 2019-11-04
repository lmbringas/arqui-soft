package ar.edu.ucc.arqsoft.test.dto;

import java.util.Date;

import ar.edu.ucc.arqsoft.test.model.Card;
import ar.edu.ucc.arqsoft.test.model.Operation;

public class TransactionDto {

    private Long id ;

    private Date date;

    private Double amount;
    
    private Operation operation;

    private Card card;


    public TransactionDto() {}

    public TransactionDto(Long id, Date date, double amount, Operation operation, Card card) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.operation = operation;
        this.card = card;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}