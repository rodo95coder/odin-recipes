package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.products.CurrentAccount;
import com.nttdata.bootcamp.models.products.FixedTermAccount;
import com.nttdata.bootcamp.models.products.PersonalCredit;
import com.nttdata.bootcamp.models.products.SavingAccount;

import reactor.core.publisher.Mono;

public interface ITransactionOpenAccount {
	public Mono<CurrentAccount> saveCurrentAccount(CurrentAccount currentAccount);
	public Mono<FixedTermAccount> saveFixedTermAccount(FixedTermAccount fixedTermAccount);
	public Mono<PersonalCredit> savePersonalCredit(PersonalCredit personalCredit);
	public Mono<SavingAccount> saveSavingAccount(SavingAccount savingAccount);
}
