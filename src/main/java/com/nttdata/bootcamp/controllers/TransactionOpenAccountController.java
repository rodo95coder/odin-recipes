package com.nttdata.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.models.products.CurrentAccount;
import com.nttdata.bootcamp.models.products.FixedTermAccount;
import com.nttdata.bootcamp.models.products.PersonalCredit;
import com.nttdata.bootcamp.models.products.SavingAccount;
import com.nttdata.bootcamp.services.ITransactionOpenAccount;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/transactionOpenAccount")
public class TransactionOpenAccountController {
	
	@Autowired
	ITransactionOpenAccount oarepo;
	
	@PostMapping("/CurrentAccount")
	public Mono<CurrentAccount> saveCurrentAccount(@RequestBody CurrentAccount currentAccount){
		log.info("a PersonalCredit was created");
		return oarepo.saveCurrentAccount(currentAccount);
	}
	
	@PostMapping("/FixedTermAccount")
	public Mono<FixedTermAccount> saveFixedTermAccount(@RequestBody FixedTermAccount fixedTermAccount){
		log.info("a FixedTermAccount was created");
		return oarepo.saveFixedTermAccount(fixedTermAccount);
	}
	
	@PostMapping("/PersonalCredit")
	public Mono<PersonalCredit> savePersonalCredit(@RequestBody PersonalCredit personalCredit){
		log.info("a PersonalCredit was created");
		return oarepo.savePersonalCredit(personalCredit);
	}
	
	@PostMapping("/SavingAccount")
	public Mono<SavingAccount> saveSavingAccount(@RequestBody SavingAccount transactionPerson){
		log.info("a SavingAccount was created");
		return oarepo.saveSavingAccount(transactionPerson);
	}
	
}
