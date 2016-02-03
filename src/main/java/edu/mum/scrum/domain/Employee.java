package edu.mum.scrum.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long employeeId;
	@NotEmpty(message="cannot be Empty")
	private String firstname;
	@NotEmpty(message="cannot be Empty")
	private String lastname;
	@NotEmpty(message="cannot be Empty")
	private String username;
	@NotEmpty(message="cannot be Empty")
	private String password;
	//@NotEmpty(message="cannot be Empty")
	private String phoneNumber;
	@Transient
	private String passwordConfirm;
	private boolean enabled;
	@Embedded
	@Valid
	private Address address;
	@OneToMany(cascade=CascadeType.ALL)
	private List<UserStory> userStories = new ArrayList<>();
	
	@Transient
	List<Long> rolesIds = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Role> roles = new HashSet<>();
	
	
	public List<Long> getRolesIds() {
		return rolesIds;
	}

	public void setRolesIds(List<Long> rolesIds) {
		this.rolesIds = rolesIds;
	}

	public void addRole(Role role){
		roles.add(role);
	}
	
	public void removeRole(Role role){
		roles.remove(role);
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	 public void addUserStory(UserStory userStory){
		 this.userStories.add(userStory);
	 }
	 public List<UserStory> getUserStory(){
		 return userStories;
	 }
	 
	 public boolean isDeveloper(){
		 if(roles.contains(new Role("DEVELOPER"))){
			 return true;
		 }
		 return false;
	 }
	 
	 
	 public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}

	public boolean isTester(){
		 if(roles.contains(new Role("TESTER"))){
			 return true;
		 }
		 return false;
	 }

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
