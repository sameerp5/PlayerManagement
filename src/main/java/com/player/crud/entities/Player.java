package com.player.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Age is mandatory")
	private String age;

	@NotBlank(message = "Sport is mandatory")
	private String sport;

	@NotBlank(message = "Position is mandatory")
	private String position;

	public Player() {
	}

	public Player(String name, String age, String sport, String position) {
		super();
		this.name = name;
		this.age = age;
		this.sport = sport;
		this.position = position;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", sport=" + sport + ", position=" + position
				+ "]";
	}

}
