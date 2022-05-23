package com.nttdata.bootcamp.services.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.models.products.CurrentAccount;
import com.nttdata.bootcamp.models.products.FixedTermAccount;
import com.nttdata.bootcamp.models.products.PersonalCredit;
import com.nttdata.bootcamp.models.products.SavingAccount;
import com.nttdata.bootcamp.services.ITransactionOpenAccount;
import com.nttdata.bootcamp.utils.Constants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TransactionOpenAccountImpl implements ITransactionOpenAccount {
	
	private WebClient clientCurrentAccount  = WebClient.builder()
		      .baseUrl(Constants.SERVICECURRENTACCOUNT)
		      .build();
	
	private WebClient clientFixedTermAccount  = WebClient.builder()
		      .baseUrl(Constants.SERVICEFIXEDTERMACCOUNT)
		      .build();
	
	private WebClient clientPersonalCredit  = WebClient.builder()
		      .baseUrl(Constants.SERVICEPERSONALCREDIT)
		      .build();
	
	private WebClient clientSavingAccount  = WebClient.builder()
		      .baseUrl(Constants.SERVICESAVINGACCOUNT)
		      .build();
	
	private Function<Mono<CurrentAccount>, Mono<CurrentAccount>>
	createCurrentAccount = (objeto) -> clientCurrentAccount
	.post()
	.uri("/currentAccount/save")
	.body(objeto, CurrentAccount.class)
	.retrieve()
	.bodyToMono(CurrentAccount.class);
	
	private Function<Mono<FixedTermAccount>, Mono<FixedTermAccount>>
	createFixedTermAccount = (objeto) -> clientFixedTermAccount
	.post()
	.uri("/fixedTermAccount/save")
	.body(objeto, FixedTermAccount.class)
	.retrieve()
	.bodyToMono(FixedTermAccount.class);
	
	private Function<Mono<PersonalCredit>, Mono<PersonalCredit>>
	createPersonalCredit = (objeto) -> clientPersonalCredit
	.post()
	.uri("/personalCredit/save")
	.body(objeto, PersonalCredit.class)
	.retrieve()
	.bodyToMono(PersonalCredit.class);
	
	private Function<Mono<SavingAccount>, Mono<SavingAccount>>
	createSavingAccount = (objeto) -> clientSavingAccount
	.post()
	.uri("/savingAccount/save")
	.body(objeto, SavingAccount.class)
	.retrieve()
	.bodyToMono(SavingAccount.class);

	@Override
	public Mono<CurrentAccount> saveCurrentAccount(CurrentAccount currentAccount) {
		
		return createCurrentAccount.apply(Mono.just(currentAccount));
	}

	@Override
	public Mono<FixedTermAccount> saveFixedTermAccount(FixedTermAccount fixedTermAccount) {
		
		return createFixedTermAccount.apply(Mono.just(fixedTermAccount));
	}

	@Override
	public Mono<PersonalCredit> savePersonalCredit(PersonalCredit personalCredit) {
		
		return createPersonalCredit.apply(Mono.just(personalCredit));
	}

	@Override
	public Mono<SavingAccount> saveSavingAccount(SavingAccount savingAccount) {
		
		return createSavingAccount.apply(Mono.just(savingAccount));
	}
	
}
