package edu.mum.scrum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@SuppressWarnings("unused")
public class Role {
	@Id
	@GeneratedValue
	private Long roleId;
	private String roleName;
}
