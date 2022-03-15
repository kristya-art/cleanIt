package org.cleaningstore.customer.model;



import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.Valid;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
//	@NotEmpty
//	@Column(name = "first_name", nullable = false)
	private String firstName;
//	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String lastName;
//	@NotNull
//	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;
//	@NotNull
//	@Size(min = 5)
	@Column(name = "password", nullable = false)
	private String password;


	@Embedded
	private Address address;

	@Embedded
	private CreditCard creditCard;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email, String password, Address address, CreditCard creditCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.creditCard = creditCard;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public CustomerInfo info() {
		return new CustomerInfo(id, firstName, lastName, email);
	}
}
