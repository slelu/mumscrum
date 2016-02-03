package edu.mum.scrum.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address {
	@NotEmpty(message="cannot be Empty")
	private String street;
	@NotEmpty(message="cannot be Empty")
	private String zipcode;
	@NotEmpty(message="cannot be Empty")
	private String city;
	@NotEmpty(message="cannot be Empty")
	private String country;
	@NotEmpty(message="cannot be Empty")
	private String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
