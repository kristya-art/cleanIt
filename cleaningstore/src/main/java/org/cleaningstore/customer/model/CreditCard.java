package org.cleaningstore.customer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

@Embeddable
public class CreditCard {

//	@NotNull
	@Column(name = "card_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private CreditCardType type;
//	@NotNull
//	@Pattern(regexp = "\\d{16}")
	@Column(name = "card_number", nullable = false)
	private String number;
//	@NotNull
//	@Min(1)
//	@Max(12)
	@Column(name = "card_exp_month", nullable = false)
	private Integer expirationMonth;
//	@NotNull
//	@Min(2000)
	@Column(name = "card_exp_year", nullable = false)
	private Integer expirationYear;

	public CreditCard() {
	}

	public CreditCard(CreditCardType type, String number, Integer expirationMonth, Integer expirationYear) {
		this.type = type;
		this.number = number;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}

	public CreditCardType getType() {
		return type;
	}

	public void setType(CreditCardType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}
}
