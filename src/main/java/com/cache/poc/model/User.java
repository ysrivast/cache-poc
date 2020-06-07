package com.cache.poc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(mappedBy = "user")
	private List<Address> addresses;
	
	public static User of (String name) {
		 User user = new User();
		 user.setName(name);
		 return user;
	}
}
