package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userdetail_id", referencedColumnName = "id")
	private UserDetails userdetails;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "address_id", referencedColumnName = "id")
//	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Address> address;

	@ManyToOne
	private Role role;

	@ManyToMany
	@JoinTable(name = "usersProjectsMapping", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
	private List<Project> projects;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	private List<Role> role;

//	public List<Role> getRole() {
//		return role;
//	}
//
//	public void setRole(List<Role> role) {
//		this.role = role;
//	}

	private String error;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
