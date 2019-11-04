package ar.edu.ucc.arqsoft.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ucc.arqsoft.test.dao.DaoGenerico;
import ar.edu.ucc.arqsoft.test.dto.CardDto;
import ar.edu.ucc.arqsoft.test.dto.TransactionDto;
import ar.edu.ucc.arqsoft.test.model.Card;
import ar.edu.ucc.arqsoft.test.model.Operation;
import ar.edu.ucc.arqsoft.test.model.Transaction;

@Service
public class CardService {
	
	@Autowired
	DaoGenerico<Card, Long> cardDao;
	
	@Autowired
	DaoGenerico<Transaction, Long> transactionDao;
	
	public void saveCard(CardDto dto) {
		Card card = new Card();
		
		card.setNumber(dto.getNumber());
		card.setBalance(dto.getBalance());
		card.setUser(dto.getUser());
		
		cardDao.saveOrUpdate(card);
		
		dto.setId(card.getId());
	}
	
	
	public void updateBalance(TransactionDto dto) {
		Card card = dto.getCard();
		
		Operation operation = dto.getOperation();
		
		if (card.getBalance() <= 0 && operation == Operation.CREDIT)
			return;
		
		Double amount = operation == Operation.CREDIT 
			? dto.getAmount()
			: -dto.getAmount();
		
		card.setBalance(card.getBalance() + amount);
	}
	
}
