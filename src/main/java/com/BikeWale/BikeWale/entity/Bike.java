package com.BikeWale.BikeWale.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Bike {
	@Id
	private int id;
	private String name;
	private double cost;
	private String brand;
	private double milege;
	private double cc;
	@ManyToOne(cascade = CascadeType.ALL)
    private Agent agent;

    @OneToOne(cascade = CascadeType.ALL)
    private Tax tax;

	public int getId() {
		return id;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getMilege() {
		return milege;
	}

	public void setMilege(double milege) {
		this.milege = milege;
	}

	public double getCc() {
		return cc;
	}

	public void setCc(double cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", name=" + name + ", cost=" + cost + ", brand=" + brand + ", milege=" + milege
				+ ", cc=" + cc + "]";
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}
    
}
