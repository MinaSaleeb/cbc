package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_number")
	private String mobileNumber;

	private String password;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="userBean")
	private List<Recipe> recipes1;

	//bi-directional many-to-many association to Recipe
	@ManyToMany
	@JoinTable(
		name="users_recipes"
		, joinColumns={
			@JoinColumn(name="user")
			}
		, inverseJoinColumns={
			@JoinColumn(name="recipe")
			}
		)
	private List<Recipe> recipes2;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Recipe> getRecipes1() {
		return this.recipes1;
	}

	public void setRecipes1(List<Recipe> recipes1) {
		this.recipes1 = recipes1;
	}

	public Recipe addRecipes1(Recipe recipes1) {
		getRecipes1().add(recipes1);
		recipes1.setUserBean(this);

		return recipes1;
	}

	public Recipe removeRecipes1(Recipe recipes1) {
		getRecipes1().remove(recipes1);
		recipes1.setUserBean(null);

		return recipes1;
	}

	public List<Recipe> getRecipes2() {
		return this.recipes2;
	}

	public void setRecipes2(List<Recipe> recipes2) {
		this.recipes2 = recipes2;
	}

}