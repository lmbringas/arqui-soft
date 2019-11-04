package ar.edu.ucc.arqsoft.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.ucc.arqsoft.test.dto.CardDto;


@Controller
public class CardController {

    @Autowired
    CardService cardService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/card", 
	method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createCard(@RequestBody CardDto dto) throws Exception {

		cardService.saveCard(dto);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/card/{cardId}/credit", 
	method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> updateCredit(@PathVariable("cardId") Long id) throws Exception {

		cardService.saveCard(dto);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/card/{cardId}/debit", 
	method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> updateDebit(@PathVariable("cardId") Long id) throws Exception {

		cardService.saveCard(dto);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
    }

}