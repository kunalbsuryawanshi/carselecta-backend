package org.program.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class CarPricing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_pricing_id")
	private int carPricingId;

	private double exShowroomPrice;
	private double roadTax;
	private double insurance;
	private double otherCharges;
	private double optionalCharges;
	private double onRoadPrice;
	private String EMI;

	public String getEMI() {
		return EMI;
	}

	public void setEMI(String eMI) {
		EMI = eMI;
	}

	@OneToOne
	@JoinColumn(name = "new_car_id")
	@JsonBackReference
	private NewCar newCar;

	@OneToOne
	@JoinColumn(name = "used_car_id")
	private UsedCar usedCar;

	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public int getId() {
		return carPricingId;
	}

	public void setId(int carPricingId) {
		this.carPricingId = carPricingId;
	}

	public double getExShowroomPrice() {
		return exShowroomPrice;
	}

	public void setExShowroomPrice(double exShowroomPrice) {
		this.exShowroomPrice = exShowroomPrice;
	}

	public double getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}

	public double getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(double otherCharges) {
		this.otherCharges = otherCharges;
	}

	public double getOptionalCharges() {
		return optionalCharges;
	}

	public void setOptionalCharges(double optionalCharges) {
		this.optionalCharges = optionalCharges;
	}

	public double getOnRoadPrice() {
		return onRoadPrice;
	}

	public void setOnRoadPrice(double onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "CarPricing [carPricingId=" + carPricingId + ", exShowroomPrice=" + exShowroomPrice + ", roadTax="
				+ roadTax + ", insurance=" + insurance + ", otherCharges=" + otherCharges + ", optionalCharges="
				+ optionalCharges + ", onRoadPrice=" + onRoadPrice + ", EMI=" + EMI + "]";
	}
	
	

}
