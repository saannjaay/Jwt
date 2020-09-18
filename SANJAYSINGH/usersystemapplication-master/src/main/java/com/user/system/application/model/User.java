package com.user.system.application.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;



/**
 * @author sanjsingh
 *
 */
@Entity
@Table(name = "userdb")
@Data
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String name ;
	private String username ;
	private String passworrd;
	@ElementCollection
	@CollectionTable(
			name = "rolesdb",
			joinColumns = @JoinColumn(name="id")
			
			)
private Set<String> roles ;
	
	



}
