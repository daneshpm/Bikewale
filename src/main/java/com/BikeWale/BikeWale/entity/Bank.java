package com.BikeWale.BikeWale.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
	@Id
	private int id;
	private String name;
	private String state;
	private String district;
	private double roi;
	private String branch;
	private String ifsc;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	

}
