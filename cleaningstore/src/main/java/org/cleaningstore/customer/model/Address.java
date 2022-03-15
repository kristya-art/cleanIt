package org.cleaningstore.customer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
//import javax.validation.constraints.NotEmpty;

@Embeddable
public class Address {

//	@NotEmpty
	@Column(name = "addr_street", nullable = false)
	private String street;
//	@NotEmpty
	@Column(name = "addr_city", nullable = false)
	private String city;
	@Column(name = "addr_state_province")
	private String stateProvince;
//	@NotEmpty
	@Column(name = "addr_postal_code", nullable = false)
	private String postalCode;
//	@NotEmpty
	@Column(name = "addr_country", nullable = false)
	private String country;

	public Address() {
	}

	public Address(String street, String city, String stateProvince, String postalCode, String country) {
		this.street = street;
		this.stateProvince = stateProvince;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
