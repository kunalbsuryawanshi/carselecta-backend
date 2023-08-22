package org.program.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 2000)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "new_car_id")
	private NewCar newCar;
	
	@ManyToOne
	@JoinColumn(name = "used_car_id")
	private UsedCar usedCar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public NewCar getNewCar() {
		return newCar;
	}

	public void setNewCar(NewCar newCar) {
		this.newCar = newCar;
	}

	public UsedCar getUsedCar() {
		return usedCar;
	}

	public void setUsedCar(UsedCar usedCar) {
		this.usedCar = usedCar;
	}
	
	
}
