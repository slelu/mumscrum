package edu.mum.scrum.domain;

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

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long employeeId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String phoneNumber;
	
	@Transient
	private String passwordConfirm;
	private boolean enabled;
	
	@Embedded
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<UserStory> userStories;
	
	@Transient
	List<Long> rolesIds;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Role> roles;
	
	
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


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	 public void addUserStory(UserStory userStory){
		 this.userStories.add(userStory);
	 }
	 public List<UserStory> getUserStory(){
		 return userStories;
	 }

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	 
	 

	
}
