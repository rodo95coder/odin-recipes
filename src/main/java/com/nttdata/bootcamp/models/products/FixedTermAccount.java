package com.nttdata.bootcamp.models.products;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FixedTermAccount {
	private String id;
	private String idCustomerPerson;
	private String accountingBalance;
	private String movementDay;
}
