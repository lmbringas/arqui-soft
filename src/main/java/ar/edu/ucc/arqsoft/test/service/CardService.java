package ar.edu.ucc.arqsoft.test.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.ucc.arqsoft.test.dao.DaoGenerico;
import ar.edu.ucc.arqsoft.test.dto.AuthRequestDto;
import ar.edu.ucc.arqsoft.test.dto.AuthResponseDto;
import ar.edu.ucc.arqsoft.test.dto.CardAuthDto;
import ar.edu.ucc.arqsoft.test.dto.CardDto;
import ar.edu.ucc.arqsoft.test.dto.CardTransactionDto;
import ar.edu.ucc.arqsoft.test.dto.TransactionDto;
import ar.edu.ucc.arqsoft.test.model.Card;
import ar.edu.ucc.arqsoft.test.model.Operation;
import ar.edu.ucc.arqsoft.test.model.Transaction;

@Service
@Transactional
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
	
	
	public AuthResponseDto authCard(AuthRequestDto dto) {
		final String authUri = "https://iua-service.herokuapp.com/autorizar";

		CardAuthDto authCard = new CardAuthDto();
		authCard.setNumber(dto.getCard().getNumber());
		
		AuthRequestDto authRequest = new AuthRequestDto();
		authRequest.setCard(authCard);
		authRequest.setAmount(dto.getAmount());
		
		RestTemplate restTemplate = new RestTemplate();
		AuthResponseDto responseDto = 
		    		restTemplate.postForObject(authUri, authRequest, AuthResponseDto.class);
		 
		return responseDto;
	}
	
	
	private TransactionDto updateBalance(Long id, Double amount, Operation operation) throws Exception {
		
		Card card = cardDao.load(id);
		
		Transaction transaction = new Transaction();
		transaction.setDate(Calendar.getInstance().getTime());
		transaction.setAmount(amount);
		transaction.setOperation(operation);
		transaction.setCard(card);
		
		if (card.getBalance() <= 0 && operation == Operation.DEBIT)
			throw new Exception("Operation not permitted");
		
		Double operationAmount = operation == Operation.CREDIT
			? amount
			: -amount;
		
		card.setBalance(card.getBalance() + operationAmount);
		
		transactionDao.saveOrUpdate(transaction);
		cardDao.update(card);
		
		TransactionDto transactionDto = new TransactionDto(
			transaction.getId(),
			transaction.getDate(), 
			transaction.getAmount(), 
			transaction.getOperation(), 
			transaction.getCard()
		); 
		
		return transactionDto;
	}
	
	public TransactionDto creditAmount(Long id, Double amount) throws Exception {
		try {			
			TransactionDto transactionDto = updateBalance(id, amount, Operation.CREDIT);
			return transactionDto;
		} catch (Exception e) {
			// Exception handling...
			throw e;
		}
	}
	
	public TransactionDto debitAmount(Long id, Double amount) throws Exception {
		try {			
			TransactionDto transactionDto = updateBalance(id, amount, Operation.DEBIT);
			return transactionDto;
		} catch (Exception e) {
			// Exception handling...
			throw e;
		}
	}
	
	public List<CardTransactionDto> getAllTransaction(Long id){
		Card card = cardDao.load(id);

		Set<Transaction> t;
		t = card.getTransactions();
		
		List<CardTransactionDto> transactions = new ArrayList<CardTransactionDto>();
		
		for (Transaction transaction : t){
			transactions.add(new CardTransactionDto(transaction.getId(), 
									transaction.getDate(),
									transaction.getAmount(),
									transaction.getOperation()
									  ));
		}
		
		return transactions;
	}
}
