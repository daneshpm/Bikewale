package com.BikeWale.BikeWale.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tax {
	@Id
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
	private Bank bank;
	private String taxname;
	private double percentage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getTaxname() {
		return taxname;
	}

	public void setTaxname(String taxname) {
		this.taxname = taxname;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
