package com.BikeWale.BikeWale.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Schema(description = "Bank details used for bike loans and tax payments")
public class Bank {
	@Id
	@Schema(description = "Unique Bank ID", accessMode = Schema.AccessMode.READ_ONLY)
	private int id;
	@Schema(description = "Bank name", requiredMode = Schema.RequiredMode.REQUIRED)
	private String name;
	@Schema(description = "Which state")
	private String state;
	@Schema(description = "Which district")
	private String district;
	@Schema(description = "Rate of interest")
	private double roi;
	@Schema(description = "Branch location")
	private String branch;
	@Schema(description = "IFSC code", example = "HDFC0001234")
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
