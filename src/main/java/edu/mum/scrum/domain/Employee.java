package edu.mum.scrum.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
@SuppressWarnings("unused")
public class Employee {
	@Id
	@GeneratedValue
	private Long employeeId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Role> roles;
	
	public void addRole(Role role){
		roles.add(role);
	}
	
	public void removeRole(Role role){
		roles.remove(role);
	}
}
